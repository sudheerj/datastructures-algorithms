package java1.algorithms.math.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    //Modular arithmetic TC: O(n) SC: O(n)
    private static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            if(i%3 ==0 && i%5 == 0) {
                result.add("FizzBuzz");
            } else if(i%3 == 0) {
                result.add("Fizz");
            } else if(i%5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] tests = {1, 3, 5, 10, 15, 20};

        for (int n : tests) {
            System.out.println("n = " + n);
            System.out.println(fizzBuzz(n));
            System.out.println("----------------------");
        }
    }
}
