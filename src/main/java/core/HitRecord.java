package core;

import math.Vec3;

public class HitRecord
{
    public double t;
    public Vec3 p;
    public Vec3 normal;
    public Material mat;
    public Hitable h;

    public void set(HitRecord hr)
    {
        t = hr.t;
        p = hr.p;
        normal = hr.normal;
        mat = hr.mat;
        h = hr.h;
    }
}
