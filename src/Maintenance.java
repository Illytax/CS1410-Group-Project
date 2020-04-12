public class Maintenance extends Person
{
	public Maintenance(int currentFloor)
	{
		super(currentFloor,  new int[] {6});
		
		capacityNeeded = 1;
		currentFloor = 1;
	}
	
	@Override
	public void updateGoals()
	{
		if(getCurrentGoal() == null)
		{
			double q = random.nextDouble();
			if(q < 0.005)
			{
				newGoal();
			}
		}
	}
}
