/**
 * 
 */

/**
 * @author linh8
 *
 */

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
	    Random randGen = new Random();
	    int seedVal;
	    System.out.print("Enter a random seed: ");
	    seedVal = keyboard.nextInt();
	    randGen.setSeed(seedVal);
	    
	    int ranNum = randGen.nextInt(200) + 1;
	    int guess;
	    
	    int count = 0;
	    boolean correct = false;
	    
	    while (correct== false) {
	    	System.out.print("Enter a guess between 1 and 200: ");
	    	guess = keyboard.nextInt();
	    	count ++;
	    	if (guess > 200) {
	    		
	    		System.out.println ("Your guess is out of range.  Pick a number between 1 and 200.");
	    		System.out.println ("Your guess was too high - try again.");
	    		System.out.println ();
	    	}
	    	
	    	else if (guess < 0) {
	    		
	    		System.out.println ("Your guess is out of range.  Pick a number between 1 and 200.");
	    		System.out.println ("Your guess was too low - try again.");
	    		System.out.println ();
	    	}
	    	
	    	else if (guess > ranNum) {
	    				
	    		System.out.println ("Your guess was too high - try again.");
	    		System.out.println ();
	    	}
	    	
	    	else if (guess < ranNum) {
	    		System.out.println ("Your guess was too low - try again.");
	    		System.out.println ();
	    	}
	    	    	
	    	else if (guess == ranNum) {
	    		
	    		correct = true;
	    		System.out.println ("Congratulations!  Your guess was correct!");
	    		System.out.println ();
	    	}
	    	}
	    
	    System.out.println ("I had chosen " + ranNum + " as the target number.");
	    System.out.println ("You guessed it in " + count + " tries.");
	    
	    if (count == 1) {
	    	System.out.println ("That was impossible!");
	    }
	    else if ((count >1) && (count < 4)) {
	    	System.out.println ("You're pretty lucky!");
	    }
	    else if ((count >3) && (count < 8)) {
	    	System.out.println ("Not bad, not bad...");
	    }
	    else if (count == 8) {
	    	System.out.println ("That was not very impressive.");
	    }
	    else if ((count >8) && (count < 11)) {
	    	System.out.println ("Are you having any fun at all?");
	    }
	    else if (count >10) {
	    	System.out.println ("Maybe you should play something else.");
	    }
	    }
	    
	
	    
	    
	    
	

}
