package elevatorSimulation;
/**
 * This class represents an Employee in the Building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Employee extends Person
{
	
	/**
	 * Allows the Employee to move through any of the 
	 * Buildings floors not including the ground floor
	 * @param numberOfFloors takes the number of floors in the Building
	 * {@inheritDoc}
	 */
	public Employee(int numberOfFloors)
	{
		super();
		setAccessLevels(numberOfFloors);
		newGoal();
	}
	
	/**
	 * Sets the Employee floor access to be all the floors of the Building
	 * excluding the ground floor
	 * @param numberOfFloors takes the number of floors in the Building
	 */
	private void setAccessLevels(int numberOfFloors) 
	{
		int[] accessLevel = new int[numberOfFloors - 1];
		for(int i = 1, j = 0; i < numberOfFloors; i++, j++)
		{
			accessLevel[j] = i;
		}
		this.accessLevel = accessLevel;
	}
	
	/**
	 * Creates a new goal for the Employee 
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
	 * Creates a new goal for the Employee when a 
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
	 * Changes the string representation of the class
	 */
	@Override
	public String toString()
	{
		return "Employee "+ hashCode();
	}
}
