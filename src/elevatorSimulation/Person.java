package elevatorSimulation;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * This class represents a Person in this Building
 * Person is the super for all types of people
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Person
{
	protected int tick;
	protected boolean toBeDisposed = false;
	protected int[] accessLevel;
	protected static double probabilityP;
	protected static double probabilityQ;
	protected int maxWaitTime;
	protected int currentWaitTime;
	protected Queue<Integer> floorGoals;
	protected Integer previousGoal;
	protected static Random random;
	
	
	/**
	 * This determines what floors each type of Person can access
	 * @param accessLevel is and array of the floors a Person can access
	 */
	public Person(int[] accessLevel)
	{
		this.accessLevel = accessLevel;
		floorGoals = new LinkedList<Integer>();
		newGoal();
	}
	
	/**
	 * Gets the head of the Queue
	 * @return the head of the queue (Person's current goal)
	 */
	public Integer getCurrentGoal()
	{
		return floorGoals.peek();
	}
	
	/**
	 * Determines if a Person has a goal
	 * @return the current size of floor goals
	 */
	public int getGoalsSize()
	{
		return floorGoals.size();
	}
	
	/**
	 * Removes the Person's current goal and stores it in an integer
	 */	
	public void removeGoal()
	{
		previousGoal = floorGoals.poll();
	}
	
	/**
	 * Generates a random number
	 * @param seed allows Random to take a value
	 * that can be used to create repeatable results
	 */
	public static void newRandom(int seed)
	{
		random = new Random(seed);
	}
	
	public void updateGoals()
	{
		
	}
	
	/**
	 * Creates an initial goal for a newly created Person when they enter the Building
	 * based on the floors they are allowed to access
	 */
	public void newGoal()
	{
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	/**
	 * @param p proabilityP
	 */
	public static void setProbP(double p) 
	{
		probabilityP = p;
	}
	
	/**
	 * @return probabilityP
	 */
	public static double returnProbP() 
	{
		return probabilityP;
	}
	
	/**
	 * @param q probabilityQ
	 */
	public static void setProbQ(double q) 
	{
		probabilityQ = q;
	}
	
	/**
	 * @return probabilityQ
	 */
	public static double returnProbQ() 
	{
		return probabilityQ;
	}

}
