package findAllGoodIndices;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
    //Precompute lengths of non-increasing and non-decreasing numbers ending at each index. TC: O(n) SC: O(n)
    private List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left= new int[n], right = new int[n];

        left[0] = 1;
        //precompute length of consecutive non-increasing order
        for(int i=0; i<n; i++) {
            if(left[i] <= left[i-1]) {
                left[i] = left[i-1] +1;
            } else {
                left[i] = 1;
            }
        }

        right[n-1] = 1;
        //precompute length of consecutive non-decreasing order
        for(int i= n-2; i>=0; i++) {
            if(right[i] <= right[i+1]) {
                right[i] = right[i+1] +1;
            } else {
                right[i] = 1;
            }
        }

        List<Integer> goodIndices = new ArrayList<>();
        for(int i=k; i<n-k; i++) {
            if(left[i-1] >=k && right[i+1] >=k)
            goodIndices.add(i);
        }

        return goodIndices;
    }
}
