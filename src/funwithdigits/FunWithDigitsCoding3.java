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
public class FunWithDigitsCoding3 {

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
        
        //initalize buckets
        List<List<Integer>> digitBuckets;
        digitBuckets = new ArrayList<>(2);
        for(int i = 0; i < 2; i++) {
            List list = new ArrayList<Integer>();
            digitBuckets.add(list);
        }
        
        //Put the digits into the buckets, ensuring buckets only contain unique digits
        Integer intArrayPointer = 0;
        while(intArrayPointer < intArray.length) {
            for(List<Integer> intList: digitBuckets) {
                if(intArrayPointer < intArray.length) {
                    Integer curInt = intArray[intArrayPointer];
                    if(!intList.contains(curInt)) {
                        intList.add(curInt);
                    }
                }
                intArrayPointer++;
            }
        }
        
        System.out.println(digitBuckets);
        
        //Pull the numbers out of the buckets and put back in to Objects
        List<Double> finalNumbers = new ArrayList();
        Double result = new Double(0);
        for(List<Integer> intList: digitBuckets) {
            Double curNumber = new Double(0);
            Double curExp = new Double(1);
            for(Integer curInt:intList) {
                curNumber += curInt * curExp;
                curExp = curExp * 10;
            }
            System.out.println(curNumber);
            finalNumbers.add(curNumber);
        }
        
        //Add the numbers
        for(Double dToAdd: finalNumbers) {
            result += dToAdd;
        }
        
        //Display the output
        System.out.println(result);
        
        //Beleive it works!!!!
        
    }
    
}
