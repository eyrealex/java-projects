//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = random.nextInt(10000);
        }

        System.out.println("\n10 Random numbers to be sorted \n" + Arrays.toString(numbers));
        selctionSort(numbers);
        System.out.println("\n10 Random numbers have been sorted \n" + Arrays.toString(numbers));
    }

    private static void selctionSort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length - 1; ++i) {
            int minNum = numbers[i];
            int indexOfNum = i;

            for (int j = i + 1; j < length; ++j) {
                if (numbers[j] < minNum) {
                    minNum = numbers[j];
                    indexOfNum = j;
                }
            }

            swap(numbers, i, indexOfNum);
        }

    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
