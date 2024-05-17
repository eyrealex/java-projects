public class Main {
    public static void main(String[] args) {

        int[] array = {13, 7, 6};
        sortArray(array);

        // Print sorted array
        for (int num : array) {
            //System.out.print(num + " ");
        }
    }

    private static void sortArray(int[] array) {

        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int current = array[j];
                System.out.println(current);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }

            // array at each i index = 13, 7, 6
            // array length = 3
            // j = 0
            //



        }

    }
}