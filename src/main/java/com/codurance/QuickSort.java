package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    private List<Integer> integerAsArray;
    private List<Integer> finalSortedArray;

    public List<Integer> sort(int numberToBeSorted) {
        // declare final sorted array
        finalSortedArray = new ArrayList<>();

        // convert the unsorted integer into integer array
        integerAsArray = convertIntegersToArray(numberToBeSorted);
        return sortRecursively(integerAsArray);
    }

    private List<Integer> sortRecursively(List<Integer> arrayToBeSorted) {

        // Define a pivot point (approx half in this case
        Integer length = arrayToBeSorted.size() - 1;
        Integer pivotIndex = length / 2;
        Integer pivotValue = arrayToBeSorted.get(pivotIndex);

        // Split the array either side of the pivot
        List<Integer> leftSubArray = new ArrayList<>();
        Integer i = 0;
        while(i < pivotIndex) {
            leftSubArray.add(arrayToBeSorted.get(i));
            i++;
        }

        List<Integer> rightSubArray = new ArrayList<>();
        Integer j = pivotIndex + 1;
        while(j <= length) {
            rightSubArray.add(arrayToBeSorted.get(j));
            j++;
        }

        // Testing the output
        System.out.println("Pivot");
        System.out.println(pivotValue + "\n");
        System.out.println("Array to be sorted");
        System.out.println(arrayToBeSorted+ "\n");
        System.out.println("Left SubArray");
        System.out.println(leftSubArray + "\n");
        System.out.println("Right SubArray");
        System.out.printf(rightSubArray + "\n\n");

        // Create copies of sub arrays
        List<Integer> leftSubArrayCopy = new ArrayList<>(leftSubArray);
        List<Integer> rightSubArrayCopy = new ArrayList<>(rightSubArray);

        // Any numbers greater than the pivot value in the left sub array go to the right sub array
        leftSubArray.stream().
                filter(number -> number > pivotValue).
                forEach(number -> {
                    leftSubArrayCopy.remove(number);
                    rightSubArrayCopy.add(number);
                });


        //Any numbers less than the pivot value in the right sub array go into the left sub array
        rightSubArray.stream()
                .filter(number -> number < pivotValue)
                .forEach(number -> {
                    rightSubArrayCopy.remove(number);
                    leftSubArrayCopy.add(number);
                });

        leftSubArrayCopy.add(leftSubArrayCopy.size(), pivotValue);

        // Testing the output
        System.out.println("Left SubArray Copy (sorted)");
        System.out.println(leftSubArrayCopy + "\n");
        System.out.println("Right SubArray Copy (Sorted)");
        System.out.printf(rightSubArrayCopy + "\n\n");

        // If a sub array size is 1 then stop
        // Else keep doing the above operation recursively
        // once two sub arrays has been sorted then combine with the pivot and jump
        // up a level to combine parent arrays

        if(leftSubArrayCopy.size() > 1) {
            sortRecursively(leftSubArrayCopy);
        }

        if(leftSubArrayCopy.size() == 1) {
            finalSortedArray.add(leftSubArrayCopy.get(0));
        }

        if(rightSubArrayCopy.size() > 1) {
            sortRecursively(rightSubArrayCopy);
        }

        if(rightSubArrayCopy.size() == 1) {
            finalSortedArray.add(rightSubArrayCopy.get(0));
        }

        // Testing the output
        System.out.println("Final sorted Array");
        System.out.println(finalSortedArray + "\n\n");

        return finalSortedArray;
    }

    private List<Integer> convertIntegersToArray(int numberToBeSorted) {
        List<Integer> integerAsArray = new ArrayList<>();
        while(numberToBeSorted > 0) {
            integerAsArray.add(numberToBeSorted % 10);
            numberToBeSorted /= 10;
        }
        return integerAsArray;
    }
}
