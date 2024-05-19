import java.util.Random;

public class MergeSort {

    /*
        MERGE SORT solution
        Take Array {7, 4, 1, 9, 8, 3, 9}, consists of 7 numbers
        Recursively Split array into two halves, until we end up with single elements
        Left half [7, 4, 1] and Right half [9, 8, 3, 9]
        Left half [7],  [4, 1] and Right half [9, 8], [3, 9]
        Left half [7], [4], [1] and Right half [9], [8], [3], [9]
        Now we want to begin the merge sort by merging the smallest sub arrays first
        Left half [1, 4] then [1, 4, 7], Right half [8, 9] then [3, 9], then [3, 9] [8, 9], then [3, 8, 9, 9]
        Left half [1, 4, 7], Right half [3, 8, 9, 9]
        Compare the numbers on left with right, 1->3, 4->3, 4->8, 7->8, 8, 9->9, 9
        Merge sort complete [1, 3, 4, 7, 8, 9, 9]
    */

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[7];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
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

        int splitArray = array.length / 2; //split original array in half, in uneven array left half has the lesser values
        int[] leftHalf = new int[splitArray]; //create the using this split away
        int[] rightHalf = new int[array.length - splitArray]; //right away is the length of the array - the split to get remaining values


        //since left half is a new int array, we need to fill the left half array with the actual values on the left of the split
        for (int i = 0; i < splitArray; i++) {
            leftHalf[i] = array[i];
        }

        //do the same for the right
        for (int i = splitArray; i < array.length; i++) {
            rightHalf[i - splitArray] = array[i]; //get 1st index of right array and set it to value of original array at that index
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

        //loop until we run out of elements in the left or right array.
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) { //compare ith element on left with jth element on right to find smaller element, if both equal left half gets added
                array[k] = leftHalf[i]; // add this element to the merged array at k since it is the smaller value
                i++; //iterate i to check the next value in left array
            } else {
                array[k] = rightHalf[j]; // otherwise add right side element to merged array since it is the smaller element
                j++; //iterate j to check the next value in right array
            }
            k++; //also iterate merged array at k to allow for values from left and right to be added and not override the same index
        }

        //account for any elements left in left array
        while (i < leftSize) { //if no more elements in left size array, by pass this otherwise
            array[k] = leftHalf[i]; // add the remaining elements to the merged array at k
            i++;
            k++;
        }

        //account for any elements left in right array
        while (j < rightSize) { //if no more elements in right size array, by pass this otherwise
            array[k] = rightHalf[j]; // add the remaining elements to the merged array at k
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

