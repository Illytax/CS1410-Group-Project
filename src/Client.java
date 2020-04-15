public class Client extends Person
{
	private int count = 0;
	private int deathTickInt;
	
	public Client()
	{
		super(new int[] {1, 2, 3});
		
		deathTickInt = random.nextInt(180 - 60) + 60;
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

	
	@Override
	public void updateGoals()
	{
		if(getCurrentGoal() == null)	
		{
			count++;
			if(count > deathTickInt)
			{
				toBeDisposed = true;
				floorGoals.add(0);
			}
		}
	}
}


