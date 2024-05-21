import java.util.Random;

public class QuickSort {

    /*
        QUICK SORT solution
            We have an array = {1, 8, 3, 9, 4, 5, 7}
            Choose one number by random in the array as the pivot
            Swap this pivot with last number in array

            Partition Steps
            Move all numbers less than pivot to left of pivot but unordered
            Move all numbers greater than pivot to right of pivot but unordered
            Pivot is now in correct position in array

            Recursively quicksort all values left of pivot until all values on the left are in order
            Recursively quicksort all values right of pivot until all values on the right are in order
            This is done by repeating the above, choosing a pivot and partitioning

    */

    public static void main(String[] args) {

        Random random = new Random();
        int[] numbers = new int[10000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        System.out.print("\nBefore: ");
        //printArray(numbers);

        //method overloading is used below avoid having so many arguments in this method call for cleaner code readability
        quickSort(numbers);

        System.out.print("\nAfter: ");
        //printArray(numbers);

    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //quick sort method takes in the array of numbers, the low index which are the numbers < pivot, and high index which are the numbers > pivot
    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) { //baseline to break recursion if condition is met
            return;
        }

        /*STEP 1: CHOOSE PIVOT CODE
         * Random pivot is used as it is more efficient that choosing last index in array
         * Code works same as choosing last index in array, but swap random index with last index in array*/

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex; //set pivot index as random value between low & high
        int pivot = array[pivotIndex]; // set pivot to the value of the array where pivot index is found
        swap(array, pivotIndex, highIndex); //swap index of pivot with index of high

        /*STEP 2: PARTITIONING CODE*/

        int partition = partitionPivot(array, lowIndex, highIndex, pivot);

        /*STEP 3: RECURSION CODE*/

        //sort left of pivot
        quickSort(array, lowIndex, partition - 1); //sort left of pivot by passing in the lowest value left of pivot and the pivot - 1
        quickSort(array, partition + 1, highIndex); //sort right of pivot by passing the pivot + 1 and highest value left of pivot

    }

    private static int partitionPivot(int[] array, int lowIndex, int highIndex, int pivot) {
        int lowerThanPivot = lowIndex; //create a value for index lower than pivot
        int higherThanPivot = highIndex; //create a value for index higher than pivot

        while (lowerThanPivot < higherThanPivot) { //while low index is less than high index
            while (array[lowerThanPivot] <= pivot && lowerThanPivot < higherThanPivot) { //walk from left until we find a number greater than pivot or until lower pointer is greater than higher pointer
                lowerThanPivot++; //increment the lower pointer until value at this array is greater than pivot or pass right pointer
            }
            while (array[higherThanPivot] >= pivot && lowerThanPivot < higherThanPivot) { //walk from right until we find a number less than pivot or until higher pointer is less than lower pointer
                higherThanPivot--; //decrement the higher pointer until value at this array is less than pivot or pass left pointer
            }

            swap(array, lowerThanPivot, higherThanPivot); // when lower and higher pointers meet we swap lower pointer with higher pointer
        }

        swap(array, lowerThanPivot, highIndex); // then we can swap the pivot with lower pointer to put the highest number at end of array
        return lowerThanPivot;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {

        for (int i = 0; i <= numbers.length - 1; i++) {
            System.out.print(" " + numbers[i]);
        }
    }


}