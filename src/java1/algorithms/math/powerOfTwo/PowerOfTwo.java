package java1.algorithms.math.powerOfTwo;

public class PowerOfTwo {
    //Approach1: Division TC: O(log n) (base 2) SC: O(1)
    private boolean isPowerOfTwo1(int n) {
        if(n<=0) return false;

        while(n%2 == 0) {
            n /=2;
        }

        return n ==1;
    }
    //Aproach2: Bit trick, power of 2 has exactly one bit set TC:O(1) SC: O(1)
    private boolean isPowerOfTwo2(int n) {
        if(n<=0) return false;

        return n > 0 && n * (n-1) == 0;
    }
}
