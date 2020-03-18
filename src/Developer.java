public class Developer extends Person
{
	public Developer(String developerName, int currentFloor)
	{
		super(developerName, currentFloor);
		
		accessLevel = new int[] {5, 6, 7};
		capacityNeeded = 1;
		currentFloor = 1;
	}
}
