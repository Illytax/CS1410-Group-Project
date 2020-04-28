package elevatorSimulation;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * This class represents a person in this building
 * Person can be many different entities
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
	 * This decides what floor level a particular person can access
	 * @param accessLevel the floor a person can access
	 */
	public Person(int[] accessLevel)
	{
		this.accessLevel = accessLevel;
		floorGoals = new LinkedList<Integer>();
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	/**
	 * makes a list of all the floor requests
	 * @return elements in list
	 */
	public Integer getCurrentGoal()
	{
		return floorGoals.peek();
	}
	
	/**
	 * determines how many requests there are
	 * @return the current size of the list of floor goals
	 */
	public int getGoalsSize()
	{
		return floorGoals.size();
	}
	
	/**
	 * it pushes the previous element to the head of the queue
	 * so the new goal will take priority over the previous one
	 */	
	public void removeGoal()
	{
		previousGoal = floorGoals.poll();
	}
	
	/**
	 * generates a random number
	 * @param seed Random number generation algorithm works on the seed value
	 */
	public static void newRandom(int seed)
	{
		random = new Random(seed);
	}
	
	public void updateGoals()
	{
		
	}
	
	/**
	 * creates a number between 1 and 0 representing probability
	 * which will determine what floor the person will go
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
