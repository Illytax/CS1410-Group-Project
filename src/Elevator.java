import java.util.PriorityQueue;

public class Elevator
{    
	private int currentFloor = 0;
	private int maxCapacity = 4;
	private String elevatorName;
	private PriorityQueue<Person> elevatorOccupancy = new PriorityQueue<Person>();
	
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

	public void elevatorUp()
	{
    	if(currentFloor == Building.getSizeOfFloors() - 1)
    	{
    		System.out.println("You're at the top floor");
    	}
    	else
    	{
    		currentFloor++;
    		System.out.println("You've gone up to floor" + " " + currentFloor);
    	}
	}
	
	public void elevatorDown()
	{
    	if(currentFloor == 0)
    	{
    		System.out.println("You're at the bottom floor");
    	}
    	else
    	{
    		currentFloor--;
    		System.out.println("You've gone down to floor" + " " + currentFloor);
    	}
	}
	
	public void addPeopleToElevator()
	{
		PriorityQueue<Person> peopleToAdd = Building.getPeople(currentFloor);
		while(elevatorOccupancy.size() < maxCapacity)
		{
			Person currentPoll = peopleToAdd.poll();
			if((currentPoll instanceof Maintenance) && (elevatorOccupancy.size() == 0))
			{
				elevatorOccupancy.add(currentPoll);
				maxCapacity = 1;
			}
			else if((currentPoll instanceof Maintenance) && (elevatorOccupancy.size() > 0))
			{
				if(peopleToAdd.size() < 2)
				{
					peopleToAdd.add(currentPoll);
					break;
				}
				else
				{
					peopleToAdd.add(currentPoll);
				}
			}
			else
			{
				if(currentPoll == null)
				{
					break;
				}
					else
				{
					elevatorOccupancy.add(currentPoll);
				}
			}
		}
	}
	
	public void removePeopleFromElevator()
	{
		PriorityQueue<Person> peopleInElevator = new PriorityQueue<>(elevatorOccupancy);
		PriorityQueue<Person> peopleToAdd = Building.getPeople(currentFloor);
		for(Person person : peopleInElevator)
		{
			if(person.getCurrentGoal() == currentFloor)
			{
				if(person instanceof Maintenance)
				{
					maxCapacity = 4;
				}
				elevatorOccupancy.remove(person);
				peopleToAdd.add(person);
			}
		}
	}
}
