package java1.algorithms.binary.numberOf1Bits;

public class NumberOf1Bits {
    //Optimistic solution without scanning zeros(Brian Kernighan’s Algorithm)  TC:O(k) -> O(1) SC:O(1). K is number of 1 bits.
    private static int hammingWeight1(int num) {
        int count = 0;
        while(num != 0) {
            num &= (num-1);
            count++;
        }
        return count;
    }

    //TC: O(32)-> O(1), SC: O(1)
    private static int hammingWeight2(int num) {
        int count = 0;
        while(num != 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }

    
    //TC: O(32)-> O(1), SC: O(1)
    private static int hammingWeight3(int num) {
        int count = 0;
        while(num != 0) {
            count += num % 2;
            num = num >> 1;
        }
        return count;
    }

    //TC: O(32)-> O(1), SC: O(1)
    private static int hammingWeight4(int num) {
        int count = 0;
        int mask = 1;
        for(int i=0; i< 32; i++) {
            if((num & mask) !=0) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num1 = 12; // 00000000000000000000000000001100
        int num2 = 128; // 00000000000000000000000010000000
        System.out.println(hammingWeight1(num1));
        System.out.println(hammingWeight2(num1));
        System.out.println(hammingWeight3(num1));
        System.out.println(hammingWeight4(num1));

        System.out.println(hammingWeight1(num2));
        System.out.println(hammingWeight2(num2));
        System.out.println(hammingWeight3(num2));
        System.out.println(hammingWeight4(num2));
    }
}
