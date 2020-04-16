import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Person
{
	protected int tick;
	protected boolean toBeDisposed = false;
	protected int[] accessLevel;
	protected static float probabilityP;
	protected static float probabilityQ;
	protected int maxWaitTime;
	protected int currentWaitTime;
	protected Queue<Integer> floorGoals;
	protected Integer previousGoal;
	protected static Random random;
	
	public Person(int[] accessLevel)
	{
		this.accessLevel = accessLevel;
		floorGoals = new LinkedList<Integer>();
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	public Integer getCurrentGoal()
	{
		return floorGoals.peek();
	}
	
	public int getGoalsSize()
	{
		return floorGoals.size();
	}
	
	public void removeGoal()
	{
		previousGoal = floorGoals.poll();
	}
	
	public static void newRandom(int seed)
	{
		random = new Random(seed);
	}
	
	public void updateGoals()
	{
		
	}
	
	public void newGoal()
	{
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	public static void setProbP(float p) 
	{
		probabilityP = p;
	}
	
	public static float returnProbP() 
	{
		return probabilityP;
	}
	
	public static void setProbQ(float q) 
	{
		probabilityQ = q;
	}
	
	public static float returnProbQ() 
	{
		return probabilityQ;
	}

}
