/**
 * 
 */

/**
 * Ask the user to answer a few arithmetic questions and grade the answers. 
 * Return Correct or Wrong and the proportion of correction questions at the end
 * @author LINH NGUYEN
 * Version 992019
 */
import java.util.Scanner;
import java.util.Random;
public class FunWithBranching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner keyboard = new Scanner(System.in);
	     System.out.print("Enter a random number seed: ");
	     int seed = keyboard.nextInt();
	     Random rnd = new Random(seed);
	     System.out.print("Enter your name: "); 
	     String userName = keyboard.next();
	     System.out.println ("Hello " + userName +"!");
	     System.out.println ("Please answer the following questions:");
	     System.out.println ();
	     int num1 = rnd.nextInt(20) + 1;
	     int num2 = rnd.nextInt(20) + 1;
	     int correctCount = 0;
	     double totalCount = 5.0;
// sum	     
	     System.out.print(num1 + " + " + num2 + " = ");
	     int sum = num1 + num2;
	     int userSum = keyboard.nextInt();
	     
	     if (userSum == sum) {
	    	 System.out.println ("Correct!");
	    	 correctCount ++;
	    	 System.out.println ();
	    }
	     else {
	    	 System.out.println ("Wrong!");
	    	 System.out.println ("The correct answer is: " + sum);
	    	 System.out.println ();
	     }
	     
// substract
	     System.out.print(num1 + " - " + num2 + " = ");
	     int substract = num1 - num2;
	     int userSub = keyboard.nextInt();
	     
	     if (userSub == substract) {
	    	 System.out.println ("Correct!");
	    	 correctCount ++;
	    	 System.out.println ();
	     }
	     else {
	    	 System.out.println ("Wrong!");
	    	 System.out.println ("The correct answer is: " + substract);
	    	 System.out.println ();
	     }

// multiple
	     System.out.print(num1 + " * " + num2 + " = ");
	     int multiple = num1 * num2;
	     int userMul = keyboard.nextInt();
	     
	     if (userMul == multiple) {
	    	 System.out.println ("Correct!");
	    	 correctCount ++;
	    	 System.out.println ();
	     }
	     else {
	    	 System.out.println ("Wrong!");
	    	 System.out.println ("The correct answer is: " + multiple);
	    	 System.out.println ();
	     }	   
	     
// division
	     System.out.print(num1 + " / " + num2 + " = ");
	     int division = num1 / num2;
	     int userDiv = keyboard.nextInt();
	     
	     if (userDiv == division) {
	    	 System.out.println ("Correct!");
	    	 correctCount ++;
	    	 System.out.println ();
	     }
	     else {
	    	 System.out.println ("Wrong!");
	    	 System.out.println ("The correct answer is: " + division);
	    	 System.out.println ();
	     }	   	     
 // module
	     System.out.print(num1 + " % " + num2 + " = ");
	     int module = num1 % num2;
	     int userMod = keyboard.nextInt();
	     
	     if (userMod == module) {
	    	 System.out.println ("Correct!");
	    	 correctCount ++;
	    	 System.out.println ();
	     }
	     else {
	    	 System.out.println ("Wrong!");
	    	 System.out.println ("The correct answer is: " + module);
	    	 System.out.println ();
	     }	
	     
	     System.out.println ("You got "+ correctCount + " correct answers!");
	     double propCorrect = (correctCount/ totalCount) * 100;
	     System.out.println ("That's " + propCorrect +"%!");
	}

}
