//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    /*
        SELECTION SORT solution
        Take Array {4, 5, 1, 2, 3}, consists of 5 numbers
        Start at first position = 4 and go through the array and find the index of smalled number found = 1 at index 2.
        Swap 1 with 4
        Repeat for start at next position in array = 5
    */

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = random.nextInt(10000);
        }

        System.out.println("\n10 Random numbers to be sorted \n" + Arrays.toString(numbers));
        selctionSort(numbers);
        System.out.println("\n10 Random numbers have been sorted \n" + Arrays.toString(numbers));
    }

    private static void selctionSort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            int minNum = numbers[i]; //min num value to hold value in array at position i
            int indexOfNum = i; //also save the index of this number

            for (int j = i + 1; j < length; j++) { //start j loop at i + 1 in order to compare index 0, 1, iterate j so next you compare indexes at 1, 2 etc
                if (numbers[j] < minNum) { //if the num at j is less than i
                    minNum = numbers[j]; //set a new min num
                    indexOfNum = j; //set the index of this new min num
                }
            }

            swap(numbers, i, indexOfNum); //pass the array, i and index of j  into a swap method, so we can swap the values at index i with the values at index j
        }

    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
