// TC:O(32) ~ O(1), SC: O(1)
package java1.algorithms.binary;

public class TwoSum {
    private static int findTwoSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 44, b = 32;
        System.out.println(findTwoSum(a, b));
    }

}
