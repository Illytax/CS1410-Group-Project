public class Maintenance extends Person
{
	private int count = 0;
	private int deathTickInt;
	
	public Maintenance()
	{
		super(new int[] {6});
		
		deathTickInt = random.nextInt(240 - 120) + 120;
	}
	
	public static double newQ()
	{
		double q = random.nextDouble();
		return q;
	}

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
