/*
 * Fun with digits
 * Coding exercise for AppThis
 * See fun_with_digits_and_numbers.pdf for background, reruiements, etc.
 */
package funwithdigits;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pskokan paul.skokan@gmail.com
 */
public class FunWithDigitsCoding1 {

    /**
     * @param args the command line arguments
     * 
     */
    public void main(String[] args) {
        System.out.println("Please enter digits seperated by commas:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        // Take input and convert array 
        // TODO: (maybe do this on entry?)
        String[] inputList = input.split(",");
        Integer[] intArray = new Integer[inputList.length];
        for (int i=0; i<(inputList.length); i++ ) {
            intArray[i] = Integer.parseInt(inputList[i]);
        }
        
        //sort all numbers
        Arrays.parallelSort(intArray);
        System.out.println(Arrays.toString(intArray));
        
        //put numbers into buckets, only allowing unique digits in buckets
        
        
        //If the length of input list is odd, 1 and 0 should create a special case and become 10
        
        //Add the 2 numbers
        
        //Display the output
        
        //Beleive it works!!!!
        
    }
    
}
