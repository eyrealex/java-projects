import java.util.Random;

public class InsertionSort {

    /*
        INSERTION SORT solution
        Take Array {5, 4, 3, 2, 6}, consists of 5 numbers
        Make a temp variable for the second index value in array
        Compare it with the value at the first index
        If the first index is larger than second we move first index into the position that the second was at
        Then we want to return to position before first index in order to add the temp variable
        Iterate and repeat
        When while loop conditions have not been met, loop continues creating temps and moving them to beginning of array
        When while loop condition is met, all values have been inserted correctly

    */
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        printArray(array);
        insertionSort(array);
        printArray(array);

    }

    private static void insertionSort(int[] array) {

        // we want to start with the second index in the array
        for (int i = 1; i < array.length; i++) { //iterate i every time the while loop exits and sort again.
            int temp = array[i]; //set it to a temp value

            int j = i - 1; // we set j as the first index of the array
            while (j >= 0 && array[j] > temp) { // loop until negative 0 or array[j] is not larger than temp
                array[j + 1] = array[j]; // set the second index to value of first
                j--; // then go backward to beginning of array
            }
            array[j + 1] = temp; // set temp to the value in the array where j+1 was
        }
    }

    private static void printArray(int[] array) {

        System.out.println(" ");
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
    }
}