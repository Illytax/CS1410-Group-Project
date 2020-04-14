public class Developer extends Person
{
	private String companyName;

	public Developer(int currentFloor, String companyName)
	{
		super(currentFloor, new int[] {4, 5, 6});
		
		this.companyName =  companyName;
		capacityNeeded = 1;
		currentFloor = 1;
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
