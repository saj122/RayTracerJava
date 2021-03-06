/**
 * The RTUtils class contains utility functions for
 * scattering of light and random unit vector generation.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

import math.Vec3;

public class RTUtils
{
    /**
     * Static function for calculating the approximation of the contribution of the
     * fresnal factor in the specular relection of light from a non-conducting interface.
     * @param cosine This is the cosine angle of light.
     * @param ref_idx This is the index of refraction.
     * @return float.
     */
    public static float schlick(float cosine, float ref_idx)
    {
        float r0 = (1.0f - ref_idx) / (1.0f + ref_idx);
        r0 = r0*r0;
        double invCos = 1.0f - cosine;
        return r0 + (1.0f-r0)*((float)Math.pow(invCos, 5.0));
    }

    /**
     * Static function for calculating the refraction direction of light.
     * @param v This is the vector to surface.
     * @param n This is the normal vector to surface.
     * @param ni_over_nt This is the ratio of refraction.
     * @return Pair.
     */
    public static Pair<Boolean, Vec3> refract(Vec3 v, Vec3 n, float ni_over_nt)
    {
        Vec3 refracted = new Vec3(0.0,0.0,0.0);
        Vec3 uv = Vec3.unit_vector(v);
        double dt = Vec3.dot(uv,n);
        double discriminant = 1.0 - ni_over_nt*ni_over_nt*(1-dt*dt);
        if(discriminant > 0)
        {
            refracted.set(uv.sub(n.mul(dt)).mul(ni_over_nt).sub(n.mul(Math.sqrt(discriminant))));
            return new Pair<>(true, refracted);
        }
        else
        {
            return new Pair<>(false, refracted);
        }
    }

    /**
     * Static function for calculating the reflection direction of light.
     * @param v This is the vector to surface.
     * @param n This is the normal vector to surface.
     * @return Vec3.
     */
    public static Vec3 reflect(Vec3 v, Vec3 n)
    {
        return v.sub(n.mul(Vec3.dot(v,n)*2));
    }

    /**
     * Static function for calculating a random vector direction on a unit sphere.
     * @return Vec3.
     */
    public static Vec3 randomInUnitSphere()
    {
        Vec3 p;
        do
        {
            p = new Vec3(Math.random(),Math.random(),Math.random()).mul(2).sub(new Vec3(1,1,1));
        } while(p.squared_length() >= 1.0);
        return p;
    }

    /**
     * Static function for calculating a random vector direction on a unit disk.
     * @return Vec3.
     */
    public static Vec3 randomInUnitDisk()
    {
        Vec3 p;
        do
        {
            p = new Vec3(Math.random(),Math.random(),0).mul(2).sub(new Vec3(1,1,0));
        } while(Vec3.dot(p,p) >= 1.0);
        return p;
    }
}
