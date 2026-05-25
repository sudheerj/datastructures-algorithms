package subarrayWithKDiffIntegers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarrayWithKDiffIntegers {

    // Brute force with HashSet TC: O(n^2) SC: O(n)
    private static int subarrayWithKDiffIntegers1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> countSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                countSet.add(nums[j]);

                if (countSet.size() > k) {
                    break;
                }

                if (countSet.size() == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Sliding window: exactlyK = atMostK - atMostK(k-1)  TC: O(n) SC: O(k)
    private static int subarrayWithKDiffIntegers2(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private static int atMostK(int[] nums, int k) {
        int left = 0, count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] numsArr = {
            {1, 2, 1, 2, 3},
            {1, 2, 1, 3, 4},
            {1, 1, 1, 1, 1},
            {1, 2, 3},
            {1, 2, 3, 4, 5}
        };
        int[] ks        = {2, 3, 1, 1, 2};
        int[] expected  = {7, 3, 15, 3, 4};

        for (int t = 0; t < expected.length; t++) {
            int[] nums = numsArr[t];
            int k      = ks[t];
            int exp    = expected[t];

            for (int approach = 1; approach <= 2; approach++) {
                int result = switch (approach) {
                    case 1 -> subarrayWithKDiffIntegers1(nums, k);
                    case 2 -> subarrayWithKDiffIntegers2(nums, k);
                    default -> -1;
                };
                String status = result == exp ? "PASS" : "FAIL";
                System.out.printf("[%s] approach=%d nums=%s k=%d result=%d expected=%d%n",
                    status, approach, Arrays.toString(nums), k, result, exp);
            }
        }
    }
}
