package java1.algorithms.stack.dailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[currDay]) {
                int prevDay = stack.pop();
                days[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return days;
    }

    public static void main(String[] args) {
        int[] temperatures1 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures1)));

        int[] temperatures2 = {30,40,50,60,70};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures2)));
    }
    
}
