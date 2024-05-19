public class BinarySearch {
    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 6, 9, 13, 15};
        //System.out.print("The index value of the number 6 is: ");
        System.out.println(binarySearch(nums, 9));

    }

    private static int binarySearch(int[] numbers, int numToFind) {
        int low = 0; //start at the first position in the array
        int high = numbers.length - 1; // start at the last position in the array by index

        while (low <= high) { //continue looping while low is less or equal to high
            int middlePosition = (low + high) / 2; //this is index of middle position, value 6 has the index of 3
            int middleNum = numbers[middlePosition]; // set middle num to the value of the middle position index

            if (numToFind == middleNum) { //if num to find argument is the same as the middle num exit early
                return middlePosition;
            }
            if (numToFind < middleNum) { //if num to find is less than this middle num
                high = middlePosition - 1; // move value of high to left of middle position. We do this because we now disregard all other elements at >= middle position ( high will be set to index 2 if we are looking for value at index 3 )
            } else {
                low = middlePosition + 1; // move value of low to right of middle position. We do this because we now disregard all other elements at <= middle position ( low will be set to index 4 if we are looking for value at index 9 )
            }
        }
        return      -1;
    }
}