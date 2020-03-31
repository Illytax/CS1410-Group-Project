
public class Person {
	
	/*
	 * String identifier;
	 */
	int[] accessLevel;
	int priorityLevel;
	int startingFloor = 0; 
	int capacityNeeded = 1;
	 
	int currentFloor = 0; 
	
	
	
	public Person() {}
	
	public class Employee{
		float probabilityP;
		float probabilityQ;
		accessLevel = [0,1,2,3,4,5,6,];
		
		public Employee() {
			
		
		}
		
	
	
		public class Developper{
			accessLevel = [4,5,6];
			
			public Developer() {
				
			}
		
		}
		
		public void setProbabilities(float probP, float probQ) {
			proabbilityP = probP;
			probabilityQ = probQ;
		}
		
	}
	
	public class Maintenance implements visitor {
		accessLevel = [6];
		capacityNeeded = 4;
		probability = 0.005;
		
		public Maintenance() {
			
		}
	}
	
	public class Client implements visitor{
		float probabilityQ;
		String company;
		int maxWaitTime;
		int currentWaitTime;
		accessLevel = [0,1,2,3];
				
		public Client() {
			
		}
		
		
		
		
		public void fileComplaint() {
			System.out.println("File Complaint filed");
		}
	}
	
	
	public void goToFloor(int floor)
	{
		/* 
		 * Insert elevator methods here to go up floor
		 */
		currentFloor = floor;
		
	}
	

	
	
	
	
	
	
}
