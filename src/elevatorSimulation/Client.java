package elevatorSimulation;
/**
 * This class represents a Client in the Building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Client extends Person
{
	private int count = 0;
	private int deathTickInt;
	
	/**
	 * death tick generates a random number between 180 and 60
	 * restricts the clients to bottom half of the building
	 */
	public Client()
	{
		super(new int[] {1, 2, 3});
		
		deathTickInt = random.nextInt(180 - 60) + 60;
	}
	
	/**
	 * this method outputs in console the number of complaints
	 * by the client
	 */
	public void fileComplaint() 
	{
		int currentNumberOfComplaints = 0;
		currentNumberOfComplaints++;
		System.out.println("Complaint numnber " + currentNumberOfComplaints + " filed");
	}
	
	/**
	 * creates a number between 1 and 0 representing probability
	 * @return probability denoted by q
	 */
	public static double newQ()
	{
		double q = random.nextDouble();;
		return q;
	}

	/**
	 * if the client doesn't have any more goals
	 * then it will increase a counter and if that is greater than
	 * the death tick then the client will go to the ground floor and leave the building
	 */
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
	
	@Override
	public String toString()
	{
		return "Client "+ hashCode();
	}
}