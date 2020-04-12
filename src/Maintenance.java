public class Maintenance extends Person
{
	public Maintenance(String maintenanceName, int currentFloor)
	{
		super(maintenanceName, currentFloor,  new int[] {6});
		
		capacityNeeded = 1;
		currentFloor = 1;
	}
}
