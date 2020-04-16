import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javafx.scene.control.TextField;

final class Building
{
	private static TextField floor_TextField;
	private static TextField elevator_TextField;
	private static TextField elevatprCapacity_TextField;
	private static TextField ticks_TextField;
	private static TextField employee_TextField;
	private static TextField goggleDev_TextField;
	private static TextField mugtomeDev_TextField;
	private static int floorsInBuilding = Integer.parseInt(floor_TextField.getText());
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

	public static Queue<Person> getPeopleOnAFloor(int floorNumber)
	{
		return floors.get(floorNumber);
	}
	
	public static void setElevators(int Elevators)
	{
		for(int i = 0; i < Elevators; i++)
		{
			Elevator currentElevator = new Elevator("e" + (i + 1));
			elevators.add(currentElevator);
		}
	}
	
	public static void createPeopleInBuilding(int seed)
	{
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
			Person newClient = new Client();
			floors.get(0).add(newClient);
		}
	}
	
	public static void createMugtomeDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer("Mugtome");
			personList.add(newDevelopers);
		}
	}
	
	public static void createGogglesDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer("Goggles");
			personList.add(newDevelopers);
		}
	}
	
	public static void createEmployeesInBuilding(int totalEmployees)
	{
		for(Integer i = 0; i < totalEmployees; i++)
		{
			Person newEmployees = new Employee();
			personList.add(newEmployees);
		}
	}
	
	public static void createMaintenanceInBuilding(double probability)
	{
		if(probability < 0.005)
		{
			Person newMaintenance = new Maintenance();
			floors.get(0).add(newMaintenance);
		}
	}
	
	public static ArrayList<Elevator> getElevators()
	{
		return elevators;
	}
	
	public static void setFloors(int floorNumbers)
	{
		floorsInBuilding = floorNumbers;
		for(int i = 0; i < getSizeOfFloors(); i++) 
		{
		   floors.add(new LinkedList<Person>());
		}
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
