/**
 * YOUR DESCRIPTION OF THE CODE HERE
 * @author YOUR NAME HERE
 * @version DATE HERE
 */
import java.util.Scanner;

public class HailstoneSeries {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a starting value: ");
        int input = keyboard.nextInt();
        
        System.out.print(input + ",");
        System.out.print(" ");
        
        while (input !=1 ) {
        	if (input%2 == 0) {
        		input = input/2;
        		System.out.print(input + ",");
        		System.out.print(" ");
        }
        	else {
        		input = 3*input +1;
        		System.out.print(input + ",");
        		System.out.print(" ");
        }
        
        }
    
        System.out.print(1);	
        keyboard.close();
    }
}