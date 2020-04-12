
public class Employee extends Person
{
	public Employee(int currentFloor)
	{
		super(currentFloor, new int[] {1, 2, 3, 4, 5, 6});
		
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
