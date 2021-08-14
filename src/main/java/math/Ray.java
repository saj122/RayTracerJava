package math;

public class Ray
{
    private Vec3 origin;
    private Vec3 end;
    public Ray(Vec3 a, Vec3 b){ origin = a; end = b;}

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
        sb.append(end.x());
        sb.append(",");
        sb.append(end.y());
        sb.append(",");
        sb.append(end.z());
        sb.append(")");
        return sb.toString();
    }

    public Vec3 origin() { return origin; }
    public Vec3 direction() { return end; }
    public Vec3 point_at_parameter(double t) { return origin.add(end.mul(t)); }
    public void set(Ray r)
    {
        origin = r.origin;
        end = r.end;
    }
}

