import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class userInterface 
{
	public static void main(String[] args) 
	{
        System.out.println("Please select one of the options below:"); 
        System.out.println("Press 1 to find the shortest path between two bus stops");
        System.out.println("Press 2 to get information on a specific bus stop");
        System.out.println("Press 3 to search for all trips with a given arrival time");
        System.out.println("Press 0 to exit the program");
        
        Scanner input = new Scanner(System.in);
        
        int option = -1;
        option = input.nextInt();

        if (option == 2) 
        {
        	System.out.println("Which stop are you searching for?");
        	String stopName = input.next().toUpperCase();
        	findBusStopInfo(stopName);
        }

        if (option == 3) {
        	System.out.println("Please enter arrival time (HH:MM:SS):");
        	String timeIn = input.nextLine();
        	String item = input.next();
        	findArrivalTime(item);
        }
	}


	
	//Use this to find the information on the bus stop
	private static void findBusStopInfo(String stopName)
	{
		busStopInfo tst = new busStopInfo("./inputs/stops.txt");
    	Iterable<String> allStops = tst.keysWithPrefix(stopName);
    	int count = 0;
    	for (String key : allStops) 
    	{
    		System.out.println("" + tst.get(key));
    		count++;
    	}
    	if (count == 0) 
    	{
    		System.out.println("No matching stops were found");
    	}
	}

	//Use this to find trips with specific arrival times
	private static void findArrivalTime(String time) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		try 
		{
			Date minTime = dateFormat.parse("00:00:00");
			Date maxTime = dateFormat.parse("24:00:00");
			
			Date arrivalTime = dateFormat.parse(time);
			if (minTime.getTime() < arrivalTime.getTime() && arrivalTime.getTime() < maxTime.getTime()) 
			{
				
				ArrayList<String> test = searchArrivalTime.parseFile(time);
				if (test.size() != 0) 
				{
					for (int i = 0; i < test.size(); i++) 
					{
						System.out.println(test.get(i));
					}
				} 
				else
				{
					System.out.println("There were to trips with your specified arrival time.");
				}
			} 
			else
			{
				System.out.println("Please input a valid time between 00:00:00 and 23:59:59");
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Error!");
		}
	}
}
