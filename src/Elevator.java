import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator
{    
	private int currentFloor = 0;
	private int maxCapacity = 4;
	private String elevatorName;
	private Queue<Person> elevatorOccupancy = new LinkedList<Person>();
	private Boolean isElevatorUp = true;
	private boolean doorsOpen = true;
	
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
		if(isElevatorUp)
			if(Building.getAnElevator("e1").getCurrentFloor() == Building.getSizeOfFloors() - 1)
			{
				isElevatorUp = false;
				currentFloor--;
			}
			else
			{
				currentFloor++;
			}
		else
		{
			if(Building.getAnElevator("e1").getCurrentFloor() == 0)
			{
				isElevatorUp = true;
				currentFloor++;
			}
			else
			{
				currentFloor--;
			}
		}
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

}
