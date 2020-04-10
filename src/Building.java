import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

final class Building
{
	private static int floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<Person> personList = new ArrayList<Person>();
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
	
	public static void createPeopleInBuilding()
	{
		
		for(int i = 0; i < getSizeOfFloors(); i++) 
		{
		   floors.add(new PriorityQueue<Person>());
		}
		PriorityQueue<Person> tempQueue = floors.get(0);
		Collections.shuffle(personList);
		System.out.println(personList.toString());
		for(Person allPeople : personList)
		{
			tempQueue.add(allPeople);
		}
	}
	
	public static void createClientsInBuilding(int totalClients)
	{
		for(Integer i = 0; i < totalClients; i++)
		{
			Person newClient = new Client(i.toString(), 0);
			personList.add(newClient);
		}
	}
	
	public static void createDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer(i.toString(), 0, "Mugtome");
			personList.add(newDevelopers);
		}
	}
	
	public static void createEmployeesInBuilding(int totalEmployees)
	{
		for(Integer i = 0; i < totalEmployees; i++)
		{
			Person newEmployees = new Employee(i.toString(), 0);
			personList.add(newEmployees);
		}
	}
	
	public static void createMaintananceInBuilding(int totalMaintanance)
	{
		for(Integer i = 0; i < totalMaintanance; i++)
		{
			Person newMaintanance = new Maintanance(i.toString(), 0);
			personList.add(newMaintanance);
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
