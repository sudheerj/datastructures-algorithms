// TC:O(32) ~ O(1) SC:O(1)
package java1.algorithms.binary.reverseBits;

public class ReverseBits {
    private static int reverseBits1(int n) {
        int reverseBits = 0;
        for(int i=0; i< 32; i++) {
            if(((n >> i) & 1) == 1) {
                reverseBits = reverseBits | (1 << (31 - i));
            }
        }
        return reverseBits;
    }

    private static int reverseBits2(int n) {
        int reverseBits = 0;
        for(int i=0; i< 32; i++) {
            reverseBits <<= 1;
            reverseBits |= (1 & n);
            n >>= 1;
        }
        return reverseBits;
    }

    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 8;
        System.out.println(reverseBits1(num1));
        System.out.println(reverseBits2(num1));

        System.out.println(reverseBits1(num2));
        System.out.println(reverseBits2(num2));
    }
}
