//MaxHeap 
//Joshua Jenkins and Russell Rickards
import java.util.*;
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private int classCounter;
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
        checkIntegrity();
        // Assertion: integrityOK == true
        // Copy given array to data field
        for (int index = 0; index < entries.length; index++)
        {
            heap[index + 1] = entries[index];
            lastIndex++;
        }
        // Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
        reheap(rootIndex);

    } // end constructor

    public void add(T newEntry)
    {
        checkIntegrity(); // Ensure initialization of data fields
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        } // end while
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    } // end add
    
    public int addCounter(T newEntry)
    {
        checkIntegrity(); // Ensure initialization of data fields
        int counter = 0;
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            counter++;
        } // end while
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
        return counter;
    } // end add

    public T remove()
    {
        checkIntegrity(); // Ensure initialization of data fields
        T root = null;
        if (!isEmpty())
        {
            root = heap[1]; // Return value
            heap[1] = heap[lastIndex]; // Form a semiheap
            lastIndex--; // Decrease size
            reheap(1); // Transform to a heap
        } // end if
        return root;
    } // end removeMax

    public T getMax()
    {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
            root = heap[1];
        return root;
    } // end getMax

    public boolean isEmpty()
    {
        return lastIndex < 1;
    } // end isEmpty

    public int getSize()
    {
        return lastIndex;
    } // end getSize

    public void clear()
    {
        checkIntegrity();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        } // end while
        lastIndex = 0;
    } // end clear

    private void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex) )
        {
            int largerChildIndex = leftChildIndex; // Assume larger
            int rightChildIndex = leftChildIndex + 1;
            if ( (rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            } // end if
            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
                classCounter++;
            }
            else
                done = true;
        } // end while
        heap[rootIndex] = orphan;
    } // end reheap

    public int getCount()
    {
        return classCounter;
    }

    public Integer[] toArrayFromTo(int beginning, int end)
    {
        Integer[] newArray = new Integer[end];
        for(int i = beginning; i<end ; i++)
        {
            newArray[i] = (Integer) heap[i];
        }
        return newArray;
    }

    public Integer[] toArray()
    {
        Integer[] newArray = new Integer[heap.length];
        for(int i = 0; i<heap.length ; i++)
        {
            newArray[i] = (Integer) heap[i];
        }
        return newArray;
    }

    public T[] getTen()
    {
        @SuppressWarnings ("unchecked")
        T[] n =  (T[]) new Integer[10]; 
        for(int i = 0; i<n.length; i++)
        {
            n[i] = heap[i+1];
        }
        return n;
    }

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a MaxHeap whose " +
                    "capacity exeeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("MaxHeap object is corrupt.");
    } // end checkIntegrity

    private void ensureCapacity()
    {
        if (lastIndex >= heap.length)
        {
            int newCapacity = 2 * (heap.length - 1);
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity);
        } // end if
    } // end ensureCapacity
}