/**
 * Ask for user inputs and then print out scores proportionally based on the user's inputs
 * @author LINH NGUYEN
 * @version 10102019
 */
import java.util.Scanner;
public class BarChartScoreboard {
    public static int getMaxValue(int[] numbers){// find the max value for score
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
        	if(numbers[i] > maxValue){
        		maxValue = numbers[i];
        	}
        }
        if (maxValue ==0) {// deal with Zero
        	maxValue = 50;
        }
        return maxValue;
    }
    
    public static void printAsterisk (int scoreAsterisk) { // print asterisk based on score
    	for (int i = 0; i <scoreAsterisk; ++i) {
        	System.out.print('*');
        }
    	System.out.println();
    }
    
    public static void formatNames (String [] name) { // format names by padding
    	String max = name[0];
    	for (int pos = 0; pos < name.length; ++pos) {
    		if (name[pos].length()>max.length()) {
    			max = name[pos];
    		}
    	}
    	for (int i = 0; i < name.length; ++i) {
    		if (name[i].length()< max.length()) {
    			while (max.length()-name[i].length()>0) {
    				name[i] = name[i]+ " ";
    			}
    		}
    	}
    }
    
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print ("Enter the number of players: ");
        String numberPlayers = keyboard.nextLine();
        int numPlayers = Integer.parseInt (numberPlayers);
        /* ask users for number of players and other inputs
         * repeat until reaching the number of players
         */
        if (numPlayers == 0) {
            System.out.println ("No players to display?  Goodbye!");
        }
        else {
            String [] namePlayers = new String[numPlayers];
            int [] scorePlayers = new int[numPlayers];
            for (int i= 0; i < numPlayers; ++i){
                System.out.print ("Enter a player name: ");
                String nameInput = keyboard.nextLine();
                namePlayers [i] = nameInput;
                System.out.print ("Enter the score for " + nameInput + ": ");
                String scoreInput = keyboard.nextLine();
                int score = Integer.parseInt (scoreInput);
                scorePlayers[i]= score;
                System.out.println ();
            }
        String announ= "Current Scoreboard";   
        System.out.println(announ);
        for (int i = 0; i <announ.length(); ++i) {
        	System.out.print('-');
        }
    	System.out.println();
        
        int maxScore = getMaxValue (scorePlayers); // get maxScore
        
        formatNames(namePlayers); //using method to format names
        for (int i = 0; i <namePlayers.length; ++i) {
        	System.out.print(namePlayers[i]);
        	System.out.print(" ");
        	printAsterisk(scorePlayers[i]*50/maxScore); // print asterisks based on the score proportionally
        }
        }
        keyboard.close();
    }
}