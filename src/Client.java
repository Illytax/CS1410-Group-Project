public class Client extends Person
{
	public Client()
	{
		accessLevel = new int[] {1, 2, 3};
		capacityNeeded = 1;
		currentFloor = 1;
	}
	
	public void fileComplaint() 
	{
		System.out.println("File Complaint filed");
	}
}

