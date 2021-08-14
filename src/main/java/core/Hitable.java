/**
 * The Hitable class implements hit function for
 * calculating ray intersection tests for various shapes.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

import math.Ray;

public abstract class Hitable
{
    /**
     * Function returns a HitRecord of intersection of ray with shape.
     * @param r Ray to be intersected.
     * @param t_min Minimum distance of ray from origin.
     * @param t_max Maximum distance of ray from origin.
     * @return Pair<Boolean, HitRecord>.
     */
    public abstract Pair<Boolean, HitRecord> hit(Ray r, float t_min, float t_max);
}
