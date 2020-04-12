import java.util.Random;

public interface Visitor 
{
	
	
	public static void setprobabilityP(double probP)
	{
		probP = new Random().nextDouble();			
	}
	
	
	public static void setprobabilityQ(double probabilityQ)
	{
		probabilityQ = new Random().nextDouble();			
	}
	
}
