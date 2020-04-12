public class Developer extends Person
{
	private String companyName;

	public Developer(String developerName, int currentFloor, String companyName)
	{
		super(developerName, currentFloor, new int[] {4, 5, 6});
		
		this.companyName =  companyName;
		capacityNeeded = 1;
		currentFloor = 1;
	}
	
	@Override
	public void updateGoals()
	{
		if(getCurrentGoal() == null)
		{
			double p = random.nextDouble();
			if(p < returnProbP())
			{
				newGoal();
			}
		}
	}

}
