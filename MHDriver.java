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
        int[] randomArraySeq = new int[100];
        int[] sortedArrayOpt = new int[100];
        int[] randomArrayOpt = new int[100];
        sortedArraySeq = arraySorted();
        sortedSequentialMaxHeap(sortedArraySeq);
        randomArraySeq = arrayRandom();
        randomSequentialMaxHeap(randomArraySeq);
        sortedArrayOpt = arraySorted();
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
//Sequential Inserstion Methods
//


//***************************
//Sorted Sequential Insertion
    public static void sortedSequentialMaxHeap(int[] n)
    {
        File file = new File("outputFileSequentialSorted.txt");
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

//***************************
//Random Sequential Insertion

    public static void randomSequentialMaxHeap(int[] n)
    {
        File file = new File("outputFileSequentialRandom.txt");
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
//random Optimal
    public static void randomOptimalMaxHeap(int[] n)
    {
        File file = new File("outputFileOptimalRandom.txt");
        try
        {
        PrintWriter outputFile = new PrintWriter(file);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        int counter = 0;
        int ten = 10;
            for(int i = 0; i<n.length; i++)
            {
                counter = counter + heap.reheapCounter(n[i]);
                if(i<10)
                {
                    outputFile.write("First 10 integers: " + String.valueOf(n[i]) + "\n");
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

//sorted Optimal   
    public static void sortedOptimalMaxHeap(int[] n)
{
        File file = new File("outputFileOptimalSorted.txt");
        try
        {
        PrintWriter outputFile = new PrintWriter(file);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(100);
        int counter = 0;
        int ten = 10;
            for(int i = 0; i<n.length; i++)
            {
                counter = counter + heap.reheapCounter(n[i]);
                if(i<10)
                {
                    outputFile.write("First 10 integers: " + String.valueOf(n[i]) + "\n");
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
}
