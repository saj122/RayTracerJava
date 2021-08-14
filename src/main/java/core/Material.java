package core;

import math.Ray;
import math.Vec3;

import java.util.List;

public abstract class Material
{
    /**
     * Function returns if light ray is scattered, scattering direction, and resultant ray.
     * @param r_in Input ray that hit sphere.
     * @param rec HitRecord of the intersected ray.
     * @return Pair<Boolean, Pair<Vec3, Ray>>.
     */
    public abstract Pair<Boolean, Pair<Vec3,Ray>> scatter(Ray r_in, HitRecord rec);
}
