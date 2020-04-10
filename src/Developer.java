public class Developer extends Person
{
	private String companyName;

	public Developer(String developerName, int currentFloor, String companyName)
	{
		super(developerName, currentFloor);
		
		this.companyName =  companyName;
		accessLevel = new int[] {5, 6, 7};
		capacityNeeded = 1;
		currentFloor = 1;
	}
}
