public class Client extends Person
{
	public Client(String clientName, int currentFloor)
	{
		super(clientName, currentFloor, new int[] {1, 2, 3});
		
		capacityNeeded = 1;
		currentFloor = 1;
	}
	
	public void fileComplaint() 
	{
		int currentNumberOfComplaints = 0;
		currentNumberOfComplaints++;
		System.out.println("Complaint numnber " + currentNumberOfComplaints + " filed");
	}
}


