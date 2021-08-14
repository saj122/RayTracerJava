/**
 * The Metal class implements the metal materials
 * light ray scatter function.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package material;

import core.HitRecord;
import core.Material;
import core.Pair;
import core.RTUtils;
import math.Ray;
import math.Vec3;

public class Metal extends Material
{
    /**
     * Declared float variable for fuzziness for larger spheres and a
     * Vec3 for the color.
     */
    private float fuzz;
    private Vec3 albedo;

    public Metal(Vec3 a, float f)
    {
        this.albedo = a;
        if(f < 1.0f)
        {
            this.fuzz = f;
        }
        else
        {
            this.fuzz = 1.0f;
        }
    }

    @Override
    public Pair<Boolean, Pair<Vec3, Ray>> scatter(Ray r_in, HitRecord rec)
    {
        Vec3 reflected = RTUtils.reflect(Vec3.unit_vector(r_in.direction()), rec.normal);
        Ray scattered = new Ray(rec.p, reflected.add(RTUtils.randomInUnitSphere().mul(fuzz)));
        Vec3 attenuation = albedo;
        return new Pair<>(Vec3.dot(scattered.direction(), rec.normal) > 0,new Pair<>(attenuation, scattered));
    }
}
