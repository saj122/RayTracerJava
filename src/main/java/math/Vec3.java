/**
 * The Vec3 class implements various vector operations
 * on two vectors or itself.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package math;

public class Vec3
{
    /**
     * Declared double array for holding
     * (x,y,z) vector coordinates.
     */
    private double[] xyz = new double[3];

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

    /**
     * Function returns the x coordinate of the vector.
     * @return double.
     */
    public double x() {return xyz[0];}

    /**
     * Function returns the y coordinate of the vector.
     * @return double.
     */
    public double y() {return xyz[1];}

    /**
     * Function returns the z coordinate of the vector.
     * @return double.
     */
    public double z() {return xyz[2];}

    /**
     * Function returns the red index of the vector if using as color.
     * @return double.
     */
    public double r() {return xyz[0];}

    /**
     * Function returns the green index of the vector if using as color.
     * @return double.
     */
    public double g() {return xyz[1];}

    /**
     * Function returns the blue index of the vector if using as color.
     * @return double.
     */
    public double b() {return xyz[2];}

    /**
     * Function returns the length of the vector.
     * @return double.
     */
    public double length()
    {
        return Math.sqrt(xyz[0]*xyz[0]+xyz[1]*xyz[1]+xyz[2]*xyz[2]);
    }

    /**
     * Function returns the squared length of the vector.
     * @return double.
     */
    public double squared_length()
    {
        return xyz[0]*xyz[0]+xyz[1]*xyz[1]+xyz[2]*xyz[2];
    }

    /**
     * Function returns a vector sum two vector being added together.
     * @param v2 This is the vector to be added.
     * @return Vec3.
     */
    public Vec3 add(Vec3 v2)
    {
        return new Vec3(xyz[0] + v2.xyz[0], xyz[1] + v2.xyz[1], xyz[2] + v2.xyz[2]);
    }

    /**
     * Function returns a vector difference of two vectors being subtracted from one another.
     * @param v2 This is the vector to be subtracted.
     * @return Vec3.
     */
    public Vec3 sub(Vec3 v2)
    {
        return new Vec3(xyz[0] - v2.xyz[0], xyz[1] - v2.xyz[1], xyz[2] - v2.xyz[2]);
    }

    /**
     * Function returns a vector division of two vectors divided from one another.
     * @param v2 This is the vector to be divided.
     * @return Vec3.
     */
    public Vec3 div(Vec3 v2)
    {
        return new Vec3(xyz[0] / v2.xyz[0], xyz[1] / v2.xyz[1], xyz[2] / v2.xyz[2]);
    }

    /**
     * Function returns a vector divided by a scalar.
     * @param t This is the scalar the vector is divided.
     * @return Vec3.
     */
    public Vec3 div(double t)
    {
        return new Vec3(xyz[0] / t, xyz[1] / t, xyz[2] / t);
    }

    /**
     * Function returns a vector multiplied by another vector.
     * @param v2 This is the vector to be multiplied.
     * @return Vec3.
     */
    public Vec3 mul(Vec3 v2)
    {
        return new Vec3(xyz[0] * v2.xyz[0], xyz[1] * v2.xyz[1], xyz[2] * v2.xyz[2]);
    }

    /**
     * Function returns a vector multiplied by a scalar.
     * @param t This is the scalar to be multiplied.
     * @return Vec3.
     */
    public Vec3 mul(double t)
    {
        return new Vec3(xyz[0] * t, xyz[1] * t, xyz[2] * t);
    }

    /**
     * Static function that returns the dot product of two vectors.
     * @param v1 This is the first vector.
     * @param v2 This is the second vector.
     * @return double.
     */
    public static double dot(Vec3 v1, Vec3 v2)
    {
        return v1.xyz[0] * v2.xyz[0] + v1.xyz[1] * v2.xyz[1] + v1.xyz[2] * v2.xyz[2];
    }

    /**
     * Static function that returns the cross product of two vectors.
     * @param v1 This is the first vector.
     * @param v2 This is the second vector.
     * @return Vec3.
     */
    public static Vec3 cross(Vec3 v1, Vec3 v2)
    {
        return new Vec3((v1.xyz[1]*v2.xyz[2] - v1.xyz[2]*v2.xyz[1]),
                -(v1.xyz[0]*v2.xyz[2] - v1.xyz[2]*v2.xyz[0]),
                (v1.xyz[0]*v2.xyz[1] - v1.xyz[1]*v2.xyz[0]));
    }

    /**
     * Function that turns the vector into a unit vector.
     */
    public void unit()
    {
        double k = 1.0/length();
        xyz[0] *= k; xyz[1] *= k; xyz[2] *= k;
    }

    /**
     * Static function that turns the parameter vector into a unit vector and returns it.
     * @param v Vector to be turned into unit vector.
     * @return Vec3.
     */
    public static Vec3 unit_vector(Vec3 v)
    {
        return v.div(v.length());
    }

    /**
     * Function that sets vector to v.
     * @param v Vector to be set.
     */
    public void set(Vec3 v)
    {
        xyz[0] = v.xyz[0];
        xyz[1] = v.xyz[1];
        xyz[2] = v.xyz[2];
    }
}
