//MaxHeap Driver By Joshua Jenkins and Russell Rickards
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class MHDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Random Data: \n");
        readRandom();
        System.out.println("\nSorted Data: \n");
        readSorted();
        int[] sortedArraySeq = new int[100];
        int[] sortedArrayOpt = new int[100];
        int[] randomArraySeq = new int[100];
        int[] randomArrayOpt = new int[100];
        sortedArraySeq = arraySorted();
        sortedArrayOpt = arraySorted();
        randomArraySeq = arrayRandom();
        randomArrayOpt = arrayRandom();
    }

    public static void readRandom()
    {
        try
        {
            int counter = 0;
            Scanner fileR = new Scanner(new File("data_random.txt"));
            int n;
            int[] list = new int[100];
            while(fileR.hasNextLine())
            {
                n = fileR.nextInt();
                list[counter] = n;
                counter++;
            }
            fileR.close();
            for(int i = 0; i<list.length;i++)
            {
                System.out.print(list[i] + ", ");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readSorted()
    {
        try
        {
            int counter = 0;
            Scanner fileR = new Scanner(new File("data_sorted.txt"));
            int n;
            int[] list = new int[100];
            while(fileR.hasNextLine())
            {
                n = fileR.nextInt();
                list[counter] = n;
                counter++;
            }
            fileR.close();
            for(int i = 0; i<list.length;i++)
            {
                System.out.print(list[i] + ", ");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }





    public static int[] arrayRandom()
    {
        try
        {
            int counter = 0;
            Scanner fileR = new Scanner(new File("data_random.txt"));
            int n;
            int[] list = new int[100];
            while(fileR.hasNextLine())
            {
                n = fileR.nextInt();
                list[counter] = n;
                counter++;
            }
            fileR.close();
            return list;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public static int[] arraySorted()
    {
        try
        {
            int counter = 0;
            Scanner fileR = new Scanner(new File("data_sorted.txt"));
            int n;
            int[] list = new int[100];
            while(fileR.hasNextLine())
            {
                n = fileR.nextInt();
                list[counter] = n;
                counter++;
            }
            fileR.close();
            return list;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }






    public static void randomSequentialMaxHeap(int[] n)
    {
        MaxHeap heap = new MaxHeap();
       for(int i = 0; i<n.length; i++)
       {
            heap.add(n[i]);
       }
    }























































    public static void randomOptimalMaxHeap(int[] n)
    {
        File file = new File("outputFile.txt");
        int ten = 10;
        try
        {
            PrintWriter outputfile = new PrintWriter(file);
            MaxHeap heap = new MaxHeap();    
            int counter = 0;
            for(int i = 0; i<n.length; i++)
            {
                public MaxHeap(T[] entries)
                {
                    this(entries.length);
                    assert initialized = true;
                    for(int index = 0; index < entries.length; index++)
                        heap[index + 1] = entries[index];
        
                    for (int rootIndex = lastIndex / 2; root > 0; rootIndex--)
                        reheap(rootIndex);
                }
            } 
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
}
}