package core;

import math.Ray;

public abstract class Hitable
{
    public abstract Pair<Boolean, HitRecord> hit(Ray r, float t_min, float t_max);
}
