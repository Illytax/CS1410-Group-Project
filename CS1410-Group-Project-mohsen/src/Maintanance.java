public class Maintanance extends Person
{
	public Maintanance(String maintananceName, int currentFloor)
	{
		super(maintananceName, currentFloor);
		
		accessLevel = new int[] {7};
		capacityNeeded = 1;
		currentFloor = 1;
	}
}
