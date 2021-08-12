package core;

public class Pair<T, V>
{
    private T first;
    private V second;

    /**
     * Constructs a new <code>Pair</code> with the given values.
     *
     * @param first  the first element
     * @param second the second element
     */
    public Pair(T first, V second)
    {

        this.first = first;
        this.second = second;
    }

    public T first() { return this.first; }

    public V second()
    {
        return this.second;
    }
}
