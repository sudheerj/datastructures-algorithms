package java1.algorithms.binary;

public class ToggleIthBit {
    // Method to toggle the B-th bit of an integer A
    public static int toggleIthBit(int A, int B) {
        // Toggle the B-th bit of A directly
        A = A ^ (1 << B);
        return A;
    }

    public static void main(String[] args) {
        int A = 5; // Binary: 101
        int B = 1; // Toggle the 1st bit
        int result = toggleIthBit(A, B);
        System.out.println("The result after toggling the " + B + "th bit of " + A + " is: " + result);
    }
}
