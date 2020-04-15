import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Elevator
{    
	private int currentFloor = 0;
	private int maxCapacity = 4;
	private String elevatorName;
	private Queue<Person> elevatorOccupancy = new LinkedList<Person>();
	private Boolean isElevatorUp = true;
	private boolean doorsOpen = true;
	private int tickCounter = 1;;
	
	public Elevator(String elevatorName)
	{
		this.elevatorName = elevatorName;
	}

	public String getPeopleInElevator()
	{
		return elevatorOccupancy.toString();
	}		
	
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	public String getElevatorName()
	{
		return elevatorName;
	}
	
	public void setDoorStatus(Boolean newDoorStatus)
	{
		this.doorsOpen = newDoorStatus;
	}

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
	 * 
	 * @return 
	 * true if there are people that want to continue travelling in the same direction
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
	
	public void removePeopleFromElevator()
	{
		if(doorsOpen)
		{
			Queue<Person> peopleInElevator = new LinkedList<>(elevatorOccupancy);
			Queue<Person> peopleToAdd = Building.getPeople(currentFloor);
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
	
	public void addPeopleFromBuilding()
	{
		if(doorsOpen)
		{
			Queue<Person> peopleOnFloor = new LinkedList<>(Building.getPeople(currentFloor));
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
						Building.getPeople(currentFloor).remove(person);
					}
					else
					{
						break;
					}
				}		
			}
		}
	}
	
	public boolean doesElevatorStop()
	{
		for(Person elevatorPeople : elevatorOccupancy)
		{
			if(elevatorPeople.getCurrentGoal() != null && elevatorPeople.getCurrentGoal() == currentFloor)
			{
				return true;
			}
		}
		for(Person buildingPeople : Building.getPeople(currentFloor))
		{
			if(buildingPeople.getCurrentGoal() != null)
			{
				return true;
			}
		}
		return false;
	}
	
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
