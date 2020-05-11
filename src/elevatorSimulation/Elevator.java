package elevatorSimulation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.TextField;

/**
 * The Elevator class is held within the Building and used to
 * transport different Person(s) to there desired floor 
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 */

public class Elevator
{
	private int currentFloor = 0;
	private static int maxElevatorCapacity;
	private int currentMaxCapacity;
	private String elevatorName;
	private Queue<Person> elevatorOccupancy = new LinkedList<Person>();
	private Boolean isElevatorUp = true;
	private boolean doorsOpen = true;
	private int tickCounter = 1;
	private int elevatorUses = 0;
	
	/**
	 * Creates an Elevator with the capacity of
	 * the current value of currentMaxCapacity
	 * @param elevatorName sets the name of the Elevator
	 */
	public Elevator(String elevatorName)
	{
		this.elevatorName = elevatorName;
		currentMaxCapacity = maxElevatorCapacity;
	}
	
	/**
	 * @return the current occupancy of the Elevator
	 */
	public Queue<Person> getElevatorOccupancy()
	{
		return elevatorOccupancy;
	}
	
	/**
	 * Gets the current number of occupants in the Elevator
	 * @return the number of Person(s) in the Elevator
	 */
	public int getElevatorOccupancySize()
	{
		return elevatorOccupancy.size();
	}
	
	/**
	 * Converts elevatorOccupancy to a string
	 * @return the string representation of elevatorOccupancy
	 */
	public String getPeopleInElevator()
	{
		return elevatorOccupancy.toString();
	}
	
	/**
	 * The floor the Elevator is currently on
	 * @return currentFloor the floor the Elevator is on
	 */
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	/**
	 * @return the name of the Elevator
	 */
	public String getElevatorName()
	{
		return elevatorName;
	}
	
	/**
	 * This opens the door so a Person can enter the Elevator
	 * @param newDoorStatus new status of the door
	 */
	public void setDoorStatus(Boolean newDoorStatus)
	{
		this.doorsOpen = newDoorStatus;
	}
	
	/**
	 * sets the maximum number of Person(s) that can enter the Elevator
	 * @param capMax maximum Elevator Occupancy
	 */
	public static void maxElevatorCapacity(int capMax)
	{
		maxElevatorCapacity = capMax;
	}
	
	/**
	 * If no one is in the Elevator, and no one in the Building has a goal
	 * the Elevator returns to the ground floor. If isElevatorUp is true
	 * and the Elevator is not at the top floor the Elevator moves up,
	 * if it is false the Elevator moves down
	 */
	public void elavatorMove()
	{
		if(!(getElevatorOccupancyGoalRequirements() 
				|| doesElevatorContinueDirection())
				|| (getCurrentFloor() == Building.getSizeOfFloors() - 1 && isElevatorUp)
				|| (getCurrentFloor() == 0 && !isElevatorUp))
		{
			isElevatorUp =  !isElevatorUp;
		}
		if(isElevatorUp)
		{
			currentFloor++;
		}
		else
		{
			currentFloor--;
		}
	}
	
	/**
	 * Checks if any Person(s) have a goal in the floors above or below the Elevator 
	 * @return true if there is a Person with a goal on another floor
	 */
	public boolean getElevatorOccupancyGoalRequirements()
	{
		for(Person people : elevatorOccupancy)
		{
			if(isElevatorUp)
			{
				if(people.getCurrentGoal() > currentFloor)
					return true;
			}
			else
			{
				if(people.getCurrentGoal() < currentFloor)
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds all floors above the Elevator to a new ArrayList<Queue<Person>>
	 * when isElevatorUp is true or all the floors below the Elevator
	 * when isElevatorUp is false to check if Person(s) in the current direction
	 * of travel of the Elevator have goals
	 * @return true if a Person has a goal on the floors 
	 * in the direction the Elevator is moving
	 */
	public boolean doesElevatorContinueDirection()
	{
		ArrayList<Queue<Person>> floorsCheck = new ArrayList<Queue<Person>>();
		if(isElevatorUp)
		{
			for(int i = currentFloor; i < Building.getFloors().size(); i++)
			{
				floorsCheck.add(Building.getFloors().get(i));
			}
		}
		else
		{
			for(int i = currentFloor; i >= 0; i--)
			{
				floorsCheck.add(Building.getFloors().get(i));
			}
		}
		for(Queue<Person> people : floorsCheck)
		{
			for(Person floorPeople : people)
			{
				if(isElevatorUp)
				{
					if(floorPeople.getCurrentGoal() != null)
						return true;
				}
				else
				{
					if(floorPeople.getCurrentGoal() != null)
						return true;
				}
			}
		}
		return false;	
	}
	
	/**
	 * Checks all Person(s) in the Elevator
	 * if anyone anyone has a goal that is equal to the current floor,
	 * if they do they are removed from the Elevator and added to the Building
	 * Also if that Person is a Maintenance when they leave the currentMaxCapacity
	 * is set to the maxElevatorCapacity instead of 1
	 */
	public void removePeopleFromElevator()
	{
		if(doorsOpen)
		{
			Queue<Person> peopleInElevator = new LinkedList<>(elevatorOccupancy);
			Queue<Person> peopleToAdd = Building.getPeopleOnAFloor(currentFloor);
			for(Person person : peopleInElevator)
			{
				if(person.getCurrentGoal() != null && person.getCurrentGoal() == currentFloor)
				{
					person.removeGoal();
					elevatorOccupancy.remove(person);
					peopleToAdd.add(person);
					person.isInElevator(false);
					if(person instanceof Maintenance)
					{
						currentMaxCapacity = maxElevatorCapacity;
					}
				}
				if(currentFloor == 0  && person.toBeDisposed)
				{
					peopleToAdd.remove(person);
					person.isInElevator(false);
				}
			}		
		}
	}
	
	/**
	 * If a Person is a Developer, cast the Person as a Developer
	 * and check if anyone within the Elevator is also a Developer
	 * If any Developers within the Elevator have a different company to
	 * the person outside the Elevator, send the Person trying to enter to the back of the Queue
	 * @param person Person trying to enter the Elevator
	 * @return false if there are no conflicts between Developer companies, allowing the Developer to enter
	 */
	private boolean checkDeveloperCompanies(Person person)
	{
		if(person instanceof Developer)
		{
			Developer developer = (Developer) person;
			developer.getCompanyName();
			for(Person elevatorPeople : elevatorOccupancy)
			{
				if(elevatorPeople instanceof Developer)
				{
					Developer elevatorDeveloper = (Developer) elevatorPeople;
					if(!(developer.getCompanyName().equals(elevatorDeveloper.getCompanyName())))
					{
						Building.getPeopleOnAFloor(currentFloor).remove(person);
						Building.getPeopleOnAFloor(currentFloor).add(person);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Adds a Person from the Building to the Elevator when the Elevator has room for them
	 * or if there is no Developer company conflicts, and only adds Maintenance when there's no
	 * one in the Elevator
	 */
	public void addPeopleFromBuilding()
	{
		if(doorsOpen)
		{
			Queue<Person> peopleOnFloor = new LinkedList<>(Building.getPeopleOnAFloor(currentFloor));
			Queue<Person> peopleToAdd = elevatorOccupancy;
			for(Person person : peopleOnFloor)
			{
				if(person.getCurrentGoal() != null)
				{
					if(elevatorOccupancy.size() < currentMaxCapacity)
					{
						if(person instanceof Developer)
						{
							Developer developer = (Developer) person;
							developer.getCompanyName();
							for(Person elevatorPeople : elevatorOccupancy)
							{
								if(elevatorPeople instanceof Developer)
								{
									Developer elevatorDeveloper = (Developer) elevatorPeople;
									if(!(developer.getCompanyName().equals(elevatorDeveloper.getCompanyName())))
									{
										Building.getPeopleOnAFloor(currentFloor).remove(person);
										Building.getPeopleOnAFloor(currentFloor).add(person);
										break;
									}
								}
							}
						}
						if((person instanceof Maintenance) && (elevatorOccupancy.size() == 0))
						{
							currentMaxCapacity = 1;
						}
						else if((person instanceof Maintenance) && (elevatorOccupancy.size() > 0))
						{
							if(peopleToAdd.size() < 2)
							{
								break;
							}
						}
						if(checkDeveloperCompanies(person))
						{
							elevatorOccupancy.add(person);
							person.isInElevator(true);
							Building.getPeopleOnAFloor(currentFloor).remove(person);
							elevatorUses++;
						}
					}
					else
					{
						break;
					}
				}		
			}
		}
	}
	
	/**
	 * If anyone in the Elevator needs to get out at the current floor
	 * or anyone in the Building needs to get in at the current floor
	 * the Elevator stops
	 * @return true if the Elevator should stop else the Elevator continues its direction
	 */
	public boolean doesElevatorStop()
	{
		for(Person elevatorPeople : elevatorOccupancy)
		{
			if(elevatorPeople.getCurrentGoal() != null && elevatorPeople.getCurrentGoal() == currentFloor)
			{
				return true;
			}
		}
		for(Person buildingPeople : Building.getPeopleOnAFloor(currentFloor))
		{
			if(buildingPeople.getCurrentGoal() != null)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks if any people on any floors or any 
	 * people in the Elevator(s) have a goal
	 * @return true if a Person in the Elevator or Building have a goal
	 */
	public boolean doesAnyoneHaveAGoal()
	{
		for(Person allPeople : Building.getAllPeopleInAllFloors())
		{
			if(allPeople.getCurrentGoal() != null)
			{
				return true;
			}
		}
		for(Person allPeople : elevatorOccupancy)
		{
			if(allPeople.getCurrentGoal() != null)
			{
				return true;
			}
		}	
		return false;
	}
	
	/**
	 * This method is a tick counter that increases every time
	 * it is called, if the Elevator doesn't need to remove occupants
	 * it just moves and if it has no occupants then it returns to the ground floor
	 * When it does need to remove occupants it takes 2 ticks to add people and close its doors
	 * it then resets when the doors close
	 */
	public void elevatorTick()
	{
		if(doesAnyoneHaveAGoal())
		{
			if(tickCounter == 0)
			{
				elavatorMove();
				setDoorStatus(doesElevatorStop());
				tickCounter++;
				if(!doorsOpen)
				{
					tickCounter = 0;
				}
				System.out.println("There are "  + getPeopleInElevator() + " in Elevator " + getElevatorName());
				System.out.println("Elevator (At floor " + getCurrentFloor() + ", Elevator Closed)");
			}
			
			else if(tickCounter == 1)
			{
				removePeopleFromElevator();
				addPeopleFromBuilding();
				tickCounter++;
				System.out.println("There are "  + getPeopleInElevator() + " in Elevator " + getElevatorName());
				System.out.println("Elevator (At floor " + getCurrentFloor() + ", Elevator Open)");
			}
			
			else if(tickCounter == 2)
			{
				setDoorStatus(false);
				tickCounter=0;
				System.out.println("There are "  + getPeopleInElevator() + " in Elevator " + getElevatorName());
				System.out.println("Elevator (At Floor " + getCurrentFloor() + ", Elevator Closed)");
			}
		}
		else if(currentFloor != 0)
		{
			isElevatorUp = false;
			currentFloor--;
			System.out.println("There are "  + getPeopleInElevator() + " in Elevator " + getElevatorName());
			System.out.println("Elevator (At Floor " + getCurrentFloor() + ") ,Elevator Returning to 0)");
		}
		else
		{
			System.out.println("Elevator " + getElevatorName() + " is currently not in use");
		}
		System.out.println("Elevator " + getElevatorName() + " has been used " + elevatorUses + " times" + "\n");
	}

}
