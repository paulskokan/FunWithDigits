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
public class FunWithDigits {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // Input maybe able to be read straight into Integers rather than reading as a String,
        // and splitting on commas. I'd need to do some research
        System.out.println("Please enter digits seperated by commas:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        System.out.println("How many Numbers would you like this broken into?");
        String numOfNums = scanner.nextLine();
        
        System.out.println("Would you like to allow duplicates digits in numbers (y/n)?");
        String dupes = scanner.nextLine();
        
        // Take input and convert array 
        // TODO: (maybe do this on entry?)
        String[] inputList = input.split(",");
        Integer[] intArray = new Integer[inputList.length];
        for (int i=0; i<(inputList.length); i++ ) {
            intArray[i] = Integer.parseInt(inputList[i]);
        }
        
        if(Integer.parseInt(numOfNums) > inputList.length) {
            System.out.println("Sorry, you didn't enter enough comma seperated digits for " + numOfNums + " numbers.  Using " + inputList.length + " numbers instead.");
            numOfNums = String.valueOf(inputList.length);
        }
        
        //sort all numbers
        Arrays.parallelSort(intArray);
        //System.out.println(Arrays.toString(intArray));
        
        //Initialize buckets
        List<List<Integer>> digitBuckets;
        digitBuckets = new ArrayList<>(Integer.parseInt(numOfNums));
        for(int i = 0; i < Integer.parseInt(numOfNums); i++) {
            List list = new ArrayList<Integer>();
            digitBuckets.add(list);
        }
        
        // Could probably initialize the buckets while building the number lists
        
        //Put the digits into the buckets, ensuring buckets only contain unique digits
        Integer intArrayPointer = 0;
        while(intArrayPointer < intArray.length) {
            for(List<Integer> intList: digitBuckets) {
                if(intArrayPointer < intArray.length) {
                    Integer curInt = intArray[intArrayPointer];
                    if(dupes.equalsIgnoreCase("n")) {
                        if(!intList.contains(curInt)) {
                            intList.add(curInt);
                        }
                    } else {
                        intList.add(curInt);
                    }
                }
                intArrayPointer++;
            }
        }
        //System.out.println(digitBuckets);
        
        // Maybe able to combine the below function and above function
        // to make less loop iterations
        
        //Pull the numbers out of the buckets and put back in Integers
        List<Double> finalNumbers = new ArrayList();
        Double result = new Double(0);
        for(List<Integer> intList: digitBuckets) {
            Double curNumber = new Double(0);
            Double curExp = new Double(1);
            for(Integer curInt:intList) {
                curNumber += curInt * curExp;
                curExp = curExp * 10;
            }
            finalNumbers.add(curNumber);
            System.out.println(curNumber);
        }
        
        //Add the numbers
        for(Double dToAdd: finalNumbers) {
            result += dToAdd;
        }
        
        
        //Display the output
        System.out.println("+_______________________________");
        System.out.println(result);
        
        //Beleive it works!!!!
        
    }
    
}
