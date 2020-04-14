import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

final class Building
{
	private static int floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<Person> personList = new ArrayList<Person>();
	private static ArrayList<Queue<Person>> floors = new ArrayList<Queue<Person>>();
	
	public static int getSizeOfFloors()
	{
		return floorsInBuilding;
	}
	
	public static ArrayList<Queue<Person>> getFloors()
	{
		return floors;
	}

	public static Queue<Person> getPeople(int floorNumber)
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
	
	public static void createPeopleInBuilding(int seed)
	{
		
		for(int i = 0; i < getSizeOfFloors(); i++) 
		{
		   floors.add(new LinkedList<Person>());
		}
		Queue<Person> tempQueue = floors.get(0);
		Collections.shuffle(personList, new Random(seed));
		//System.out.println(personList.toString());
		for(Person allPeople : personList)
		{
			tempQueue.add(allPeople);
		}
	}
	
	public static void createClientInBuilding()
	{
		if(Client.newQ() < Person.returnProbQ())
		{
			Person newClient = new Client(0);
			floors.get(0).add(newClient);
		}
	}
	
	public static void createMugtomeDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer(0, "Mugtome");
			personList.add(newDevelopers);
		}
	}
	
	public static void createGogglesDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer(0, "Goggles");
			personList.add(newDevelopers);
		}
	}
	
	public static void createEmployeesInBuilding(int totalEmployees)
	{
		for(Integer i = 0; i < totalEmployees; i++)
		{
			Person newEmployees = new Employee(0);
			personList.add(newEmployees);
		}
	}
	
	public static void createMaintenanceInBuilding()
	{
		if(Maintenance.newQ() < 0.005)
		{
			Person newMaintenance = new Maintenance(0);
			floors.get(0).add(newMaintenance);
		}
	}
	
	public static void leaveBuilding(String personLeaving)
	{
		for(Person checkPerson : floors.get(0))
		{
			if(checkPerson == new Client(0))
			{
				floors.get(0).remove(checkPerson);	
			}
		}
	}
	
	public static ArrayList<Elevator> getElevators()
	{
		return elevators;
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
	
	public static LinkedList<Person> getAllPeopleInAllFloors()
	{
		LinkedList<Person> allPeople = new LinkedList<Person>();
		for(Queue<Person> peopleInFloors : floors)
		{
			for(Person people : peopleInFloors)
			{
				allPeople.add(people);
			}
		}
		return allPeople;
	}
	
	public static void showPeopleOnEachFloor()
	{
		int floorNumber = 0;
		for(Queue<Person> peopleInFloors : floors)
		{
			//Change from .toString() to .size() to see absolute numbers instead of element identities
			System.out.println("Floor " + floorNumber + ": " + peopleInFloors.toString());
			floorNumber++;
		}
	}
}
