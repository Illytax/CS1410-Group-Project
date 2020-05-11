package elevatorSimulation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javafx.scene.control.TextField;

/**
 * This class is the Building that creates the Elevator(s), floors
 * and the Person(s) inside the Building
 * @author Edward Jordan 180130678
 * @version 1.0
 *
 */
final class Building
{
	private static int floorsInBuilding;
	private static ArrayList<Elevator> elevators = new ArrayList<Elevator>();
	private static ArrayList<Person> personList = new ArrayList<Person>();
	private static ArrayList<Queue<Person>> floors = new ArrayList<Queue<Person>>();
	
	/**
	 * Number of floors in the building
	 * @return the number of floors in the building
	 */
	public static int getSizeOfFloors()
	{
		return floorsInBuilding;
	}
	
	/**
	 * Gets total number of queues of people
	 * @return the number of Queue<Person> within the ArrayList<> floors
	 */
	public static ArrayList<Queue<Person>> getFloors()
	{
		return floors;
	}
	
	/**
	 * This methods gets the number of people on each floor
	 * @param floorNumber the floor level in the building
	 * @return the number of Person(s) within that Queue<Person>
	 */
	public static Queue<Person> getPeopleOnAFloor(int floorNumber)
	{
		return floors.get(floorNumber);
	}
	
	/**
	 * Creates the Elevator(s) in the Building
	 * @param Elevators creates as many Elevator(s) as that amount
	 */
	public static void setElevators(int Elevators)
	{
		for(int i = 0; i < Elevators; i++)
		{
			Elevator currentElevator = new Elevator("e" + (i + 1));
			elevators.add(currentElevator);
		}
	}
	
	/**
	 * This method randomises the order of created people in the Building
	 * @param seed gets and int that allows Random to create repeatable results
	 */
	public static void shufflePeopleInBuilding(int seed)
	{
		Queue<Person> tempQueue = floors.get(0);
		Collections.shuffle(personList, new Random(seed));
		//System.out.println(personList.toString());
		for(Person allPeople : personList)
		{
			tempQueue.add(allPeople);
		}
	}
	
	/**
	 * A Client will arrive on the ground floor of the Building
	 * if the probability is less than probability of q
	 */
	public static void createClientInBuilding(int nubmerOfFloors)
	{
		if(Client.newQ() < Person.returnProbQ())
		{
			Person newClient = new Client(nubmerOfFloors);
			floors.get(0).add(newClient);
		}
	}
	
	/**
	 * This method creates the amount of Mugtome Developer(s) in the simulation
	 * @param totalMugtomeDevelopers the number of Mugtome Developer created in the Building
	 */
	public static void createMugtomeDevelopersInBuilding(int totalMugtomeDevelopers, int numberOfFloors)
	{
		for(Integer i = 0; i < totalMugtomeDevelopers; i++)
		{
			Person newDevelopers = new Developer("Mugtome",  numberOfFloors);
			personList.add(newDevelopers);
		}
	}
	
	/**
	 * This method creates the amount of Goggles Developer(s) in the simulation
	 * @param totalGogglesDevelopers the number of Goggles Developer created in the Building
	 */
	public static void createGogglesDevelopersInBuilding(int totalGogglesDevelopers, int numberOfFloors)
	{
		for(Integer i = 0; i < totalGogglesDevelopers; i++)
		{
			Person newDevelopers = new Developer("Goggles", numberOfFloors);
			personList.add(newDevelopers);
		}
	}
	
	/**
	 * This method creates the amount of Employee(s) in the simulation
	 * @param totalEmployees the maximum number of Employee(s) in the Building
	 */
	public static void createEmployeesInBuilding(int totalEmployees, int numberOfFloors)
	{
		for(Integer i = 0; i < totalEmployees; i++)
		{
			Person newEmployees = new Employee(numberOfFloors);
			personList.add(newEmployees);
		}
	}
	
	/**
	 * This method creates a Maintenance team in the Building
	 * @param probability the likelihood a maintenance team will be created
	 */
	public static void createMaintenanceInBuilding(double probability, int numberOfFloors)
	{
		if(probability < 0.005)
		{
			Person newMaintenance = new Maintenance(numberOfFloors);
			floors.get(0).add(newMaintenance);
		}
	}
	
	/**
	 * This method returns the Elevator(s) in the Building
	 * @return all the elevator in the building
	 */
	public static ArrayList<Elevator> getElevators()
	{
		return elevators;
	}
	
	/**
	 * Creates the floors in the Building
	 * @param floorNumbers number of floors in the building
	 */
	public static void setFloors(int floorNumbers)
	{
		floorsInBuilding = floorNumbers;
		for(int i = 0; i < getSizeOfFloors(); i++) 
		{
		   floors.add(new LinkedList<Person>());
		}
	}
	
	/**
	 * Iterates through all created Elevator(s)
	 * to find any with a name matching the parameter
	 * @param name the name of the Elevator
	 * @return allElevators if an Elevator has the same name as the given parameter
	 */
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
	
	/**
	 * This method is used to iterate through all Person(s) in the Building
	 * @return allPeople shows how many Person(s) are in the Building
	 */
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
	
	/**
	 * This method outputs in console how many people are in each floor
	 */
	public static void showPeopleOnEachFloor()
	{
		int floorNumber = 0;
		for(Queue<Person> peopleInFloors : floors)
		{
			//Change from .toString() to .size() to see absolute numbers instead of element identities
			System.out.println("Floor " + floorNumber + ": " + peopleInFloors.toString());
			floorNumber++;
		}
		System.out.println("");
	}
	
	/**
	 * Checks through the ground floor to see if a Client
	 * has complained, if so they leave the Building
	 */
	public static void removeAComplainingClient()
	{
		Queue<Person> peopleOnGroundFloor = Building.getPeopleOnAFloor(0);
		for(Person person : peopleOnGroundFloor)
		{
			if(person instanceof Client)
			{
				Client complainingClient = (Client) person;
				if(complainingClient.toBeDisposed)
				{
					Building.getPeopleOnAFloor(0).remove(person);
				}	
			}
		}
	}
}
