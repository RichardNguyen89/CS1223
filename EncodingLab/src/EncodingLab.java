/** A program takes in user's string and encode according to rot13 algorithm
 *
 *
 * @author Linh Nguyen
 * @author YOUR PARTNER NAME HERE
 * @version 1142019
 */
import java.util.Scanner;

public class EncodingLab {

    public static final String CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Method that returns a string that is rot13 encoded from the input string.
     *
     * @param input
     *            The string to encode
     * @return The input string with the rot13 algorithm applied to it
     */
    public static String rot13(String input) {
        StringBuilder sb = new StringBuilder();
        // check if character and Upper case
        for (int i =0; i <input.length(); i++) {
        	char charI = input.charAt(i);
        	if (Character.isLetter(charI)&&Character.isUpperCase(charI)) {
        		int index = CAPITALS.indexOf(charI);
        		int rotIdx = (index +13)%26; // take 13 steps and then truncate the 26 if needed
        		
        			
        		char got13 = CAPITALS.charAt(rotIdx);
        		sb.append(got13);
        	}
        	else {
        		sb.append(charI);
        	}
        }
        
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a string to encode: ");
        String input = keyboard.nextLine();
        String encoded = rot13(input);
        System.out.println("Your string encoded is  : " + encoded);
        keyboard.close();
    }

}