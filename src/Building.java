import java.util.ArrayList;

final class Building
{
	private static int[] floorsInBuilding;
	
	static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	
	public static int[] getNumberOfFloors()
	{
		return floorsInBuilding;
	}
	
	public static int getSizeOfFloors()
	{
		return floorsInBuilding.length;
	}
	
	public static void addElevators(int Elevators)
	{
		for(int i = 0; i < Elevators; i++)
		{
			Elevator currentElevator = new Elevator("e" + (i + 1));
			elevators.add(currentElevator);
		}
	}
	
	public static ArrayList<Elevator> returnList()
	{
		return elevators;
	}
	
	public static void setFloors(String floorString)
	{
		int floorNumbers = Integer.parseInt(floorString);
		floorsInBuilding = new int[floorNumbers];
		for(int i = 0; i < floorNumbers; i++)
		{
			floorsInBuilding[i] = i + 1;
		}
	}
	
	public static Elevator getElevator(String name)
	{
		for(Elevator e : elevators)
		{
			if(e.getElevatorName().equals(name))
			{
				return e;
			}
		}
		return null;
	}
}
