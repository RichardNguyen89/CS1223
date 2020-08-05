import java.util.Scanner;

/**
 * The code will take in some inputs and print them out in predescribed sentences
 */

/**
 * @author linh8
 * @version 08262019
 *
 */
public class ClosedLab01c {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String myName = keyboard.nextLine();
		System.out.print("Enter a whole number: ");
		String myNumber = keyboard.nextLine();
		int value = Integer.parseInt(myNumber);
		System.out.println("Hello "+ myName);
		System.out.println("Your number is: " +value);
		System.out.println("Your number squared is: " + (value*value));
		int cubed = value*value*value;
		System.out.println("Your number cubed is: " + cubed);
		keyboard.close();
	}

}
