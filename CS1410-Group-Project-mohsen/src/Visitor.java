import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public interface Visitor {
	
	private static void getProbP()
	{
		Random random=new Random();
		 
		int rangeMin=1;
		int rangeMax=7;
	
		
		for (int i = 0; i < 5; i++) {
			double randomDouble = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
			System.out.println(randomDouble);
		}
		for (int i = 0; i < 5; i++) {
			double randomNumber = ThreadLocalRandom.current().nextDouble(rangeMin, rangeMax);
			System.out.println(randomNumber);
		}

		
	}
	
	private static void getProbQ()
	{
		Random rand = new Random();
		
		int probabilityQ = rand.nextInt((7 - 1) + 1) + 1; 
				
	}
	
	private static void gotoFloor()
	{
		
		return ;
	}
	

}
