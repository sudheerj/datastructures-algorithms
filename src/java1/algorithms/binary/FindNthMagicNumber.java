package java1.algorithms.binary;

public class FindNthMagicNumber {
     // Method to find the nth magic number
     public static int findNthMagicNumber(int n) {
        int power = 1;
        int magicNumber = 0;

        while (n != 0) {
            power *= 5; // Increase the power of 5

            if ((n & 1) == 1) { // Check if the least significant bit of n is 1
                magicNumber += power; // Add the current power of 5 to the magic number
            }

            n >>= 1; // Right shift n by 1 bit to process the next bit
        }

        return magicNumber;
    }

    public static void main(String[] args) {
        int n = 3;
        int nthMagicNumber = findNthMagicNumber(n);
        System.out.println("The " + n + "rd magic number is: " + nthMagicNumber);
    }
}
