package elevatorSimulation;
/**
 * This class represents a Client in the Building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Client extends Person
{
	private int deathCount = 0;
	private int willComplainCount = 0;
	private static int currentNumberOfComplaints = 0;
	private int deathTickInt;
	
	/**
	 * Death tick generates a Random number between 180 and 60
	 * {@inheritDoc}
	 */
	public Client(int numberOfFloors)
	{
		super();
		setAccessLevels(numberOfFloors);
		deathTickInt = random.nextInt(180 - 60) + 60;
		newGoal();
	}
	
	/**
	 * Sets the Client floor access to be the bottom floors of the Building
	 * excluding the ground floor
	 * @param numberOfFloors takes the number of floors in the Building
	 */
	private void setAccessLevels(int numberOfFloors) 
	{
		int[] accessLevel = new int[(int) ((numberOfFloors - 0.5f) / 2f)];
		for(int i = 0, j = 0; i <  accessLevel.length; i++, j++)
		{
			accessLevel[j] = i + 1;
		}
		this.accessLevel = accessLevel;
	}
	
	/**
	 * This method outputs in the console the total number of complaints
	 * made by Client(s)
	 */
	public void fileComplaint() 
	{
		currentNumberOfComplaints++;
		System.out.println("Number of complaints filed : " + currentNumberOfComplaints);
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
		if(getCurrentGoal() != null && isInElevator == false)
		{
			willComplainCount++;
			if(willComplainCount == 60)
			{
				fileComplaint();
			}
		}
		else if(getCurrentGoal() != null && isInElevator == true)
		{
			willComplainCount = 0;
		}
		else if(getCurrentGoal() == null)	
		{
			deathCount++;
			if(deathCount > deathTickInt)
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