package java1.algorithms.array;

public class NumberOfDigitOne {
    
    public static int numberOfDigitOne(int A) {
        if (A == 0) {
            return 0;
        }

        int base = 1;
        int sum = 0;

        while (base <= A) {
            int left = A / base / 10;
            int cur = A / base % 10;
            int right = A % base;

            if (cur > 1) {
                sum += (left + 1) * base;
            } else if (cur == 1) {
                sum += left * base + right + 1;
            } else {
                sum += left * base;
            }

            base *= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int number = 123;
        System.out.println(numberOfDigitOne(number)); // Example output: 57
    }

}

// Time Complexity - O(log10(A))
// Space Complexity - O(1)