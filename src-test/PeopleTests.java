import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		Person person = new Developer("Mugtome");
		assertEquals((int)person.getCurrentGoal(), 4);
	}
	
	
	@Test
	public void testGetNewGoal()
	{
		Person person = new Developer("Mugtome");
		person.floorGoals.poll();
		person.newGoal();
		assertEquals((int)person.getCurrentGoal(), 5);
	}
}
