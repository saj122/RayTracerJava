import core.HitRecord;
import core.Pair;
import material.Dielectric;
import material.Lambertian;
import material.Metal;
import math.Ray;
import math.Vec3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Materials
{
    @Test
    public void testLambertianScatter()
    {
        Lambertian lmbn = new Lambertian(new Vec3(0.5,0.4,0.2));

        Ray ray = new Ray(new Vec3(0.0,0.0,0.0),new Vec3(1.0,1.0,1.0));
        HitRecord hr = new HitRecord();
        hr.p = new Vec3(0.5,0.5,0.5);
        hr.normal = new Vec3(0.5,0.5,0.5);

        Pair<Boolean, Pair<Vec3, Ray>> lmbnScatter = lmbn.scatter(ray, hr);
        assertEquals(lmbnScatter.first(), true);

        // Can only test origin as end is randomly generated from surface.
        assertEquals(lmbnScatter.second().second().origin.x(), 0.5);
        assertEquals(lmbnScatter.second().second().origin.y(), 0.5);
        assertEquals(lmbnScatter.second().second().origin.z(), 0.5);

        assertEquals(lmbnScatter.second().first().x(), 0.5);
        assertEquals(lmbnScatter.second().first().y(), 0.4);
        assertEquals(lmbnScatter.second().first().z(), 0.2);
    }

    @Test
    public void testMetalScatter()
    {
        Metal mn = new Metal(new Vec3(0.5,0.3,0.2), 0.5f);

        Ray ray = new Ray(new Vec3(0.0,0.0,0.0),new Vec3(1.0,1.0,1.0));
        HitRecord hr = new HitRecord();
        hr.p = new Vec3(0.5,0.5,0.5);
        hr.normal = new Vec3(0.5,0.5,0.5);

        Pair<Boolean, Pair<Vec3, Ray>> mnScatter = mn.scatter(ray, hr);
        System.out.println(mnScatter.first());
        System.out.println(mnScatter.second().second());

    }

    @Test
    public void testDielectricScatter()
    {
        Dielectric dm = new Dielectric(new Vec3(0.5,0.4,0.2), 0.5f);

        Ray ray = new Ray(new Vec3(0.0,0.0,0.0),new Vec3(1.0,1.0,1.0));
        HitRecord hr = new HitRecord();
        hr.p = new Vec3(0.5,0.5,0.5);
        hr.normal = new Vec3(0.5,0.5,0.5);

        Pair<Boolean, Pair<Vec3, Ray>> dmScatter = dm.scatter(ray, hr);
        System.out.println(dmScatter.first());
        System.out.println(dmScatter.second().second());
    }
}
