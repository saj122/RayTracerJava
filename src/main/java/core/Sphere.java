package core;

import math.Ray;
import math.Vec3;

public class Sphere extends Hitable
{
    private Vec3 center;
    private float radius;
    private Material mat;

    public Sphere(Vec3 cen, float r, Material m)
    {
        this.center = cen;
        this.radius = r;
        this.mat = m;
    }

    @Override
    public Pair<Boolean, HitRecord> hit(Ray r, float t_min, float t_max)
    {
        HitRecord rec = new HitRecord();
        Vec3 oc = r.origin().sub(center);
        double a = Vec3.dot(r.direction(),r.direction());
        double b = Vec3.dot(oc, r.direction());
        double c = Vec3.dot(oc,oc) - radius*radius;
        double discriminant = b*b - a*c;
        if(discriminant >= 0)
        {
            rec.mat = mat;
            rec.h = this;
            double temp = (-b - Math.sqrt(discriminant))/a;
            if(temp < t_max && temp > t_min)
            {
                rec.t = temp;
                rec.p = r.point_at_parameter(rec.t);
                rec.normal = rec.p.sub(center).div(radius);
                return new Pair<>(true, rec);
            }
            temp = (-b + Math.sqrt(discriminant))/a;
            if(temp < t_max && temp > t_min)
            {
                rec.t = temp;
                rec.p = r.point_at_parameter(rec.t);
                rec.normal = rec.p.sub(center).div(radius);
                return new Pair<>(true, rec);
            }
        }
        return new Pair<>(false, rec);
    }
}
