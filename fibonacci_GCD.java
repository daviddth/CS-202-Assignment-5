/*David Hoang - CSC 202 - October 2, 2017 - Programming Ex. 22.6 */

public class fibonacci_GCD {

    public static void main(String[] args) {
        int max = 47; //max interation of sequence
        int[] numbers = new int[max]; //sets an array of numbers
        numbers[0] = 0; //establish first element as 0
        numbers[1] = 1; //initialize second element as 1

        for (int i = 2; i < max; i++) { //This algorithim creates the fibonacci sequence, by going through the index and making the number by the sum of the first two
            numbers[i] = numbers[i - 1] + numbers[i - 2]; //sum of the two previous numbers to create the new index number
        }

        System.out.println("              \t\t\t\t|\t\t40\t\t41\t\t42\t\t43\t\t44\t\t45"); //Prints out the table index 40-45 to be similar to the table shown in exercise.
        System.out.println("________________________________________________________________________________________");
        System.out.print("Listing 22.3 GCD            |");

        long[] executionTime = new long[6]; // declares 6 index

        for (int i = 40; i <= 45; i++) { //execution time for finding the GCD of every two consective Fibonacci numbers from index 40 to index 45
            long startTime = System.currentTimeMillis();
            gcd(numbers[i], numbers[i + 1]);
            executionTime[i - 40] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.print("\t\t" + executionTime[i]);
        }

        System.out.print("\nListing 22.4 GCDEuclid      |  ");

        for (int i = 40; i <= 45; i++) {  //code on 854
            long startTime = System.currentTimeMillis();
            GCDEuclid(numbers[i], numbers[i + 1]);
            executionTime[i - 40] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.print("\t\t" + executionTime[i]);
        }
    }

    public static int gcd(int m, int n) { //Listing 22.3 GCD.java
        int gcd = 1;

        if (m == n) return m;

        for (int k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }
            return gcd;
        }

    public static int GCDEuclid(int m, int n) { // Listing 22.4 GCDEuclid.java
        if (m % n == 0)
            return n;
        else
            return GCDEuclid(n, m % n);
    }
}