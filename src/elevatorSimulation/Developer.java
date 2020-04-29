package elevatorSimulation;
/**
 * This class represents a developer in this building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Developer extends Person
{
	private String companyName;
	
	/**
	 * This Constructor chooses what company the Developer is coming from
	 * and restricts the Developer to top 3 floors of the Building
	 * @param companyName the name of the company the Developer works for
	 */
	public Developer(String companyName)
	{
		super(new int[] {4, 5, 6});
		
		this.companyName =  companyName;
	}
	
	/**
	 * Creates a new goal for the Developer 
	 * that isn't the same as the previous goal
	 */
	private void randomNewGoal()
	{
		newGoal();
		if(previousGoal.equals(getCurrentGoal()))
		{
			removeGoal();
			randomNewGoal();
		}
	}
	
	/**
	 * Creates a new goal for the Developer when a 
	 * Random value is less than the current value of probability p
	 */
	@Override
	public void updateGoals()
	{
		if(getCurrentGoal() == null)
		{
			double p = random.nextDouble();
			if(p < returnProbP())
			{
				randomNewGoal();
			}
		}
	}
	
	/**
	 * @return companyName of the Developer
	 */
	public String getCompanyName()
	{
		return companyName;
	}
	
	/**
	 * Changes the string representation of the class
	 */
	@Override
	public String toString()
	{
		return "Developer " + companyName + " " + hashCode();
	}
}
