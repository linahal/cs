package simulation;

import java.util.Random;

public class testerrr {
	
	public static void main(String[]args)
	{
		int rand1= (int) (Math.random()* 10  + 5); 
		//System.out.println(rand1);
		
		Random rand = new Random();

		int randomInteger = rand.nextInt(10) + 5;
		System.out.println(randomInteger);
		
		
		
	}

}
