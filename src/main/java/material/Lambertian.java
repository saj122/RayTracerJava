/**
 * The Lambertian class implements the matte materials
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

public class Lambertian extends Material
{
    /**
     * Declared Vec3 for the color.
     */
    private Vec3 albedo;

    public Lambertian(Vec3 a)
    {
        this.albedo = a;
    }

    @Override
    public Pair<Boolean, Pair<Vec3, Ray>> scatter(Ray r_in, HitRecord rec)
    {
        Ray scattered = new Ray(new Vec3(0.0,0.0,0.0), new Vec3(0.0,0.0,0.0));
        Vec3 attenuation = new Vec3(0.0,0.0,0.0);
        Vec3 target = rec.p.add(rec.normal).add(RTUtils.randomInUnitSphere());
        scattered.set(new Ray(rec.p, target.sub(rec.p)));
        attenuation.set(albedo);
        Pair<Vec3,Ray> sa = new Pair<>(attenuation, scattered);
        return new Pair<>(true, sa);
    }
}
