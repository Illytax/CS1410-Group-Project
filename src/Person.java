import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Person implements Comparable<Person>, Visitor
{
	protected int tick;
	protected boolean toBeDisposed = false;
	protected int[] accessLevel;
	protected int priorityLevel;
	protected int capacityNeeded;
	protected int currentFloor; 
	protected static float probabilityP;
	protected static float probabilityQ;
	protected int maxWaitTime;
	protected int currentWaitTime;
	protected Queue<Integer> floorGoals;
	protected static Random random = new Random();
	
	public Person(int currentFloor, int[] accessLevel)
	{
		this.currentFloor =  currentFloor;
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
		floorGoals.poll();
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

	@Override
	public int compareTo(Person o) 
	{
		return 0;
	}

}
