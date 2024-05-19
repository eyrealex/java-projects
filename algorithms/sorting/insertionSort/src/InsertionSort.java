import java.util.Random;

public class InsertionSort {
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