public class Maintenance extends Person
{
	public Maintenance(String maintenanceName, int currentFloor)
	{
		super(maintenanceName, currentFloor);
		
		accessLevel = new int[] {7};
		capacityNeeded = 1;
		currentFloor = 1;
	}
}
