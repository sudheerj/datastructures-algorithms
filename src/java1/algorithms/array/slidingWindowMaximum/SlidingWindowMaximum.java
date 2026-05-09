package slidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    // Monotonic decreasing queue TC: O(n) SC: O(n-k+1)
    private static int[] slidingWindowMaximum(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>(); // Store indices
        int left = 0, right = 0;

        while (right < n) {
            // Remove elements which are smaller in deque
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }

            // Add the next valid element into deque
            q.addLast(right);

            // when left is outside the window
            if (left > q.getFirst()) {
                q.removeFirst();
            }

            // Start adding elements for valid windows
            if (right + 1 >= k) {
                output[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3))); // [3,3,5,5,6,7]
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 1 }, 1))); // [1]
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 1, -1 }, 1))); // [1,-1]
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 9, 11 }, 2))); // [11]
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 4, -2 }, 2))); // [4]
        System.out.println(java.util.Arrays.toString(slidingWindowMaximum(new int[] { 1, 3, 1, 2, 0, 5 }, 3))); // [3,3,2,5]
    }
}
