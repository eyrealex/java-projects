import java.util.Random;

public class MergeSort {


    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[1000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }

        System.out.println("\nPrinting array before sorted: ");
        printArray(array);

        //sort the array
        mergeSort(array);

        System.out.println("\nPrinting array after sorted: ");
        printArray(array);

    }

    private static void mergeSort(int[] array) {

        // if the array has only 1 number exit this method
        if (array.length < 2) {
            return;
        }

        int splitArray = array.length / 2; //split original array in half
        int[] leftHalf = new int[splitArray]; //create the left half of the split
        int[] rightHalf = new int[array.length - splitArray]; //create right half of split but instead take original array and subtract the split value to deal with odd numbers


        //since left half is a new int array, we need to fill the left half array with the actual values on the left of the split
        for (int i = 0; i < splitArray; i++) {
            leftHalf[i] = array[i];
        }

        //do the same for the right
        for (int i = splitArray; i < array.length; i++) {
            rightHalf[i - splitArray] = array[i];
        }

        //call recursion to keep splitting both halves of the array until they reach an element size of 1
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //when array consists of only single element numbers, the baseline is reached, recursion does not happen
        //pass all the single element numbers from both halves into merge method
        //note the elements are not sorted numerically yet
        merge(array, leftHalf, rightHalf);

    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //need 3 iterators to merge, i iterates left half, j iterates right half, k iterates merged array
        int i = 0, j = 0, k = 0;

        //loop until no more elements in both halves of the array.
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) { //compare i element on left with j element on right
                array[k] = leftHalf[i]; // add this element to the merged array
                i++; //move to next element for next round of comparison
            } else {
                array[k] = rightHalf[j]; // otherwise add right side element to merged array
                j++; //move to next element for next round of comparison
            }
            k++; //we also need to move to next position of merged array to avoid duplicating the elements from left and right halves
        }

        //account for any elements left in left array
        while (i < leftSize) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }

        //account for any elements left in right array
        while (j < rightSize) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    private static void printArray(int[] array) {

        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }

    }
}

