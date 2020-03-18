public class Employee extends Person
{
	public Employee(String employeeName, int currentFloor)
	{
		super(employeeName, currentFloor);
		
		accessLevel = new int[] {1, 2, 3, 4, 5, 6, 7};
		capacityNeeded = 4;
		currentFloor = 1;
	}
}
