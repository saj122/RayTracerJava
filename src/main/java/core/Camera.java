/**
 * The Camera class implements the camera for setting the preferences of the view for rendering.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

import math.Ray;
import math.Vec3;

public class Camera
{
    /**
     * Declared Vec3 for the origin of the camera,
     * declared Vec3 for the lower left corner of the view plane,
     * declared Vec3 for the horizontal vector of the camera,
     * declared Vec3 for the vertical vector of the camera.
     * Declared Vec3 for the u vector of image plane, the v vector of
     * the image plane, and the forward vector of the camera.
     * Declared float for lens radius.
     */
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

    /**
     * Function returns ray emitted from the lens of the camera.
     * @param s The horizontal pixel position of camera.
     * @param t The vertical pixel position of camera.
     * @return Ray.
     */
    public Ray getRay(float s, float t)
    {
        Vec3 rd = RTUtils.randomInUnitDisk().mul(lens_radius);
        Vec3 offset = u.mul(rd.x()).sub(v.mul(rd.y()));
        return new Ray(origin.add(offset), lower_left_corner.add(horizontal.mul(s)).add(vertical.mul(t)).sub(origin).sub(offset));
    }
}
