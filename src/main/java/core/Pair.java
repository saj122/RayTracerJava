/**
 * The Pair class constructs a new Pair with the given values.
 *
 * @author  Stephen Johnson
 * @version 1.0
 * @since   2021-8-14
 */

package core;

public class Pair<T, V>
{
    private T first;
    private V second;

    public Pair(T first, V second)
    {

        this.first = first;
        this.second = second;
    }

    /**
     * Returns first element in Pair.
     *
     * @return T
     */
    public T first() { return this.first; }

    /**
     * Returns second element in Pair.
     *
     * @return V
     */
    public V second()
    {
        return this.second;
    }
}
