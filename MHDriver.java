//MaxHeap Driver By Joshua Jenkins and Russell Rickards
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class MHDriver
{
    public static void main(String[] args) throws FileNotFoundException
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
                System.out.println(list[i]);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}