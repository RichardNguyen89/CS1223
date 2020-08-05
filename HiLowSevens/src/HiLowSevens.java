
/**
 * Program asks for user' bet amount, choice and runs random dice rolls. It returns winning/losing amount based on user's choice and total score of the dices. 
 * Program stops if user runs out of money or enter bet amount 0
 * @author Linh Nguyen
 * @version 10292019
 *
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HiLowSevens {

	/**
	 * Prompts the user for an amount to bet. Ensures that the amount will be
	 * between 0 and the maximum number of dollars they have available.
	 *
	 * @param in         A Scanner to provide input
	 * @param maxDollars the maximum number of dollars available
	 * @return the amount to bet, guaranteed to be between 0 and maxDollars
	 */
	public static int promptForAmount(Scanner in, int maxDollars) {

		System.out.print("Enter an amount to bet (0 to quit): ");
		String inputAm = in.nextLine();
		int inputAmount = Integer.parseInt(inputAm);

		while (inputAmount < 0 || inputAmount > maxDollars) {// loop until the input Amount is within range
			System.out.println("Your bet must be between 0 and " + maxDollars + " dollars.");
			System.out.printf("You have %d dollars.%n", maxDollars);
			System.out.print("Enter an amount to bet (0 to quit): ");
			inputAm = in.nextLine();
			inputAmount = Integer.parseInt(inputAm);
		}
		return inputAmount;
	}

	/**
	 * Prompts the user to enter a single character and ensures that the user must
	 * input either an 'H', an 'L' or an 'S'. If they enter a correct character in
	 * lowercase, converts it to uppercase.
	 *
	 * @param in A Scanner to provide input
	 * @return a choice of 'H', 'L' or 'S' guaranteed to be in uppercase.
	 */
	public static char promptForChoice(Scanner in) {
		System.out.print("High, low or sevens (H/L/S)?: ");
		String inputChoice = in.nextLine();
		char fUpperChoice = ' ';
		boolean stop = false;
		while (!stop) {// loop until condition is reached
			if (inputChoice.length() != 1) { // handle strings with length different from 1
				System.out.println("You must enter only H, L or S.");
				System.out.print("High, low or sevens (H/L/S)?: ");
				inputChoice = in.nextLine();
			} 
			else { // when string length = 1
				char choice = inputChoice.charAt(0);
				char upperChoice = Character.toUpperCase(choice);
				if (upperChoice != 'H' && upperChoice != 'L' && upperChoice != 'S') {// check choice
					System.out.println("You must enter only H, L or S.");
					System.out.print("High, low or sevens (H/L/S)?: ");
					inputChoice = in.nextLine();
				}
				else { // when meet both length = 1 and choice within H L S
					fUpperChoice = upperChoice;
					stop = true;
				}
			}
		}
		return fUpperChoice;
	}

	/**
	 * Returns an array of length numDice where each entry holds a random value
	 * between 1 and 6 (representing the roll of a single die).
	 *
	 * @param rnd     A Random number generator to use
	 * @param numDice number of dice to roll
	 * @return an array containing numDice values between 1 and 6
	 */
	public static int[] rollDice(Random rnd, int numDice) {
		int[] numberOfDices = new int[numDice];
		for (int i = 0; i < numDice; i++) {
			int resultDice = rnd.nextInt(6) + 1;
			numberOfDices[i] = resultDice;
		}
		return numberOfDices;
	}

	/**
	 * Returns the sum of all of the values in the array dice. Note that this method
	 * should be able to be called with an arbitrary number of dice so do not
	 * hardcode it to only work with 2 dice.
	 *
	 * @param dice the values to be displayed
	 * @return the sum of the values in the array dice
	 */
	public static int totalDice(int[] dice) {
		int sumDice = 0;
		for (int j = 0; j < dice.length; j++) {
			sumDice = dice[j] + sumDice;
		}
		return sumDice;
	}

	/**
	 * Returns the amount won or lost according to the choice made, the total on the
	 * dice and the bet. If the choice is 'S' and the total is 7 this is 4 times the
	 * bet. If the choice is 'H' and the total is >=8 this is the same as the bet.
	 * If the choice is 'L' and the total is <=6 - it is also the same as the bet
	 * Otherwise, the player has lost and this function returns the negative value
	 * of their bet.
	 *
	 * @param choice One of 'H', 'L', or 'S' - must be uppercase
	 * @param total  the total of the dice rolled
	 * @param bet    the dollar amount that has been bet
	 * @return the correct amount won or lost according to the rules of the game.
	 */
	public static int determineWinnings(char choice, int total, int bet) {
		int winningAmount = 0;
		if (choice == 'H') {// check choice vs roll and return winning/lost amount
			if (total >= 8) {
				winningAmount = bet;
			} else {
				winningAmount = -bet;
			}
		} else if (choice == 'L') {
			if (total <= 6) {
				winningAmount = bet;
			} else {
				winningAmount = -bet;
			}
		} else {
			if (total == 7) {
				winningAmount = bet * 4;
			} else {
				winningAmount = -bet;
			}
		}
		return winningAmount;
	}

	public static void main(String[] args) {
		// set up scanner
		Scanner keyboard = new Scanner(System.in);
		// set up random
		Random rnd = new Random();
		System.out.print("Enter a random seed: ");
		// ask for seed
		String s = keyboard.nextLine();
		int s1 = Integer.parseInt(s);
		rnd.setSeed(s1);

		// set up original max dollar 100
		int maxDollars = 100;
		boolean stop = false;

		while (!stop) {// loop till player stops or runs out of money
			if (maxDollars <= 0) {// check if player still has money. Otherwise stop.
				stop = true;
			} 
			else {// if player has money
				System.out.printf("You have %d dollars.%n", maxDollars);
				int bet = promptForAmount(keyboard, maxDollars);
				if (bet > 0) {// check bet >0

					// ask for choice
					char choice = promptForChoice(keyboard);

					// roll dice
					int numDice = 2; // assume 2 dices so the program can run. Change if needed
					int[] dices = rollDice(rnd, numDice);
					System.out.printf("Your dice are showing: %s%n", Arrays.toString(dices));

					// sum dice
					int sumAllDices = totalDice(dices);
					System.out.printf("Your total is: %d%n", sumAllDices);

					// determine winning
					int winning = determineWinnings(choice, sumAllDices, bet);
					if (winning > 0) {// print prompt when winning
						System.out.printf("You won %d dollars!%n", winning);
					}
					else {// print prompt when losing
						System.out.printf("You lost your bet!");
						System.out.println();
					}

					// update maxDollars
					maxDollars = maxDollars + winning;
					System.out.println();
				} else {// stop when bet is 0
					stop = true;
				}
			}
		}
		
		System.out.println();
		System.out.println("You ended the game with " + maxDollars + " dollars left.");
		System.out.println("Goodbye!");
		keyboard.close();
	}
}