//MaxHeap Driver By Joshua Jenkins and Russell Rickards
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.PrintWriter;
public class MHDriver
{
    public static void main(String[] args)
    {
        try
        {
            int counter = 0;
            File file = new File("data_random.txt");
            if (!file.exists())
            {
                System.out.println("ERROR: file does not exist");
                System.exit(0);
            }
            Scanner fileR = new Scanner(file);
            Scanner fileZ = new Scanner(file);
            int n;
            while(fileZ.hasNext())
            {
                counter++;
            }
            int[] list = new int[counter];
            counter = 0;
            while(fileR.hasNext())
            {
                n = fileR.nextInt();
                list[counter] = n;
                counter++;
            }
            fileR.close();
            fileZ.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}