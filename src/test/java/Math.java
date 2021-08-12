import math.Vec3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Math
{
    @Test
    public void testAddVec3()
    {
        Vec3 e1 = new Vec3(1.0f, 2.0f, 3.0f);
        Vec3 e2 = new Vec3(1.0f, 2.0f, 3.0f);

        Vec3 e3 = MathUtils.addVecs(e1,e2);

        assertEquals(e3.x(),2.0f);
        assertEquals(e3.y(),4.0f);
        assertEquals(e3.z(),6.0f);
    }

    @Test
    public void testNegateVec3()
    {
        Vec3 e1 = new Vec3(1.0f, 2.0f, 3.0f);
        Vec3 e2 = e1.negate();

        assertEquals(e2.x(),-1.0f);
        assertEquals(e2.y(),-2.0f);
        assertEquals(e2.z(),-3.0f);
    }

    @Test
    public void testMakeUnitVec3()
    {
        Vec3 e1 = new Vec3(1.0f, 2.0f, 2.0f);
        Vec3 e2 = e1.make_unit_vector();
        assertEquals(e2.x(), 1.0f/3.0f);
        assertEquals(e2.y(), 2.0f/3.0f);
        assertEquals(e2.z(), 2.0f/3.0f);
    }

    @Test
    public void testScaleVec3()
    {
        Vec3 e1 = new Vec3(1.0f, 2.0f, 3.0f);
        float k = 2.0f;

        Vec3 e2 = e1.scale(k);

        assertEquals(e2.x(),2.0f);
        assertEquals(e2.y(),4.0f);
        assertEquals(e2.z(),6.0f);
    }
}
