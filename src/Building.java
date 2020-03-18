import java.util.ArrayList;

final class Building
{
	private static int[] floorsInBuilding;
	
	static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	
	static int elevatorList;
	
	public static int[] getNumberOfFloors()
	{
		return floorsInBuilding;
	}
	
	public static int getSizeOfFloors()
	{
		return floorsInBuilding.length;
	}
	
	public static void setElevators(String Elevators)
	{
		int elevatorNumbers = Integer.parseInt(Elevators);
		for(int i = 0; i < elevatorNumbers; i++)
		{
			Elevator currentElevator = new Elevator("e" + (i + 1));
			elevators.add(currentElevator);
		}
	}
	
	public static int getElevators()
	{
		for(int elevList = 0; elevList < elevators.size(); elevList++)
		{
			elevatorList = elevList + 1;
		}
		return elevatorList;
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
	
	public static Elevator getAnElevator(String name)
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
