/**
 * A program that tests the SimpleStringBuilder class created in this lab.
 *
 * @author Jeremy Morris
 * @version 20181101
 *
 */

public class TestSimpleStringBuilder {

    /**
     * A simple program used to test the SimpleStringBuilder class
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleStringBuilder myBuilder = new SimpleStringBuilder("Hello World");
        System.out.println("String is: " + myBuilder.toString());

        // Code below this comment will not work until you complete the required methods
        System.out.println("Length is: " + myBuilder.length());
        System.out.println("Char 3 is: " + myBuilder.charAt(3));
        myBuilder.replaceCharAt(3, 'p');
        System.out.println("String is: " + myBuilder.toString());

        // Code below this comment will not work until you complete the extra methods
                myBuilder.append('!');
                System.out.println("String is: "+myBuilder.toString());
                myBuilder.deleteCharAt(3);
                System.out.println("String is: "+myBuilder.toString());
                System.out.println("Length is: "+myBuilder.length());
                myBuilder.insert(3, 'z');
               System.out.println("String is: "+myBuilder.toString());
                System.out.println("Length is: "+myBuilder.length());

    }

}