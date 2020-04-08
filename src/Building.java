import java.util.ArrayList;
import java.util.PriorityQueue;

final class Building
{
	private static int[] floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<PriorityQueue<Person>> floors = new ArrayList<PriorityQueue<Person>>();
	private static int elevatorList;
	
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
	
	public static void createPeopleInBuilding(int totalPeople)
	{
		for(int i = 0; i < getSizeOfFloors(); i++) 
		{
		  //add an empty floor
		   floors.add(new PriorityQueue<Person>());
		}
		
		for(Integer i = 0; i < totalPeople; i++)
		{
			PriorityQueue<Person> tempQueue = floors.get(0);
			tempQueue.add(new Person(i.toString(), 0));
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
			floorsInBuilding[i] = i;
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

	public static int getPeopleInBuilding()
	{
		int count = 0;
		for( PriorityQueue<Person> currentQueue : floors)
		{
			count += currentQueue.size();
		}
		return count;
	}
}
