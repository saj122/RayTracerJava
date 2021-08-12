package core;

import math.Ray;
import math.Vec3;

import java.util.List;

public abstract class Material
{
    public abstract Pair<Boolean, Pair<Vec3,Ray>> scatter(Ray r_in, HitRecord rec);
}
