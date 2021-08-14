/**
 * The Scene class encapsulates the scene and renders
 * it. It contains functions for saving the image.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

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
import java.util.Random;

public class Scene
{
    /**
     * Recursive function for calculating the color of the pixel the ray
     * is emitted from.
     * @param r This is the ray to be emitted.
     * @param world This is the world scene of hitables.
     * @param depth How many times to sample the pixel.
     * @return Vec3.
     */
    private static Vec3 ray_color(Ray r, Hitable world, int depth)
    {
        Pair<Boolean, HitRecord> wh = world.hit(r,0.001f,Float.MAX_VALUE);
        if(wh.first())
        {
            Pair<Boolean, Pair<Vec3,Ray>> sa = wh.second().mat.scatter(r,wh.second());
            if(depth < 50 && sa.first())
            {
                if(sa.second().second().direction().squared_length() == 0)
                {
                    return sa.second().first();
                }
                return ray_color(sa.second().second(),world,depth+1).mul(sa.second().first());
            }
            else
            {
                return new Vec3(0,0,0);
            }
        }
        else
        {
            Vec3 unit_dir = Vec3.unit_vector(r.direction());
            double t = 0.5*(unit_dir.y() + 1.0);
            return new Vec3(1.0,1.0,1.0).mul(1.0-t).add(new Vec3(0.5,0.7,1.0).mul(t));
        }
    }

    /**
     * Static function for building the
     * environment to be rendered.
     * @return Hitable.
     */
    public static Hitable buildScene()
    {
        List<Hitable> list = new ArrayList<>();

        list.add(new Sphere(new Vec3(0,-1000,0),1000, new Lambertian(new Vec3(0.5,0.5,0.5))));

        Random r = new Random();
        for(int i = 0;i < 2;++i)
        {
            double x = -4.0 + r.nextDouble() * (8.0);
            double y = 0.5 + r.nextDouble() * (0.75-0.5);
            double z = -4.0 + r.nextDouble() * (8.0);
            list.add(new Sphere(new Vec3(x, y, z), 0.5f, new Metal(new Vec3(0.5, 0.5, 0.5), 0.1f)));

            x = -4.0 + r.nextDouble() * (8.0);
            y = 0.5 + r.nextDouble() * (0.75-0.5);
            z = -4.0 + r.nextDouble() * (8.0);
            list.add(new Sphere(new Vec3(x, y, z), 0.5f, new Lambertian(new Vec3(0.7, 0.6, 0.5))));

            x = -4.0 + r.nextDouble() * (8.0);
            y = 0.5 + r.nextDouble() * (0.75-0.5);
            z = -4.0 + r.nextDouble() * (8.0);
            list.add(new Sphere(new Vec3(x, y, z), 0.5f, new Dielectric(new Vec3(0.7, 0.6, 0.5), 1.5f)));
        }

        return new Hitables(list);
    }

    /**
     * Static function for rendering the scene.
     * @param cam Camera of the scene.
     * @param world Scene of objects used to do hit tests.
     * @param image_width Image width.
     * @param image_height Image height.
     * @param samples_per_pixel Samples per pixel of image.
     * @return BufferedImage.
     */
    public static BufferedImage render(Camera cam, Hitable world, int image_width, int image_height, int samples_per_pixel)
    {
        BufferedImage image = new BufferedImage(image_width,image_height,BufferedImage.TYPE_INT_RGB);
        for (int j = image_height-1; j >= 0; j--)
        {
            for (int i = 0; i < image_width; i++)
            {
                Vec3 col = new Vec3(0.0f, 0.0f, 0.0f);
                for (int s = 0; s < samples_per_pixel; s++)
                {
                    float u = (float) (i + Math.random()) / (float) (image_width);
                    float v = (float) (j + Math.random()) / (float) (image_height);
                    Ray r = cam.getRay(u, v);
                    col = col.add(Scene.ray_color(r, world, 0));
                }

                col = col.div(samples_per_pixel);
                col = new Vec3(Math.sqrt(col.r()), Math.sqrt(col.g()), Math.sqrt(col.b())); //gamma
                Color c = new Color((int) (255 * col.r()), (int) (255 * col.g()), (int) (255 * col.b()));
                image.setRGB(i, image_height - j - 1, c.getRGB());
            }
        }
        return image;
    }

    /**
     * Static function for saving the rendered scene as image.
     * @param image Image to be saved.
     * @see IOException
     */
    public static void saveImage(BufferedImage image)
    {
        File outputFile = new File("output.bmp");
        try
        {
            ImageIO.write(image, "bmp", outputFile);
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
    }
}
