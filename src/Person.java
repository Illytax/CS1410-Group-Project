import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class Person implements Comparable
{
	protected int[] accessLevel;
	protected int priorityLevel;
	protected int capacityNeeded;
	protected int currentFloor; 
	protected float probabilityP;
	protected float probabilityQ;
	protected int maxWaitTime;
	protected int currentWaitTime;
	protected String personName;
	protected Queue<Integer> floorGoals;
	protected static Random random = new Random();
	
	public Person(String personName, int currentFloor, int[] accessLevel)
	{
		this.personName = personName;
		this.currentFloor =  currentFloor;
		this.accessLevel = accessLevel;
		floorGoals = new LinkedList<Integer>();
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	public int getCurrentGoal()
	{
		return floorGoals.peek();
	}
	
	public void newGoal()
	{
		floorGoals.poll();
		floorGoals.add(accessLevel[random.nextInt(accessLevel.length)]);
	}
	
	@Override
	public int compareTo(Object o) 
	{
		return 0;
	}
}