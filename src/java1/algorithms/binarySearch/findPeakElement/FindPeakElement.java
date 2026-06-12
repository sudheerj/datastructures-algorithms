package java1.algorithms.binarySearch.findPeakElement;

public class FindPeakElement {
    //Modified binary search TC: O(log n) SC: O(1)
    private int findPeakElement1(int[] nums) {
        int left = 0, right= nums.length-1;

        while(left < right) {
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[mid+1]) {
                //Peak is a mid or on left side
                right = mid;
            } else {
                //Peak is on the right side
                left = mid + 1;
            }
        }

        return left;
    }

    //Bruteforce TC: O(n) SC: O(1)
    private int findPeakElement2(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
        }

        return nums[nums.length-1];
    }
}
