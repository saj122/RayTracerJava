package core;

import math.Ray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hitables extends Hitable
{
    public List<Hitable> list = new ArrayList<>();

    public Hitables() {}
    public Hitables(List<Hitable> l)
    {
        this.list = l;
    }

    @Override
    public Pair<Boolean, HitRecord> hit(Ray r, float t_min, float t_max) {
        HitRecord temp_rec = new HitRecord();
        boolean hit_anything = false;
        double closest_so_far = t_max;
        for(int i = 0; i<list.size(); i++)
        {
            Pair<Boolean,HitRecord> bhr = list.get(i).hit(r, t_min, (float)closest_so_far);
            if(bhr.first())
            {
                temp_rec = bhr.second();
                hit_anything = true;
                closest_so_far = temp_rec.t;
            }
        }
        return new Pair<>(hit_anything, temp_rec);
    }
}
