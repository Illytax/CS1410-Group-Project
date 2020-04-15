import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ElevatorTest 
{
	@BeforeEach
	public void setup()
	{
		Person.newRandom(1);
		Building.setFloors(7);
		Building.setElevators(1);
	}
	
	@Test
	public void testElevatorPersonMovement()
	{
		Building.createMugtomeDevelopersInBuilding(1);
		Building.createPeopleInBuilding(1);
		Elevator elevator = Building.getAnElevator("e1");
		int value1 = elevator.getElevatorOccupancySize();
		elevator.elevatorTick();
		int value2 = elevator.getElevatorOccupancySize();
		assertEquals(value1, 0);
		assertEquals(value2, 1);
	}
	
	@Test
	public void testPersonBuildingMovement()
	{
		Building.createMugtomeDevelopersInBuilding(1);
		Building.createPeopleInBuilding(1);
		Elevator elevator = Building.getAnElevator("e1");
		for(int i = 0; i < 6; i++)
		{
			elevator.elevatorTick();
		}
		int value1 = elevator.getElevatorOccupancySize();
		assertEquals(value1, 0);
		assertEquals(Building.getPeople(4).size(), 1);
	}
}
