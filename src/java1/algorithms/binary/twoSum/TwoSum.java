// TC:O(32) ~ O(1), SC: O(1)
package java1.algorithms.binary.twoSum;

public class TwoSum {
    private static int findTwoSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 44, b = 32;
        int a1 = 3, b1 = 2;
        System.out.println(findTwoSum(a, b));
        System.out.println(findTwoSum(a1, b1));
    }

}
