package material;

import core.HitRecord;
import core.Material;
import core.Pair;
import core.RTUtils;
import math.Ray;
import math.Vec3;

public class Dielectric extends Material
{
    public float ref_idx;
    public Vec3 trans;
    public Dielectric(Vec3 tr, float ri)
    {
        this.ref_idx = ri;
        this.trans = tr;
    }

    @Override
    public Pair<Boolean, Pair<Vec3, Ray>> scatter(Ray r_in, HitRecord rec)
    {
        Vec3 outward_normal;
        Vec3 reflected = RTUtils.reflect(r_in.direction(), rec.normal);
        double ni_over_nt;
        Vec3 attenuation = new Vec3();
        Ray scattered = new Ray();
        attenuation.set(this.trans);
        double cosine;
        double reflect_prob;
        if(Vec3.dot(r_in.direction(), rec.normal) > 0)
        {
            outward_normal = rec.normal.mul(-1);
            ni_over_nt = ref_idx;
            cosine = Vec3.dot(r_in.direction(), rec.normal)/r_in.direction().length();
            cosine = Math.sqrt(1 - ref_idx*ref_idx*(1-cosine*cosine));
        }
        else
        {
            outward_normal = rec.normal;
            ni_over_nt = 1.0/ref_idx;
            cosine = -1*Vec3.dot(r_in.direction(), rec.normal)/r_in.direction().length();
        }

        Pair<Boolean, Vec3> ref = RTUtils.refract(r_in.direction(), outward_normal, (float)ni_over_nt);
        if(ref.first())
        {
            reflect_prob = RTUtils.schlick((float)cosine, ref_idx);
        }
        else
        {
            reflect_prob = 1;
        }
        if(Math.random() < reflect_prob)
        {
            scattered.set(new Ray(rec.p, reflected));
        }
        else
        {
            scattered.set(new Ray(rec.p, ref.second()));
        }
        return new Pair<>(true,new Pair<>(attenuation,scattered));
    }
}
