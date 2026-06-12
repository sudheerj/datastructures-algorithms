package findOriginalArrayFromDoubledArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {
    //Sorting + Frequency counting + greedy TC: O(n) SC: O(n)
    private int[] findOriginalArray(int[] changed){
        if(changed.length %2 != 0) {
            return new int[0];
        }

        //Sort to process smallest values first
        Arrays.sort(changed);

        //{num, count}
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: changed) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        int[] original = new int[changed.length/2];
        int index = 0;
        for(int num: changed) {
            //skp if its already used
            if(freqMap.get(num) == 0) {
                continue;
            }

            if(freqMap.getOrDefault(num * 2, 0) == 0) {
                return new int[0];
            }

            original[index++] = num;

            freqMap.put(num, freqMap.get(num)-1);
            freqMap.put(num*2, freqMap.get(num*2)-1);
        }

        return original;
    }
}
