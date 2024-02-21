// TC:O(1) SC:O(1)
package java1.algorithms.binary;

public class NumberOf1Bits {
    //Optimistic solution without scanning zeros
    private static int hammingWeight(int num) {
        int count = 0;
        while(num != 0) {
            num &= (num-1);
            count++;
        }
        return count;
    }

    private static int hammingWeight1(int num) {
        int count = 0;
        while(num != 0) {
            count += num % 2;
            num = num >> 1;
        }
        return count;
    }

    private static int hammingWeight2(int num) {
        int count = 0;
        int mask = 1;
        while(num != 0){
            for(int i=0; i< 32; i++) {
                if((num & mask) !=0) {
                    count++;
                }
                num = num >> 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 11; // 00000000000000000000000000001011
        System.out.println(hammingWeight(num));
        System.out.println(hammingWeight1(num));
        System.out.println(hammingWeight2(num));
    }
}
