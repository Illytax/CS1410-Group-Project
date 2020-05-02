package elevatorSimulation;

import java.util.LinkedList;

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
	 * This Constructor chooses what company the Developer is working for
	 * @param companyName the name of the company the Developer works for
	 * @param floorNumbers total number of floors in the Building
	 */
	public Developer(String companyName, int floorNumbers)
	{
		super();
		setAccessLevels(floorNumbers);
		this.companyName =  companyName;
		newGoal();
	}
	
	/**
	 * Sets the Developer floor access to be the top half of the 
	 * floors of the Building excluding the ground floor
	 * @param numberOfFloors takes the number of floors in the Building
	 */
	private void setAccessLevels(int numberOfFloors) 
	{
		int[] accessLevel = new int[(int) (Math.floor(numberOfFloors / 2))];
		for(int i = Math.round(((numberOfFloors) / 2f)), j = 0; i < numberOfFloors; i++, j++)
		{
			accessLevel[j] = i;
		}
		this.accessLevel = accessLevel;
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
