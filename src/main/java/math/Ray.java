/**
 * The Ray class implements operations on a ray of
 * the form O+t*D. O being the origin and D being the
 * direction.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package math;

public class Ray
{
    /**
     * Declared two vectors for holding
     * the origin and direction vectors of the ray.
     */
    private Vec3 origin;
    private Vec3 dir;
    public Ray(Vec3 a, Vec3 b){ origin = a; dir = b;}

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Origin: (");
        sb.append(origin.x());
        sb.append(",");
        sb.append(origin.y());
        sb.append(",");
        sb.append(origin.z());
        sb.append(")");
        sb.append("\n");
        sb.append("End: (");
        sb.append(dir.x());
        sb.append(",");
        sb.append(dir.y());
        sb.append(",");
        sb.append(dir.z());
        sb.append(")");
        return sb.toString();
    }

    /**
     * Function returns the origin of the ray.
     * @return Vec3.
     */
    public Vec3 origin() { return origin; }

    /**
     * Function returns the direction of the ray.
     * @return Vec3.
     */
    public Vec3 direction() { return dir; }

    /**
     * Function returns the point multiplied by scalar along ray.
     * @param t Scalar to be multiplied.
     * @return Vec3.
     */
    public Vec3 point_at_parameter(double t) { return origin.add(dir.mul(t)); }

    /**
     * Function sets ray to the parameter ray.
     * @param r Ray to set.
     */
    public void set(Ray r)
    {
        origin = r.origin();
        dir = r.direction();
    }
}

