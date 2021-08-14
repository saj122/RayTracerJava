import core.Pair;
import core.RTUtils;
import math.Vec3;
import org.junit.jupiter.api.Test;

import static core.RTUtils.schlick;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utilities
{
    @Test
    public void testSchlick()
    {
        float ret = RTUtils.schlick(0.5f,1.0f);
        assertEquals(ret, 0.03125);
    }

    @Test
    public void testRefract()
    {
        Pair<Boolean, Vec3> ret = RTUtils.refract(new Vec3(0.5,0.5,0.5), new Vec3(0.5,0.5,0.5), 0.5f);

        assertEquals(ret.first(), true);

        assertEquals(ret.second().x(), -0.4119541346272239);
        assertEquals(ret.second().y(), -0.4119541346272239);
        assertEquals(ret.second().z(), -0.4119541346272239);
    }

    @Test
    public void testReflect()
    {
        Vec3 ret = RTUtils.reflect(new Vec3(0.5,0.5,0.5), new Vec3(0.5,0.5,0.5));

        assertEquals(ret.x(), -0.25);
        assertEquals(ret.y(), -0.25);
        assertEquals(ret.z(), -0.25);
    }
}
