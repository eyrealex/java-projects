import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        System.out.println("\n10 Random numbers to be sorted \n" + Arrays.toString(numbers));
        selctionSort(numbers);
        System.out.println("\n10 Random numbers have been sorted \n" + Arrays.toString(numbers));
    }

    private static void selctionSort(int[] numbers) {

        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) { //loop through the array of random numbers
            int minNum = numbers[i]; //the minimum value is equal to the first position in array
            int indexOfNum = i; //the position of the minimum number in the array is also at the first position
            for (int j = i + 1; j < length; j++) { //loop through the array to find the minimum number
                if (numbers[j] < minNum) { //if the number at j is less than the minimum
                    minNum = numbers[j]; //then we have found minimum number
                    indexOfNum = j; //this min number is found at this index
                }
            }
            swap(numbers, i, indexOfNum); //method to swap array of numbers at position i with the index of minimum number

        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a]; //create a temporary value to store original value of a
        numbers[a] = numbers[b]; //assign value at index b to index a
        numbers[b] = temp; //assign value of temp to index b
    }
}