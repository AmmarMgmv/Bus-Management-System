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
        	busStopInfo tst = new busStopInfo("./inputs/stops.txt");
        }
	}
}
