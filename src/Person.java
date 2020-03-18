public class Person 
{
	/*
	 * String identifier;
	 */
	//int[] accessLevel = {1, 2, 3, 4, 5, 6, 7};
	int priorityLevel;
	int startingFloor = 0; 
	int capacityNeeded;
	int currentFloor = 0; 
	float probabilityP;
	float probabilityQ;
	
	public Person()
	{
		
	}
	
	public class Employee
	{
		public Employee() 
		{	
		
		}
	}
	
	
	public class Developer
	{
		public Developer() 
		{
				
		}
	}
	
	public class Maintenance 
	{
		int capacityNeeded = 4;
		int spawnProbability;
		
		public Maintenance()
		{
			
		}
	}
	
	public class Client
	{
		float probabilityQ;
		String company;
		int maxWaitTime;
		int currentWaitTime;
				
		public Client() 
		{
			
		}
		
		public void fileComplaint() 
		{
			System.out.println("File Complaint filed");
		}
	}
	
	public void setProbabilities(float probP, float probQ) 
	{
		probabilityP = probP;
		probabilityQ = probQ;
	}
	
	public float getProbP()
	{
		return probabilityP;
	}
	
	public void goToFloor(int floor)
	{
		/* 
		 * Insert elevator methods here to go up floor
		 */
		currentFloor = floor;
	}
}