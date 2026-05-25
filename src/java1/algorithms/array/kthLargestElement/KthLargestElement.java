package kthLargestElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    // Sorting TC: O(n log n) SC: O(1)/O(n) depends on sorting type
    private static int kthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // MinHeap TC: O(n log k) SC: O(k)
    private static int kthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    // MaxHeap(Not optimized) TC: O(n log n) SC: O(n)
    private static int kthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.peek();
    }

    // Quick select TC: O(n) avg SC: O(n) recursion stack
    private static int kthLargest4(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        return quickSelect(nums, 0, n - 1, target);
    }

    private static int quickSelect(int[] nums, int left, int right, int target) {
        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == target) {
            return nums[pivotIndex];
        }
        if (pivotIndex < target) { // look right side
            return quickSelect(nums, pivotIndex + 1, right, target);
        }
        return quickSelect(nums, left, pivotIndex - 1, target); //look for left side
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                { 3, 2, 1, 5, 6, 4 },
                { 3, 2, 3, 1, 2, 4, 5, 5, 6 },
                { 1 },
                { 7, 6, 5, 4, 3, 2, 1 },
                { 1, 2, 3, 4, 5 }
        };
        int[] ks = { 2, 4, 1, 3, 1 };
        int[] expected = { 5, 4, 1, 5, 5 };

        System.out.println("--- kthLargest1 (Sorting) ---");
        for (int i = 0; i < inputs.length; i++) {
            int r = kthLargest1(inputs[i].clone(), ks[i]);
            System.out.println((r == expected[i] ? "[PASS]" : "[FAIL]") + " result=" + r + " expected=" + expected[i]);
        }

        System.out.println("--- kthLargest2 (MinHeap) ---");
        for (int i = 0; i < inputs.length; i++) {
            int r = kthLargest2(inputs[i].clone(), ks[i]);
            System.out.println((r == expected[i] ? "[PASS]" : "[FAIL]") + " result=" + r + " expected=" + expected[i]);
        }

        System.out.println("--- kthLargest3 (MaxHeap) ---");
        for (int i = 0; i < inputs.length; i++) {
            int r = kthLargest3(inputs[i].clone(), ks[i]);
            System.out.println((r == expected[i] ? "[PASS]" : "[FAIL]") + " result=" + r + " expected=" + expected[i]);
        }

        System.out.println("--- kthLargest4 (QuickSelect) ---");
        for (int i = 0; i < inputs.length; i++) {
            int r = kthLargest4(inputs[i].clone(), ks[i]);
            System.out.println((r == expected[i] ? "[PASS]" : "[FAIL]") + " result=" + r + " expected=" + expected[i]);
        }
    }
}
