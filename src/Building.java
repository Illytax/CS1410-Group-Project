import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * This class is the building that will contain the elevators
 * and the people inside them
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
	 * number of floors in the building
	 * @return the number of floors in the building
	 */
	public static int getSizeOfFloors()
	{
		return floorsInBuilding;
	}
	
	/**
	 * gets people in each floor
	 * @return number of people in floor
	 */
	public static ArrayList<Queue<Person>> getFloors()
	{
		return floors;
	}
	
	/**
	 * this methods gets the floor each person is on
	 * @param floorNumber the floor level in the building
	 * @return what floor the elevator was on
	 */
	public static Queue<Person> getPeopleOnAFloor(int floorNumber)
	{
		return floors.get(floorNumber);
	}
	
	/**
	 * determines how many elevator in the building
	 * @param Elevators this is the objects that transports people from floor to floor
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
	 * this method creates people in the building and puts them on the ground floor
	 * and then randomises the list the people are in
	 * @param seed is used to generate a pseudo-random number 
	 */
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
	
	/**
	 * a Client will arrive if the probability is less than probability of q
	 */
	public static void createClientInBuilding()
	{
		if(Client.newQ() < Person.returnProbQ())
		{
			Person newClient = new Client();
			floors.get(0).add(newClient);
		}
	}
	
	/**
	 * this method creates how many Mugtome developers are in the simulation at the beginning
	 * and restricts any more developers from entering
	 * @param totalDevelopers the maximum number of developers in the building
	 */
	public static void createMugtomeDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer("Mugtome");
			personList.add(newDevelopers);
		}
	}
	
	/**
	 * this method creates how many Goggles developers are in the simulation at the beginning
	 * and restricts any more developers from entering
	 * @param totalDevelopers the maximum number of developers in the building
	 */
	public static void createGogglesDevelopersInBuilding(int totalDevelopers)
	{
		for(Integer i = 0; i < totalDevelopers; i++)
		{
			Person newDevelopers = new Developer("Goggles");
			personList.add(newDevelopers);
		}
	}
	
	/**
	 * this method creates how many employees are in the simulation at the beginning
	 * and restricts any more developers from entering
	 * @param totalEmployees the maximum number of developers in the building
	 */
	public static void createEmployeesInBuilding(int totalEmployees)
	{
		for(Integer i = 0; i < totalEmployees; i++)
		{
			Person newEmployees = new Employee();
			personList.add(newEmployees);
		}
	}
	
	/**
	 * this method create a maintenance team in the building depending
	 * on the chosen probability
	 * @param probability the likelihood a maintenance team will be created
	 */
	public static void createMaintenanceInBuilding(double probability)
	{
		if(probability < 0.005)
		{
			Person newMaintenance = new Maintenance();
			floors.get(0).add(newMaintenance);
		}
	}
	
	/**
	 * this is a simple return method that gets the elevators in the building
	 * @return all the elevator in the building
	 */
	public static ArrayList<Elevator> getElevators()
	{
		return elevators;
	}
	
	/**
	 * creates the floors in the building
	 * then adds people to the building
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
	 * gives each elevator a unique name so they can be identified 
	 * @param name the name of the elevator
	 * @return allElevators elevator if name is equal, otherwise null
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
	 * this method is used to extract how many people are in each floor
	 * @return allPeople shows how many people in each floor
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
	 * this method outputs in console how many people are in each floor
	 * @param floorNumber the current floor the method is referring to
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
	}
}
