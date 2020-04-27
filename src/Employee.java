<<<<<<< HEAD
import javafx.scene.control.Slider;

public class Employee extends Person
{
	
	private static Slider pValueSlider;
=======
/**
 * This class represents an employee in this building
 * 
 * @author Edward Jordan 180130678
 * @version 1.0
 * */
public class Employee extends Person
{
	
	/**
	 * employees will have an equal chance to go to any floor
	 */
>>>>>>> master
	public Employee()
	{
		super(new int[] {1, 2, 3, 4, 5, 6});
	}
	
	/**
	 * this method changes the employee's goal to its new goal
	 */
	private void randomNewGoal()
	{
		newGoal();
		if(previousGoal.equals(getCurrentGoal()))
		{
			removeGoal();
			randomNewGoal();
		}
	}
	
	/**
	 * this method is the probability that the employee will change goal
	 */
	@Override
	public void updateGoals()
	{
		if(getCurrentGoal() == null)
		{
			double p = pValueSlider.getValue();
			if(p < returnProbP())
			{
				randomNewGoal();
			}
		}
	}
}
