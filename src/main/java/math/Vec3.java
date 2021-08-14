package math;

public class Vec3
{
    public double[] xyz = new double[3];
    public Vec3(){}
    public Vec3(double x, double y, double z)
    {
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(xyz[0]);
        sb.append(",");
        sb.append(xyz[1]);
        sb.append(",");
        sb.append(xyz[2]);
        sb.append(")");
        return sb.toString();
    }

    public double x() {return xyz[0];}
    public double y() {return xyz[1];}
    public double z() {return xyz[2];}

    public double r() {return xyz[0];}
    public double g() {return xyz[1];}
    public double b() {return xyz[2];}

    public double length()
    {
        return Math.sqrt(xyz[0]*xyz[0]+xyz[1]*xyz[1]+xyz[2]*xyz[2]);
    }

    public double squared_length()
    {
        return xyz[0]*xyz[0]+xyz[1]*xyz[1]+xyz[2]*xyz[2];
    }

    public Vec3 add(Vec3 v2)
    {
        return new Vec3(xyz[0] + v2.xyz[0], xyz[1] + v2.xyz[1], xyz[2] + v2.xyz[2]);
    }

    public Vec3 sub(Vec3 v2)
    {
        return new Vec3(xyz[0] - v2.xyz[0], xyz[1] - v2.xyz[1], xyz[2] - v2.xyz[2]);
    }

    public Vec3 div(Vec3 v2)
    {
        return new Vec3(xyz[0] / v2.xyz[0], xyz[1] / v2.xyz[1], xyz[2] / v2.xyz[2]);
    }

    public Vec3 div(double t)
    {
        return new Vec3(xyz[0] / t, xyz[1] / t, xyz[2] / t);
    }

    public Vec3 mul(Vec3 v2)
    {
        return new Vec3(xyz[0] * v2.xyz[0], xyz[1] * v2.xyz[1], xyz[2] * v2.xyz[2]);
    }

    public Vec3 mul(double t)
    {
        return new Vec3(xyz[0] * t, xyz[1] * t, xyz[2] * t);
    }

    public static double dot(Vec3 v1, Vec3 v2)
    {
        return v1.xyz[0] * v2.xyz[0] + v1.xyz[1] * v2.xyz[1] + v1.xyz[2] * v2.xyz[2];
    }

    public static Vec3 cross(Vec3 v1, Vec3 v2)
    {
        return new Vec3((v1.xyz[1]*v2.xyz[2] - v1.xyz[2]*v2.xyz[1]),
                -(v1.xyz[0]*v2.xyz[2] - v1.xyz[2]*v2.xyz[0]),
                (v1.xyz[0]*v2.xyz[1] - v1.xyz[1]*v2.xyz[0]));
    }

    public void unit()
    {
        double k = 1.0/length();
        xyz[0] *= k; xyz[1] *= k; xyz[2] *= k;
    }

    public static Vec3 unit_vector(Vec3 v)
    {
        return v.div(v.length());
    }

    public void set(Vec3 v)
    {
        xyz[0] = v.xyz[0];
        xyz[1] = v.xyz[1];
        xyz[2] = v.xyz[2];
    }
}
