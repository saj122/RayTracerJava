/**
 * The HitRecord class contains the recording of intersection
 * of ray with shape.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

import math.Vec3;

public class HitRecord
{
    /**
     * Declared double holding the distance along the ray,
     * declared a Vec3 for the point of intersection, Vec3
     * for the normal to the surface, material of surface,
     * and hitable the intersected with the ray.
     */
    public double t;
    public Vec3 p;
    public Vec3 normal;
    public Material mat;
    public Hitable h;
}
