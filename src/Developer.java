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
	 * this method chooses what company the developer is coming from
	 * and restricts the developers to top half of the building
	 * @param companyName the name of the company
	 */
	public Developer(String companyName)
	{
		super(new int[] {4, 5, 6});
		
		this.companyName =  companyName;
	}
	
	/**
	 * this method replaces the old goal with the new goal
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
	 * this method creates the probability that the developer changes goal
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
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	@Override
	public String toString()
	{
		return "Developer " + companyName + " " + hashCode();
	}
}
