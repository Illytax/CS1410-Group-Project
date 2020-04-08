import java.util.ArrayList;
import java.util.PriorityQueue;

public class Elevator 
{    
	private int currentFloor = 0;
	private String elevatorName;
	//private ArrayList<PriorityQueue<Person>> elevatorOccupancy= new ArrayList<PriorityQueue<Person>>();
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
    		System.out.println("You've gone up to floor" + " " + Building.getNumberOfFloors()[currentFloor]);
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
    		System.out.println("You've gone down to floor" + " " + Building.getNumberOfFloors()[currentFloor]);
    	}
	}
	
	public Person addPeopleToElevator(String floor)
	{
		//elevatorOccupancy
		return null;
	}
	
	public int getCurrentFloor()
	{
		return Building.getNumberOfFloors()[currentFloor];
	}
	
	public String getElevatorName()
	{
		return elevatorName;
	}
}
