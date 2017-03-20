/*
 * Fun with digits
 * Coding exercise for AppThis
 * See fun_with_digits_and_numbers.pdf for background, reruiements, etc.
 */
package funwithdigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pskokan paul.skokan@gmail.com
 */
public class FunWithDigitsCoding2 {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
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
        List<List<Integer>> digitBuckets;
        digitBuckets = new ArrayList(2);
        for(List list:digitBuckets) {
            list = new ArrayList<>();
        }
        
        //Put the digits into the buckets, ensuring buckets only contain unique digits
        Integer intArrayPointer = 0;
        while(intArrayPointer != intArray.length) {
            for(int i = 0; i < digitBuckets.size(); i++ ) {
                intArrayPointer++;
            }
        }
        
        //Add the 2 numbers
        
        //Display the output
        
        //Beleive it works!!!!
        
    }
    
}
