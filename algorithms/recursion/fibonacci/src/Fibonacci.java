public class Fibonacci {

    private static long[] fibonacciCache;

    public static void main(String[] args) {

        int n = 6; // n represents the indexed number: n = the 14th position in the fibonacci series

        // create a variable used to store the solution of a fibonacci to help with memoization, speeds up the fibonacci calculation
        fibonacciCache = new long[n + 1]; //we use n + 1 because the index we want takes n + 1 to reach

        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + ", ");
        }

    }

    private static long fibonacci(int n) {

        if (n <= 1) { //create a base case to avoid recursion out of bounds. (0 , 1 are the base case since they never change in fibonacci)
            return n;
        }

        //fibonacci list: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
        //index 6 returns value 8
        //to find a value in fibonacci you add the two numbers together that come before the index you want.
        //in this case take index at n and - 1, we add this to the index at n - 2

        // look up the nth value in cache to see if number exists. Make sure it is not equal to 0, cannot use null because primitive numbers don't like null
        // if not 0 it is stored in cache and we should use it
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        //setting the calculation of fibonacci to a variable
        long fibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2);

        //save the fibonacci variable to the cache at the index of n when the solution is found.
        fibonacciCache[n] = fibonacciNumber;

        return fibonacciNumber; //return the fibonacci number
    }
}