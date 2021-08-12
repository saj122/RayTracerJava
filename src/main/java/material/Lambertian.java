package material;

import core.HitRecord;
import core.Material;
import core.Pair;
import core.RTUtils;
import math.Ray;
import math.Vec3;

public class Lambertian extends Material
{
    Vec3 albedo;

    public Lambertian(Vec3 a)
    {
        this.albedo = a;
    }

    @Override
    public Pair<Boolean, Pair<Vec3, Ray>> scatter(Ray r_in, HitRecord rec)
    {
        Ray scattered = new Ray();
        Vec3 attenuation = new Vec3();
        Vec3 target = rec.p.add(rec.normal).add(RTUtils.randomInUnitSphere());
        scattered.set(new Ray(rec.p, target.sub(rec.p)));
        attenuation.set(albedo);
        Pair<Vec3,Ray> sa = new Pair<>(attenuation, scattered);
        return new Pair<>(true, sa);
    }
}
