/**
 * The Hitables class keeps track of all hitable's hit during rendering.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

import math.Ray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Hitables extends Hitable
{
    /**
     * Declared list for holding the
     * hit objects in the scene.
     */
    private List<Hitable> list = new ArrayList<>();

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

        for(Hitable hit : list)
        {
            Pair<Boolean,HitRecord> hit_rec = hit.hit(r, t_min,(float) closest_so_far);
            if(hit_rec.first())
            {
                temp_rec = hit_rec.second();
                hit_anything = true;
                closest_so_far = temp_rec.t;
            }
        }

        return new Pair<>(hit_anything, temp_rec);
    }
}
