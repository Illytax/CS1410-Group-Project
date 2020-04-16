import javafx.scene.control.Slider;

public class Employee extends Person
{
	
	private static Slider pValueSlider;
	public Employee()
	{
		super(new int[] {1, 2, 3, 4, 5, 6});
	}
	
	private void randomNewGoal()
	{
		newGoal();
		if(previousGoal.equals(getCurrentGoal()))
		{
			removeGoal();
			randomNewGoal();
		}
	}
	
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
