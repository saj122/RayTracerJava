package core;

import math.Ray;
import math.Vec3;

public class Camera
{
    Vec3 origin;
    Vec3 lower_left_corner;
    Vec3 horizontal;
    Vec3 vertical;
    Vec3 u, v, w;
    float lens_radius;

    public Camera(Vec3 look_from, Vec3 lookat, Vec3 vup, float vfov, float aspect, float aperture, float focus_dist)
    {
        lens_radius = 1/(aperture*2);
        double theta = vfov*Math.PI/180;
        double half_width = Math.tan(theta/2);
        double half_height = half_width/aspect;
        origin = look_from;
        w = Vec3.unit_vector(look_from.sub(lookat));
        u = Vec3.unit_vector(Vec3.cross(vup,w));
        v = Vec3.cross(w,u);
        lower_left_corner = origin.sub(u.mul(half_width*focus_dist)).sub(v.mul(half_height*focus_dist)).sub(w.mul(focus_dist));
        horizontal = u.mul(2*half_width*focus_dist);
        vertical = v.mul(2*half_height*focus_dist);
    }

    public Ray getRay(float s, float t)
    {
        Vec3 rd = RTUtils.randomInUnitDisk().mul(lens_radius);
        Vec3 offset = u.mul(rd.x()).sub(v.mul(rd.y()));
        return new Ray(origin.add(offset), lower_left_corner.add(horizontal.mul(s)).add(vertical.mul(t)).sub(origin).sub(offset));
    }
}
