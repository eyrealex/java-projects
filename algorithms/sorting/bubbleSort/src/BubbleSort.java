import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        printArray(array);
        bubbleSort(array);
        printArray(array);

    }

    private static void bubbleSort(int[] array) {

        //create a boolean flag to enter the while loop condition
        boolean swapped = true;

        // loop while swapped is true
        while (swapped) {
            swapped = false; //set the flag to false initially
            for (int i = 0; i < array.length - 1; i++) { //loop through length of array and give it -1 so we don't hit an out of bounds
                if (array[i] > array[i + 1]) { // if value a > value b
                    swapped = true; //set flag to false, this will allow the while loop to enter again for next iteration
                    int temp = array[i]; //swap values a with b
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
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