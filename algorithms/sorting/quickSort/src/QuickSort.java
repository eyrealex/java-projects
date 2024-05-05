import java.util.Random;

public class QuickSort {
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

    //method overloading is used to allow us to clean up method call above
    private static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }
    //quick sort method takes in the array of numbers, the low index which are the numbers < pivot, and high index which are the numbers > pivot
    private static void quickSort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) { //this if stops the recursion from failing the program
            return;
        }

        /*STEP 1: CHOOSE PIVOT CODE
         * Random pivot is used as it is more efficient that choosing last index in array
         * Code works same as choosing last index in array, but swap random index with last index in array*/

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex; //choose random pivot index between the lowest and highest
        int pivot = array[pivotIndex]; // use the value of the array at the pivot index
        swap(array, pivotIndex, highIndex); //swap the pivot index with the highest index in array

        /*STEP 2: PARTITIONING CODE*/

        int lowerThanPivot = partition(array, lowIndex, highIndex, pivot);

        /*STEP 3: RECURSION CODE*/

        //sort left of pivot
        quickSort(array, lowIndex, lowerThanPivot - 1); //sort left of pivot by passing in the lowest value left of pivot and the pivot - 1
        quickSort(array, lowerThanPivot + 1, highIndex); //sort right of pivot by passing the pivot + 1 and highest value left of pivot

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int lowerThanPivot = lowIndex; //create a value for index lower than pivot
        int higherThanPivot = highIndex; //create a value for index higher than pivot

        while (lowerThanPivot < higherThanPivot) { //while low index is less than high index
            while (array[lowerThanPivot] <= pivot && lowerThanPivot < higherThanPivot) { //while low index value in array is less than pivot and low index is less than high index
                lowerThanPivot++; //increment the low index to continue checking - make lower = higher to find last number to sort
            }
            while (array[higherThanPivot] >= pivot && lowerThanPivot < higherThanPivot) { //while high index value in array is greater than pivot and lower index is less than high index
                higherThanPivot--; //decrement the higher index to continue checking - make higher = lower to find last number to sort
            }

            swap(array, lowerThanPivot, higherThanPivot); //call swap method and pass in the array, lower and higher index after lower is > pivot and higher is < pivot
        }

        swap(array, lowerThanPivot, highIndex); //once lower and higher meet, swap pivot with lower
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