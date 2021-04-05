//MaxHeap By Joshua Jenkins and RUssell Rickards
import java.util.*;
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;      // Array of heap entries; ignore heap[0]
    private int lastIndex; // Index of last entry and number of entries
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    public MaxHeap()
    {
        this(DEFAULT_CAPACITY); // Call next constructor
    } // end default constructor

    public MaxHeap(int initialCapacity)
    {
        // Is initialCapacity too small?
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else // Is initialCapacity too big?
            checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    } // end constructor

    public MaxHeap(T[] entries)
    {
        this(entries.length); // Call other constructor
        lastIndex = entries.length;
        // Assertion: integrityOK == true
        // Copy given array to data field
        for (int index = 0; index < entries.length; index++)
            heap[index + 1] = entries[index];
        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        reheap(rootIndex);
    } // end constructor
}