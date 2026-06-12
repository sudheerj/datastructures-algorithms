package java1.algorithms.math.powerOfThree;

public class PowerOfThree {
    //Division approach TC: O(log n)(base 3) SC: O(1)
    private boolean isPowerOfThree1(int n) {
        if(n <= 0) return false;

        while(n%3 ==0) {
            n /= 3;
        }

        return n == 1;
    }
    //If the number divides 3^19(max value fit in 32-bit integer) completely, its is a power of three TC: O(1) SC: O(1)
    private boolean isPowerOfThree2(int n) {
        if(n <= 0) return false;

        return n > 0 && ((int)Math.pow(3, 19))%n == 0;
    }
}
