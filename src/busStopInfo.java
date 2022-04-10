import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class busStopInfo 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new busStopInfo("./inputs/stops.txt");
	}
	
	busStopInfo(String filename)
	{
		String stop_desc;
		String stop_name;
		int stop_id;
		
		try 
		{	
			File file = new File(filename);
			Scanner input = new Scanner(file);
			input.useDelimiter(",");
			input.nextLine();
			while(input.hasNextInt())
			{
				stop_id = Integer.parseInt(input.next());
				input.next();
				stop_name = input.next();
				stop_desc = input.next();
				input.nextLine();
				
				System.out.println("Stop Id: " + stop_id + "\nStop Name: " + stop_name + "\nStop Description: " + stop_desc);
			}
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
