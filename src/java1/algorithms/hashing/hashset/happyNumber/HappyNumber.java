package java1.algorithms.hashing.hashset.happyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    //Cyclic detection TC: O(log n)(iteration based on number of digits) SC: O(1)
    private static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        //Iterate until its value reached 1 or detected cycle
        while(n != 1 && !seen.contains(n)) {
            seen.add(n);

            int sum = 0;

            while(n > 0) {
                int digit = n%10;
                sum += digit * digit;
                n = n/10;
            }

            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2));  // false
        System.out.println(isHappy(7));  // true
        System.out.println(isHappy(20)); // false
        System.out.println(isHappy(1));  // true
    }
}
