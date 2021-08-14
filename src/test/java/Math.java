import math.Vec3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Math
{
    @Test
    public void testAddVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 3.0);
        Vec3 e2 = new Vec3(1.0, 2.0, 3.0);

        Vec3 e3 = e1.add(e2);

        assertEquals(e3.x(),2.0);
        assertEquals(e3.y(),4.0);
        assertEquals(e3.z(),6.0);
    }

    @Test
    public void testSubVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 3.0);
        Vec3 e2 = new Vec3(1.0, 2.0, 3.0);

        Vec3 e3 = e1.sub(e2);

        assertEquals(e3.x(),0.0);
        assertEquals(e3.y(),0.0);
        assertEquals(e3.z(),0.0);
    }

    @Test
    public void testNegateVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 3.0);
        Vec3 e2 = e1.mul(-1.0);

        assertEquals(e2.x(),-1.0);
        assertEquals(e2.y(),-2.0);
        assertEquals(e2.z(),-3.0);
    }

    @Test
    public void testMakeUnitVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 2.0);
        e1.unit();
        assertEquals(e1.x(), 1.0/3.0);
        assertEquals(e1.y(), 2.0/3.0);
        assertEquals(e1.z(), 2.0/3.0);
    }

    @Test
    public void testMulVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 3.0);
        double k = 2.0;

        Vec3 e2 = e1.mul(k);

        assertEquals(e2.x(),2.0);
        assertEquals(e2.y(),4.0);
        assertEquals(e2.z(),6.0);
    }

    @Test
    public void testMulVecVec3()
    {
        Vec3 e1 = new Vec3(1.0, 2.0, 3.0);
        Vec3 e2 = new Vec3(1.0,2.0,3.0);

        Vec3 e3 = e1.mul(e2);

        assertEquals(e3.x(),1.0);
        assertEquals(e3.y(),4.0);
        assertEquals(e3.z(),9.0);
    }

    @Test
    public void testDivVec3()
    {
        Vec3 e1 = new Vec3(3.0, 3.0, 3.0);
        Vec3 e2 = e1.div(3.0);

        assertEquals(e2.x(),1.0);
        assertEquals(e2.y(),1.0);
        assertEquals(e2.z(),1.0);
    }

    @Test
    public void testDivVecVec3()
    {
        Vec3 e1 = new Vec3(3.0, 3.0, 3.0);
        Vec3 e2 = new Vec3(3.0, 3.0, 3.0);
        Vec3 e3 = e1.div(e2);

        assertEquals(e3.x(),1.0);
        assertEquals(e3.y(),1.0);
        assertEquals(e3.z(),1.0);
    }
}
