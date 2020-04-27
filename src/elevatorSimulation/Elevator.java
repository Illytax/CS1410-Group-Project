package elevatorSimulation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.scene.control.TextField;

/**
 * The elevator class is held within the building and used to
 * transport different people to there desired floor 
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 */

public class Elevator
{    
	private static TextField elevatorCapacity_TextField;
	private int currentFloor = 0;
	private int maxCapacity = Integer.parseInt(elevatorCapacity_TextField.getText());
	private String elevatorName;
	private Queue<Person> elevatorOccupancy = new LinkedList<Person>();
	private Boolean isElevatorUp = true;
	private boolean doorsOpen = true;
	private int tickCounter = 1;;
	
	public Elevator(String elevatorName)
	{
		this.elevatorName = elevatorName;
	}
	
	/**
	 * how much space there is in the elevator
	 * @return the number of elements in the elevator
	 */
	public int getElevatorOccupancySize()
	{
		return elevatorOccupancy.size();
	}
	
	/**
	 * converts elevatorOccupancy to a string
	 * @return  the string representation of the elevatorOccupancy
	 */
	public String getPeopleInElevator()
	{
		return elevatorOccupancy.toString();
	}
	
	/**
	 * the floor the elevator is currently on
	 * @return currentFloor the floor the elevator is on
	 */
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	/**
	 * @return the name of the elevator
	 */
	public String getElevatorName()
	{
		return elevatorName;
	}
	
	/**
	 * this opens the door so people can enter the elevator
	 * @param newDoorStatus new status of the door
	 */
	public void setDoorStatus(Boolean newDoorStatus)
	{
		this.doorsOpen = newDoorStatus;
	}
	
	/**
	 * checks if the capacity of the elevator is meet
	 * if not and the elevator want to move in the same direction
	 * and it has not reached the highest or lowest floor
	 * then the elevator will either go up or down a floor
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
	 * checks if there are any goal in the floors above or below the elevator 
	 * @return true if there is a goal on another floor
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
	 * this checks if the elevator is going up or not then
	 * it checks the goals of the people in the elevator and determines 
	 * if the elevator needs to keep going in the same direction
	 * @return true if there are no goals on the current floor
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
	 * removes person from elevator to there desired floor
	 * creates more capacity in the elevator depending on who leaves
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
					if(person instanceof Maintenance)
					{
						maxCapacity = 4;
					}
				}
				if(currentFloor == 0  && person.toBeDisposed)
				{
					peopleToAdd.remove(person);
				}
			}		
		}
	}
	
	/**
	 * adds people from the building into the elevator
	 * only if the doors are open and the occupancy hasen't reached max
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
					if(elevatorOccupancy.size() < maxCapacity)
					{
						if((person instanceof Maintenance) && (elevatorOccupancy.size() == 0))
						{
							maxCapacity = 1;
						}
						else if((person instanceof Maintenance) && (elevatorOccupancy.size() > 0))
						{
							if(peopleToAdd.size() < 2)
							{
								break;
							}
						}
						elevatorOccupancy.add(person);
						Building.getPeopleOnAFloor(currentFloor).remove(person);
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
	 * this method determines whether or not the elevator
	 * stops at a certain floor
	 * @return true if the elevator should stop
	 * else the elevator continues its direction
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
	 * this boolean method determines if a person has a goal or not
	 * @return true if people in the elevator or building have a goal
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
	 * this method is a tick counter that increases every time
	 * the elevator moves or people go into or leave the elevator
	 * it then resets when the doors close
	 */
	public void elevatorTick()
	{
		System.out.println("There are "  + getPeopleInElevator() + " in Elevator " + getElevatorName());
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
				System.out.println("Elevator (At floor " + getCurrentFloor() + ", Elevator Closed)");
			}
			
			else if(tickCounter == 1)
			{
				removePeopleFromElevator();
				addPeopleFromBuilding();
				tickCounter++;
				System.out.println("Elevator (At floor " + getCurrentFloor() + ", Elevator Open)");
			}
			
			else if(tickCounter == 2)
			{
				setDoorStatus(false);
				tickCounter=0;
				System.out.println("Elevator (At Floor " + getCurrentFloor() + ", Elevator Closed)");
			}
		}
		else if(currentFloor != 0)
		{
			isElevatorUp = false;
			currentFloor--;
			System.out.println("Elevator (At Floor " + getCurrentFloor() + ") ,Elevator Returning to 0)");
		}
	}

}
