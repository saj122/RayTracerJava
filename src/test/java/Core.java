import core.HitRecord;
import core.Material;
import core.Pair;
import core.Sphere;
import material.Lambertian;
import math.Ray;
import math.Vec3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Core
{
    @Test
    public void testRaySphereIntersection()
    {
        Vec3 center = new Vec3(0.5,0.5,0.5);
        float r = 0.5f;
        Material mat = new Lambertian(new Vec3(0.5f,0.5f,0.5f));
        Sphere sphere = new Sphere(center, r, mat);

        Ray ray = new Ray(new Vec3(0.25,0.25,0.25), new Vec3(0.75,0.75,0.75));
        float t_min = 0.1f;
        float t_max = 10.0f;
        Pair<Boolean, HitRecord> ret = sphere.hit(ray, t_min, t_max);

        assertEquals(ret.first(), true);

        assertEquals(ret.second().p.x(), 100.0);
        assertEquals(ret.second().p.y(), 0.7886751345948129);
        assertEquals(ret.second().p.z(), 0.7886751345948129);

        assertEquals(ret.second().normal.x(), 0.5773502691896257);
        assertEquals(ret.second().normal.y(), 0.5773502691896257);
        assertEquals(ret.second().normal.z(), 0.5773502691896257);
    }
}
