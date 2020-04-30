package elevatorSimulation;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elevatorSimulation.Building;
import elevatorSimulation.Developer;
import elevatorSimulation.Person;

public class PeopleTests
{
	@BeforeEach
	public void setup()
	{
		Person.newRandom(1);
	}
	
	@Test
	public void testDeveloperGoals()
	{
		Person person = new Developer("Mugtome", 7);
		assertEquals((int)person.getCurrentGoal(), 4);
	}
	
	
	@Test
	public void testGetNewGoal()
	{
		Person person = new Developer("Mugtome", 7);
		person.floorGoals.poll();
		person.newGoal();
		assertEquals((int)person.getCurrentGoal(), 5);
	}
	
	@Test
	public void testCreateMaintanance()
	{
		Building.setFloors(1);
		assertEquals(Building.getPeopleOnAFloor(0).size(), 0);
		Building.createMaintenanceInBuilding(0.002, 7);
		assertEquals(Building.getPeopleOnAFloor(0).size(), 1);
	}
}
