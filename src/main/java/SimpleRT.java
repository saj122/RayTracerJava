/**
 * The RayTracer program implements an application that
 * ray traces an environment of spheres and returns a rendered image.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

import core.*;
import material.Dielectric;
import material.Lambertian;
import material.Metal;
import math.Ray;
import math.Vec3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleRT
{
    public static void main(String[] args)
    {
        Hitable world = Scene.buildScene();

        Vec3 lookfrom = new Vec3(13.0f, 4.0f, 3.0f);
        Vec3 lookat = new Vec3(0.0f,0.0f,0.0f);
        float dist_to_focus = 10.0f;
        float aperture = 7.0f;


        float aspect_ratio = 16.0f / 9.0f;
        int image_width = 1280;
        int image_height = (int)(image_width / aspect_ratio);
        int samples_per_pixel = 1000;

        StringBuilder sb = new StringBuilder();
        sb.append("P3\n");
        sb.append(image_width);
        sb.append(" ");
        sb.append(image_height);
        sb.append("\n255\n");

        System.out.println(sb.toString());

        Camera cam = new Camera(lookfrom, lookat, new Vec3(0.0f,1.0f,0.0f), 40.0f, aspect_ratio, aperture, dist_to_focus);
        BufferedImage image = Scene.render(cam,world,image_width,image_height,samples_per_pixel);
        Scene.saveImage(image);
    }
}
