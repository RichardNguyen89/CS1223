import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Practice1 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        
        String binary = " ";
        while(n > 0){
            int remainder = n%2;
            n = n/2;
            binary = remainder + binary;
        }
        

        int count =0;
        int consecutive = 0;

        for (int i = 0; i< binary.length(); i++){
            if (binary.charAt(i) == '1'){
                count ++;
                if (count > consecutive){
                    consecutive = count;
                }
            }
            else {
                count =0;
            }
        }
        System.out.println (consecutive);



        scanner.close();
    }
}

