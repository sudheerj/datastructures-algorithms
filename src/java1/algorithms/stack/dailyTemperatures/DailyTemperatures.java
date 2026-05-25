package java1.algorithms.stack.dailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

//Monotonic decreasing stack: TC:O(n) SC:O(n)
public class DailyTemperatures {

    private static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        //Store pair of temp and index of temperature array
        Stack<int[]> stack = new Stack<>();

        for(int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.empty() &&  currTemp > stack.peek()[0]) {
                int[] pair = stack.pop();
                days[pair[1]] = currDay - pair[1];
            }
            stack.push(new int[]{currTemp, currDay});
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
