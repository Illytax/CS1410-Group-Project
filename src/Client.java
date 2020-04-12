public class Client extends Person
{
	public Client(int currentFloor)
	{
		super(currentFloor, new int[] {1, 2, 3});
		
		capacityNeeded = 1;
		currentFloor = 1;
	}
	
	public void fileComplaint() 
	{
		int currentNumberOfComplaints = 0;
		currentNumberOfComplaints++;
		System.out.println("Complaint numnber " + currentNumberOfComplaints + " filed");
	}
	
	public static double newQ()
	{
		double q = random.nextDouble();
		return q;
	}
	
}


