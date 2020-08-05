/**
 * 
 */

/**This program should ask the user to enter a String and should loop until the user enters an empty
String. If the user has entered at least one String, the program should report the longest and shortest
strings entered by the user
 * @author linh8
 *
 */
import java.util.Scanner;
public class SampleExam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean strEmpty = false;
		String longest = "";
		String shortest = "";
		
		
		while (input != "") {
			System.out.print ("Enter a value: ");
			String input = in.nextLine();
			
			if (input.length()>longest.length()) {
				longest = input;
							
			}
			
			if (input.length()<shortest.length() || shortest = ""){
				shortest = input;
				
				
			}
			}
			else {
				input = "";
			}
	}
}
}