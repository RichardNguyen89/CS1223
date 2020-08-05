
/**
 * The program is based on the guess word game. 
 * It first asks the user to enter a filename to open a file. 
 * It then reads the words in the file. 
 * After that, the program chooses a random word to begin the game by coding it into a starword of the same 
 * length. The program then ask for the user's character guess and return how many times it appears 
 * in the word. If the character is already guessed before, the program returns an error message and ask
 * for a new one. If not, the guess is added into a previous guess array. 
 * It then displays the revealed starword by piece. 
 * Finally, it asks the user for the full guess word. 
 * If this is correct, it asks the users to play again or not. 
 * If no, it continues to ask the player to guess each character and repeat the process again.  
 * 
 * 
 * @author Linh Nguyen
 * @version 11212019
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessing {

	/**
	 * Takes a filename as input. Reads a list of words from the file into a list
	 * and returns the list. Ensures that all of the words in the list are in
	 * UPPERCASE (i.e. transforms lowercase letters to uppercase before adding them
	 * to the list). Assumes that the file will be correctly formatted with one word
	 * per line (though there may be blank lines with no words on them). If the file
	 * cannot be read prints the error message "ERROR: File fname not found!" where
	 * "fname" is the name of the file and returns an empty list. Note that the
	 * order of the words in the list must be the same as the order of the words in
	 * the file to pass the test cases.
	 *
	 * @param fname the name of the file to read words from
	 * @return a list of words read from the file in all uppercase letters.
	 */
	public static List<String> readWords(String fname) {
		List<String> words = new ArrayList<String>();
		try {
			File readFile = new File(fname);
			Scanner textScanner = new Scanner(readFile);
			while (textScanner.hasNext()) {
				String str = textScanner.nextLine(); // read in line
				if (str.length() > 0) {// deal with blank space.
					words.add(str.toUpperCase());
				} // add uppercase into ArrayList
			}
			textScanner.close();
			System.out.println("Read " + words.size() + " words from the file.");
		} catch (FileNotFoundException e) { // error message when file not found
			System.out.println("ERROR: File " + fname + " not found!");
			System.out.println("No words read - exiting program!");

		}

		return words;
	}

	/**
	 * Takes a Random object and a list of strings and returns a random String from
	 * the list. Note that this method must not change the list. The list is
	 * guaranteed to have one or more elements in it.
	 *
	 * @param rnd    Random number generator object
	 * @param inList list of strings to choose from
	 * @return an element from a random position in the list
	 */
	public static String getRandomWord(Random rnd, List<String> inList) {
		return inList.get(rnd.nextInt(inList.size())); // get random word within range of inList. because the range will
														// be less than size so it should not be out of bound.

	}

	/**
	 * Given a String, returns a StringBuilder object that is the same length but is
	 * only '*' characters. For example, given the String DOG as input returns a
	 * StringBuilder object containing "***".
	 *
	 * @param inWord The String to be starred
	 * @return a StringBuilder with the same length as inWord, but all stars
	 */
	public static StringBuilder starWord(String inWord) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inWord.length(); i++) {
			sb.append('*');
		}

		return sb;
	}

	/**
	 * Prompts the user to enter a single character. If the user enters a blank line
	 * or more than one character, give an error message as given in the assignment
	 * and prompt them again. When the user enters a single character, return the
	 * uppercase value of the character they typed.
	 *
	 * @param inScanner A scanner to take user input from
	 * @return the uppercase value of the character typed by the user.
	 */
	public static char getCharacterGuess(Scanner inScanner) {
		System.out.print("Enter a character to guess: ");
		String input = inScanner.nextLine();
		while (input.length() != 1) {
			System.out.println("Enter only a single character!");
			System.out.print("Enter a character to guess: ");
			input = inScanner.nextLine();
		}

		return input.toUpperCase().charAt(0);
	}

	/**
	 * After get the character guess from the user input, check to see whether it is
	 * in the previous guess. If it is in, print an error message and ask for
	 * another one. If not, add into the previous guess.
	 * 
	 * @param ch            the character input of the user
	 * @param previousGuess An arraylist that holds the previous guess value
	 * @param Scanner       A scanner to get the new character
	 * @return the boolean value of contain or not
	 */
	public static boolean checkPrevious(char ch, List<Character> previousGuess) {

		// FIXME deal with loop
		boolean contain = false;

		for (int i = 0; i < previousGuess.size(); i++) {
			if (ch == (previousGuess.get(i))) {
				contain = true;
			}
		}
		return contain;
	}

	/**
	 * Count the number of times the character ch appears in the String word.
	 *
	 * @param ch   character to count.
	 * @param word String to examine for the character ch.
	 * @return a count of the number of times the character ch appears in the String
	 *         word
	 */
	public static int charCount(char ch, String word) {
		int count = 0;

		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Modify the StringBuilder object starWord everywhere the char ch appears in
	 * the String word. For example, if ch is 'G', word is "GEOLOGY", and starWord
	 * is "**O*O*Y", then this method modifies starWord to be "G*O*OGY". Your code
	 * should assume that word and starWord are the same length.
	 *
	 * @param ch       the character to look for in word.
	 * @param word     the String containing the full word.
	 * @param starWord the StringBuilder containing the full word masked by stars.
	 */
	public static void modifyStarWord(char ch, String word, StringBuilder starWord) {
		for (int i = 0; i < word.length(); i++) {
			if (ch == word.charAt(i)) {
				starWord.setCharAt(i, ch);
			}
		}
		System.out.println("The word to guess is: " + starWord);

	}

	/**
	 * After the user correctly guesses a word, ask him whether he want to continue
	 * to play or not. Only accept y or n in both uppercase and lowercase. Return
	 * the uppercase of the user's choice
	 * 
	 * @param inScanner the Scanner to take in the input of the user
	 * @return the uppercase value of the character typed by the user.
	 */

	public static char getChoice(Scanner inScanner) {
		System.out.print("Would you like a rematch [Y/N]?: ");
		String input = inScanner.nextLine();
		while (!(input.length() == 1
				&& (Character.toUpperCase(input.charAt(0)) == 'Y' && Character.toUpperCase(input.charAt(0)) == 'N'))) {
			System.out.println("Please enter only a Y or an N.");
			System.out.print("Would you like a rematch [Y/N]?: ");
			input = inScanner.nextLine();
		}
		char UpperChoice = Character.toUpperCase(input.charAt(0));
		return UpperChoice;
	}

	/**
	 * The method display the modifyStarWord and then print out the previous
	 * characters guessed. Then prompt the player for a Character Guess and then
	 * check to see whether this character is in previous guess. Then it shows how
	 * many the guess appears in the word. Before asking for the fullGuess. Return
	 * the fullGuess string
	 * 
	 * @param inScanner     the Scanner to take in the input of the user
	 * @param ch            the character guess of the user. First one is blank to
	 *                      not show anything
	 * @param word          the string word that was picked to guess
	 * @param sb            the StringBuilder with star
	 * @param previousGuess an ArrayList that contains all the previous guessed
	 *                      character
	 * @return fullGuess the String of the fullGuess by the user.
	 */
	public static String fullGuess(char ch, String word, StringBuilder sb, Scanner inScanner,
			List<Character> previousGuess) {
		modifyStarWord(ch, word, sb);
		// print out the previous guess character
		System.out.println("Previous characters guessed: " + Arrays.toString(previousGuess.toArray()));
		// ask for guess and add the character into the previous guess array
		ch = getCharacterGuess(inScanner);

		while (checkPrevious(ch, previousGuess) == true) { // check whether the guess character is already used.
			System.out.println("Error- you already guessed this character. Please enter a different one");
			ch = getCharacterGuess(inScanner);
		}
		previousGuess.add(ch);
		// call char count
		int count = charCount(ch, word);

		System.out.println("The character " + ch + " occurs in " + count + " positions.");
		System.out.println();

		// call modify star
		modifyStarWord(ch, word, sb);
		// ask for guess of full word
		System.out.print("Enter your guess for the word: ");
		String fullGuess = inScanner.nextLine();
		return fullGuess;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		System.out.print("Enter a random seed: ");
		int seed = Integer.parseInt(in.nextLine());
		rnd.setSeed(seed);
		// ask for filename and print out how many words read from the file
		System.out.print("Enter a filename for your wordlist: ");
		String inFile = in.nextLine();
		// read from file
		List<String> arr = readWords(inFile);

		// loop from here when restart
		char playChoice = 0; // initiate player's choice to be blank
		while (arr.size() != 0 && playChoice != 'N') {
			System.out.println();
			// get a random word to start the game
			String word = getRandomWord(rnd, arr);
			// Print out the word to guess in stars
			StringBuilder sb = starWord(word);

			// create an arraylist to hold the guess
			ArrayList<Character> previousGuess = new ArrayList<>();

			char ch = 0; // initiate first character to be blank. This allows the first call of
							// modifyStarWord with a blank character which return full starWorld. This is
							// enable the same uniform steps used for fullGuess
			String fullGuess = fullGuess(ch, word, sb, in, previousGuess);

			int numOfGuess = 1; // set up number of guess. start from 1 because of the previous gueess one
			while (!fullGuess.toUpperCase().equals(word.toUpperCase())) { // loop until full guess word equals the
																			// picked word
				System.out.println("That is not the word.");
				System.out.println();
				System.out.println();
				fullGuess = fullGuess(ch, word, sb, in, previousGuess);
				numOfGuess++;
			}
			System.out.println("Yes! " + word.toUpperCase() + " is the correct word!");
			System.out.println();
			System.out.println("That took you " + numOfGuess + " guesses.");
			playChoice = getChoice(in);
		}
		System.out.println("Goodbye!");
		in.close();
	}

}