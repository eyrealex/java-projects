public class BinarySearch {
    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 6, 9, 13, 15};
        System.out.println(binarySearch(nums, 6));

    }

    private static int binarySearch(int[] numbers, int numToFind) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2; //get the middle of the array
            int middleNum = numbers[middlePosition]; //value of numbers array at middle position

            if (numToFind == middleNum) {
                return middlePosition;
            }
            if (numToFind < middleNum) {
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1;
    }
}