import java.util.ArrayList;

final class Building
{
	private static int[] Floors;
	
	static ArrayList<Elevator> elevatorList = new ArrayList<Elevator>(); 
	//private static ArrayList<Integer> FloorList = new ArrayList<Integer>();
	
	public static int[] returnArray()
	{
		return Floors;
	}
	
	public static int returnArraySize()
	{
		return Floors.length;
	}
	
	public static void addElevators(int e)
	{
		for(int i = 0; i < e; i++)
		{
			Elevator currentElevator = new Elevator();
			elevatorList.add(currentElevator);
		}
	}
	
	public static ArrayList<Elevator> returnList()
	{
		return elevatorList;
	}
	
	public static void setFloors(String floorString)
	{
		int floorNumbers = Integer.parseInt(floorString);
		Floors = new int[floorNumbers];
		for(int i = 0; i < floorNumbers; i++)
		{
			Floors[i] = i + 1;
		}
	}
}
