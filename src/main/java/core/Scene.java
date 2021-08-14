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

public class Scene
{
    private static Vec3 ray_color(Ray r, Hitable world, int depth)
    {
        Pair<Boolean, HitRecord> wh = world.hit(r,0.001f,Float.MAX_VALUE);
        if(wh.first())
        {
            Pair<Boolean, Pair<Vec3,Ray>> sa = wh.second().mat.scatter(r,wh.second());
            if(depth < 5 && sa.first())
            {
                if(sa.second().second().end.squared_length() == 0)
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

    public static Hitable buildScene()
    {
        List<Hitable> list = new ArrayList<>();

        list.add(new Sphere(new Vec3(0,-1000,0),1000, new Lambertian(new Vec3(0.5,0.5,0.5))));
        list.add(new Sphere(new Vec3(-3.0, 0.7, 0.0), 0.5f, new Metal(new Vec3(0.5, 0.5, 0.5), 0.1f)));
        list.add(new Sphere(new Vec3(3.0, 0.7, 0.0), 0.5f, new Lambertian(new Vec3(0.7, 0.6, 0.5))));
        list.add(new Sphere(new Vec3(1.0, 0.7, 0.0), 0.5f, new Dielectric(new Vec3(0.5,0.5,0.5), 1.5f)));

        return new Hitables(list);
    }

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
