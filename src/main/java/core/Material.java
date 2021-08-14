/**
 * The Material class is the base implementation of materials and contains
 * a function for calculating the scattering of light from surface.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

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
     * @return Pair.
     */
    public abstract Pair<Boolean, Pair<Vec3,Ray>> scatter(Ray r_in, HitRecord rec);
}
