//MaxHeap Driver By Joshua Jenkins and Russell Rickards
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class MHDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
            int counter = 0;
            File file = new File("C:\\Users\\dajoe\\Desktop\\CS2400-Project-4\\data_random.txt");
            if(file.exists())
            {
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
            for(int i = 0; i<list.length;i++)
            {
                System.out.println(list[i]);
            }
            }
        else
        {
            System.out.println("An error occurred.");
            System.exit(0);
        }
    }
}