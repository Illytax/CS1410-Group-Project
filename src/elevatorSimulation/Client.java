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
	 * Death tick generates a Random number between 180 and 60
	 * {@inheritDoc}
	 */
	public Client()
	{
		super(new int[] {1, 2, 3});
		
		deathTickInt = random.nextInt(180 - 60) + 60;
	}
	
	/**
	 * This method outputs in the console the total number of complaints
	 * made by Client(s)
	 */
	public void fileComplaint() 
	{
		int currentNumberOfComplaints = 0;
		currentNumberOfComplaints++;
		System.out.println("Complaint numnber " + currentNumberOfComplaints + " filed");
	}
	
	/**
	 * Creates a number between 0.000 and 1.000 representing probability
	 * @return probability denoted by q
	 */
	public static double newQ()
	{
		double q = random.nextDouble();
		return q;
	}

	/**
	 * When the Client reaches its target floor
	 * its count will increase with every tick until it reaches a random
	 * death tick that will cause the Client to the ground floor and leave the Building
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
	
	/**
	 * Changes the string representation of the class
	 */
	@Override
	public String toString()
	{
		return "Client " + hashCode();
	}
}