import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class takes the name of a file and reads its contents into an array
 * it then uses the array to check if the file follows the format specified
 * in the assignemnt instructions and prints out the results to the console
 * 
 * @author Brayden Bowen
 */
public class FormatChecker
{
    //Instance data used by the constructor
    private static int rows;
    private static int columns;

    /**
     * This constructor takes the name of the file as a string and creates a new
     * file using said name. It then creates an array to store the data and two
     * scanners to read through the data of the file. 
     * 
     * The constructor also checks to make sure if the file follows the specific
     * format. The first two integers in the file will be how many rows and how 
     * many columns there will be. Each row and column should have a set of
     * positive or negative double values.
     * 
     * @param fileName
     */
    public FormatChecker(String fileName)
    {
        File f = new File(fileName);
        double[][] array = new double[1][1];
        boolean isValid = true;
        
        try 
        {
            //Scanner used to scan a whole line at a time
            Scanner fileScnr = new Scanner(f);
            String scannedLine = fileScnr.nextLine();

            //Scanner used to parse through each line that is scanned in
            Scanner lineScnr = new Scanner(scannedLine);

            //Values for the size of the array
            rows = lineScnr.nextInt();
            columns = lineScnr.nextInt();

            //Checks to make sure that only two values are contained in the first line of the file
            if (lineScnr.hasNext())
            {
                System.out.println(f);
                System.out.println("INVALID");
                System.out.println("");
                isValid = false;
            }

            array = new double[rows][columns];
            //Iterates through every spot in the array and fills it in with data from the file
            for (int r = 0; r < rows; r++)
            {
                scannedLine = fileScnr.nextLine();
                lineScnr = new Scanner(scannedLine);

                for (int c = 0; c < columns; c++)
                {
                    array[r][c] = lineScnr.nextDouble();
                }

                lineScnr.close();
            }

            //Checks if the number of rows of the array matches up with the desired number of rows
            if (array.length < rows || array.length > rows)
            {
                System.out.println(f);
                System.out.println("INVALID");
                System.out.println("");
            }
            //Checks if the number of columns of the array matches up with the desired number of columns
            else if (array[0].length < columns || array[0].length > columns) 
            {
                System.out.println(f);
                System.out.println("INVALID");
                System.out.println("");
            }
            //If the rows and columns both match up to their specified values and isValid remains true then the file is correctly formatted
            else if (array.length == rows && array[0].length == columns && isValid == true)
            {
                System.out.println(f);
                System.out.println("VALID");
                System.out.println("");
            }

            fileScnr.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(f);
            System.out.println("INVALID");
            System.out.println(e.toString());
            System.out.println("");
        }
        catch (NumberFormatException e)
        {
            System.out.println(f);
            System.out.println("INVALID");
            System.out.println(e.toString());
            System.out.println("");
        }
        catch (InputMismatchException e)
        {
            System.out.println(f);
            System.out.println("INVALID");
            System.out.println(e.toString());
            System.out.println("");
        }
        catch (NoSuchElementException e)
        {
            System.out.println(f);
            System.out.println("INVALID");
            System.out.println(e.toString());
            System.out.println("");
        }
    }

    public static void main(String args[]) 
    {
        for (String arg: args)
        {
            FormatChecker newArr = new FormatChecker(arg);
        }
    }
}
