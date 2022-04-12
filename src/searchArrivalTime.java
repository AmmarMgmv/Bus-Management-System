import java.io.FileNotFoundException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.Comparator;

public class searchArrivalTime 
{
	public static final String MAX_TIME = "24:00:00";
	
    public static ArrayList <String> parseFile(String input)
    {
    	String line;
        String arrivalTime;
    	
    	ArrayList<String> trips = new ArrayList<String>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");       
        
        try 
        {
        	File file = new File("./inputs/stop_times.txt");
        	Scanner scanner = new Scanner(file);
        	Scanner currentLine = null;
        	
        	Date inputTime = format.parse(input);
        	Date maxTime = format.parse(MAX_TIME);
            
            System.out.println("Here are all the trips with your arrival time sorted by ID");
            scanner.nextLine();
            
            while (scanner.hasNextLine()) 
            { 
                line = scanner.nextLine();
                currentLine = new Scanner(line);
                currentLine.useDelimiter(",");
                currentLine.next();
                arrivalTime = currentLine.next(); 
                Date currentArrivalTime = format.parse(arrivalTime);
                if (inputTime.getTime() == currentArrivalTime.getTime() && currentArrivalTime.getTime() < maxTime.getTime()) {
                    trips.add(line);
                }
            }
            trips.sort(Comparator.naturalOrder());
            return trips;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found!");
        }
        catch (Exception e) 
        {
            System.out.println("Error!");
        }
        return null;
    }
}