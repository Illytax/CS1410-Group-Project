package elevatorSimulation;
/**
 * This class represents a Maintenance team in this Building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Maintenance extends Person
{
	private int count = 0;
	private int deathTickInt;
	
	/**
	 * Death tick generates a Random number between 240 and 120
	 * {@inheritDoc}
	 */
	public Maintenance(int numberOfFloors)
	{
		super();
		setAccessLevels(numberOfFloors - 1);
		deathTickInt = random.nextInt(240 - 120) + 120;
		newGoal();
	}
	
	private void setAccessLevels(int numberOfFloors) 
	{
		accessLevel = new int[] {numberOfFloors};
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
	 * If the Maintenance team doesn't have any more goals
	 * then it will increase a counter and if that is greater than
	 * the death tick then the Maintenance team will go to the ground floor 
	 * and leave the Building
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
		return "Maintenance "+ hashCode();
	}

}
