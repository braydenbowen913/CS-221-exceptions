import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FormatChecker
{

    public static void main(String args[]) 
    {
        for (String arg: args)
        {
            File f = new File(arg);
            int[][] array = new int[1][1];

            try 
            {
                Scanner fileScnr = new Scanner(f);
                String scannedLine = fileScnr.nextLine();

                Scanner lineScnr = new Scanner(scannedLine);

                int width = lineScnr.nextInt();
                int length = lineScnr.nextInt();



                fileScnr.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println(e.toString());
            }
            catch (NumberFormatException e)
            {
                System.out.println(e.toString());
            }
            catch (InputMismatchException e)
            {
                System.out.println(e.toString());
            }
        }
    }
}
