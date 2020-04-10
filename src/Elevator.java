import java.util.PriorityQueue;

public class Elevator
{    
	private int currentFloor = 0;
	private String elevatorName;
	static PriorityQueue<Person> elevatorOccupancy = new PriorityQueue<Person>();
	
	public Elevator(String elevatorName)
	{
		this.elevatorName = elevatorName;
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
		while(elevatorOccupancy.size() < 4)
		{
			elevatorOccupancy.add(peopleToAdd.poll());
		}
	}
	
	public void removePeopleFromElevator()
	{
		PriorityQueue<Person> peopleToRemove = elevatorOccupancy;
		PriorityQueue<Person> peopleToAdd = Building.getPeople(currentFloor);
		while(!peopleToRemove.isEmpty())
		{
			peopleToAdd.add(peopleToRemove.remove());
		}
	}
	
	
	public static int getPeopleInElevator()
	{
		return elevatorOccupancy.size();
	}		
	
	public int getCurrentFloor()
	{
		return currentFloor;
	}
	
	public String getElevatorName()
	{
		return elevatorName;
	}
}
