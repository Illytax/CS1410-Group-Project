public class Developer extends Person
{
	@SuppressWarnings("unused")
	private String companyName;

	public Developer(String companyName)
	{
		super(new int[] {4, 5, 6});
		
		this.companyName =  companyName;
	}
	
	private void randomNewGoal()
	{
		newGoal();
		if(previousGoal.equals(getCurrentGoal()))
		{
			removeGoal();
			randomNewGoal();
		}
	}
	
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

}
