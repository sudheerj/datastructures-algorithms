package sortTheJumbledNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTheJumbledNumbers {
    //Maintain {mappedNum, orginalNum}array, sort it and extract original nums. TC: O(n * d + n log n) SC: O(n)
    private int[] sortJumbled(int[] mapping, int[] nums) {
        int n= nums.length;
        int[][] arr =new int[n][2];

        for(int i=0; i<n; i++) {
            arr[i][0] = numberMapped(nums[i], mapping);
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> a[0]-b[0]);

        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = arr[i][1];
        }

        return result;
    }

    private int numberMapped(int num, int[] mapping){
        if(num == 0) return mapping[0];

        List<Integer> digits = new ArrayList<>();
        int result = 0;
        while(num>0) {
            digits.add(num%10);
            num /= 10;
        }

        for(int i=digits.size()-1; i>=0; i--) {
            result = result * 10 + mapping[digits.get(i)];
        }

        return result;
    }
}
