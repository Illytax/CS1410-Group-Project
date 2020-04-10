import java.util.ArrayList;
import java.util.PriorityQueue;

final class Building
{
	private static int floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<PriorityQueue<Person>> floors = new ArrayList<PriorityQueue<Person>>();
	
	public static int getSizeOfFloors()
	{
		return floorsInBuilding;
	}
	
	public static ArrayList<PriorityQueue<Person>> getFloors()
	{
		return floors;
	}

	public static PriorityQueue<Person> getPeople(int floorNumber)
	{
		return floors.get(floorNumber);
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
		return elevators.size();
	}
	
	public static void setFloors(int floorNumbers)
	{
		floorsInBuilding = floorNumbers;
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
		for(PriorityQueue<Person> currentQueue : floors)
		{
			count += currentQueue.size();
		}
		return count;
	}
	
	public static void showPeopleOnEachFloor()
	{
		int floorNumber = 0;
		for(PriorityQueue<Person> peopleInFloors : floors)
		{
			System.out.println("There are " + peopleInFloors.size() + " People on floor " + floorNumber);
			floorNumber++;
		}
	}
}
