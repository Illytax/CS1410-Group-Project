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
	
	public static void createMugtomeDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer(i.toString(), 0, "Mugtome");
			personList.add(newDevelopers);
		}
	}
	
	public static void createGogglesDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer(i.toString(), 0, "Goggles");
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
	
	public static void createMaintenanceInBuilding(int totalMaintenance)
	{
		for(Integer i = 0; i < totalMaintenance; i++)
		{
			Person newMaintenance = new Maintenance(i.toString(), 0);
			personList.add(newMaintenance);
		}
	}
	
	public static void leaveBuilding(String personLeaving)
	{
		for(Person checkPerson : floors.get(0))
		{
			if(checkPerson == new Client(personLeaving, 0))
			{
				floors.get(0).remove(checkPerson);	
			}
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
		for(Elevator allElevators : elevators)
		{
			if(allElevators.getElevatorName().equals(name))
			{
				return allElevators;
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
			//Change from .toString() to .size() to see absolute numbers instead of element identities
			System.out.println("Floor " + floorNumber + ": " + peopleInFloors.toString());
			floorNumber++;
		}
	}
}
