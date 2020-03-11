public class Elevator 
{    
	int currentFloor = 0;
	String elevatorName;
	
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
	
	public int getCurrentFloor()
	{
		return Building.getNumberOfFloors()[currentFloor];
	}
	
	public String getElevatorName()
	{
		return elevatorName;
	}
}
