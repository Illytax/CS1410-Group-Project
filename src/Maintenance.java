/**
 * This class represents a maintenance team in this building
 * 
 * @author
 * @version 1.0
 * */
public class Maintenance extends Person
{
	private int count = 0;
	private int deathTickInt;
	
	/**
	 * death tick generates a random number between 240 and 120
	 * restricts the maintenance team only the top floor of the building
	 */
	
	public Maintenance()
	{
		super(new int[] {6});
		
		deathTickInt = random.nextInt(240 - 120) + 120;
	}
	
	/**
	 * creates a number between 1 and 0 representing probability
	 * @return probability denoted by q
	 */
	
	public static double newQ()
	{
		double q = random.nextDouble();
		return q;
	}
	/**
	 * if the maintenance team doesn't have any more goals
	 * then it will increase a counter and if that is greater than
	 * the death tick then the maintenance team will go to the ground floor 
	 * and leave the building
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

}
