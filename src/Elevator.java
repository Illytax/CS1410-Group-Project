public class Elevator 
{    
	int currentFloor = 0;
	
	public void elevatorUp()
	{
    	if(currentFloor == Building.returnArraySize() - 1)
    	{
    		System.out.println("You're at the top floor");
    	}
    	else
    	{
    		currentFloor++;
    		System.out.println("You've gone up to floor" + " " + Building.returnArray()[currentFloor]);
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
    		System.out.println("You've gone down to floor" + " " + Building.returnArray()[currentFloor]);
    	}
	}
	
	public int getCurrentFloor()
	{
		return Building.returnArray()[currentFloor];
	}
}
