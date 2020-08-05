/**
 * Program reads in each line of a file and produces reversed strings and copy that into the second file using line commands
 *
 * @author Linh Nguyen
 * @author YOUR PARTNER NAME HERE
 * @version 10282019
 *
 */
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class CopyFile {

    /**
     * Returns the reverse of the input String inString.
     *
     * @param inString
     *            the String to be reversed
     * @return the reverse of inString
     */
    public static String reverse(String inString) {
        String reverseStr = "";
        for (int i = inString.length()-1; i >=0; i--) {
        	reverseStr = reverseStr + inString.charAt(i);
        	
        }

        
        return reverseStr;
    }

    public static void main(String[] args) {
    	Scanner keyboard = new Scanner (System.in);
    	System.out.print ("Enter the first filename: ");
    	String fname1 = keyboard.nextLine();
    	System.out.print ("Enter the second filename: ");
    	String fname2 = keyboard.nextLine();
        // Prompt the user for a filename

        // Open the file and print each line to the screen.
        // Don't forget to close the file when you are done.
        try {
        	File textFile = new File(fname1);
        	Scanner textScanner = new Scanner(textFile);
        	File textFile2 = new File(fname2);
        	PrintWriter textWriter = new PrintWriter(textFile2); //open new file
        	
        	while (textScanner.hasNext()) {
        		// Read a line from the file.
        		String str = textScanner.nextLine();
        		// call reverse
        		String reversedstr = reverse(str);
        		String upperReversed = reversedstr.toUpperCase();
        		//print to the second file
        		textWriter.println(upperReversed);
        		System.out.println(upperReversed);
        	}
        	textScanner.close();
        	textWriter.close();
        } catch (FileNotFoundException e) {
        	System.out.println ("Error - cannot open file " + fname1);

        }
        keyboard.close();
        
        
        
    }

}