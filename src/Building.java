import java.util.ArrayList;

final class Building
{
	private static int[] floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<Person> peopleInBuilding = new ArrayList<Person>();
	private static int elevatorList;
	private static int peopleList;
	
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
	
	public static void setPeopleInBuilding(String buildingPeople)
	{
		int buildingPeeps = Integer.parseInt(buildingPeople);
		for(int i = 0; i < buildingPeeps; i++)
		{
			Person currentPeopleInBuilding = new Person("P" + (i + 1), 1);
			peopleInBuilding.add(currentPeopleInBuilding);
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
	
	public static int getPeopleInBuilding()
	{
		for(int peepList = 0; peepList < peopleInBuilding.size(); peepList++)
		{
			peopleList = peepList + 1;
		}
		return peopleList;
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
