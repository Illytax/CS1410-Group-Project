public class Person 
{
	protected int[] accessLevel;
	protected int priorityLevel;
	protected int capacityNeeded;
	protected int currentFloor; 
	protected float probabilityP;
	protected float probabilityQ;
	protected int maxWaitTime;
	protected int currentWaitTime;
	protected String company;
	protected String personName;
	
	public Person(String personName, int currentFloor)
	{
		this.personName = personName;
		this.currentFloor =  currentFloor;
	}
	
	
	public String getPeopleName()
	{
		return personName;
	}
}