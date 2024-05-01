import java.util.HashMap;
import java.util.Map;

// Define a class named Solution
class Solution {

    // Main method, entry point of the program
    public static void main(String[] args) {
        // Initialize an array of integers
        int[] nums = {4, 5, 3, 9};
        // Define the target integer
        int target = 12;

        // Call the twoSum method with the array and target
        twoSum(nums, target);
    }

    // Define a method to find the indices of two numbers that add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store complements (needed numbers to reach the target sum)
        Map<Integer, Integer> complements = new HashMap<>();

        // Iterate over the elements of the nums array
        for (int i = 0; i < nums.length; i++) {
            // Retrieve the index of the complement of the current element from the complements map
            Integer complementIndex = complements.get(nums[i]);

            // If the complement index is not null, a complement has been found previously
            if (complementIndex != null) {
                // Return the indices of the current element and its complement
                System.out.println("this is the index at i : " + i + " followed by index of num to add to i to get target " + complementIndex);
                return new int[]{i, complementIndex};
            }

            // Calculate the complement needed to reach the target sum and store it in the complements map
            complements.put(target - nums[i], i);
        }

        // If no solution is found within the loop, return null or an appropriate error value
        // However, the current implementation incorrectly returns the original nums array
        return null;
    }
}
