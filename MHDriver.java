//MaxHeap Driver 
//By Joshua Jenkins and Russell Rickards
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
        SequentialMaxHeap(sortedArraySeq);
        sortedArrayOpt = arraySorted();
        randomArraySeq = arrayRandom();
        SequentialMaxHeap(randomArraySeq);
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

//   
//Sequential Inserstion Method
//
    public static void SequentialMaxHeap(int[] n)
    {
        File file = new File("outputFile.txt");
        try
        {
        PrintWriter outputFile = new PrintWriter(file);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        int counter = 0;
        int ten = 10;
            for(int i = 0; i<n.length; i++)
            {
                counter = counter + heap.addCounter(n[i]);
                if(i<10)
                {
                    outputFile.write("First 10 integers: " + String.valueOf(n[i]) + "\n");
                    System.out.println("randomSequentialMaxHeap first 10: " + n[i]);
                }
            }
            heap.toString();
            outputFile.write("Swaps: " + String.valueOf(counter) + "\n");
            while(ten>0)
            {
                heap.remove();
                ten--;
            }
            for(int j = 0; j<10;j++)
            {
            outputFile.write("After removal: " + String.valueOf(heap.remove()) + "\n");
            }
            outputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//Optimal Method


















   public static void randomOptimalMaxHeap(int[] n)
    {
        File file = new File("outputFile.txt");
        try
        {
        PrintWriter outputFile = new PrintWriter(file);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        int counter = 0;
        int ten = 10;
            for(int i = 0; i<n.length; i++)
            {
                //counter = counter + heap.addCounter(n[i]);
                heap.add(n[i]);
                if(i<10)
                {
                    outputFile.write(String.valueOf(n[i]) + ", ");
                    System.out.println("randomOptimalMaxHeap first 10: " + n[i]);
                }
            }
            heap.toString();
            outputFile.write(String.valueOf(counter));
            while(ten>0)
            {
                heap.remove();
                ten--;
            }
            for(int j = 0; j<10;j++)
            {
            outputFile.write(String.valueOf(heap.remove()));
            }
            outputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void sortedOptimalMaxHeap(int[] n)
    {
        File file = new File("outputFile.txt");
        try
        {
        PrintWriter outputFile = new PrintWriter(file);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        int counter = 0;
        int ten = 10;
            for(int i = 0; i<n.length; i++)
            {
                //counter = counter + heap.addCounter(n[i]);
                heap.add(n[i]);
                if(i<10)
                {
                    outputFile.write(String.valueOf(n[i]) + ", ");
                    System.out.println("sortedOptimalMaxHeap first 10: " + n[i]);
                }
            }
            heap.toString();
            outputFile.write(String.valueOf(counter));
            while(ten>0)
            {
                heap.remove();
                ten--;
            }
            for(int j = 0; j<10;j++)
            {
            outputFile.write(String.valueOf(heap.remove()));
            }
            outputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}