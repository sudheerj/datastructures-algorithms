package findTheDuplicateNumber;

public class FindTheDuplicateNumber {
    //Floyd's cycle detection-> Treat array as linkedlist TC: O(n) SC: O(1)
    private int findDuplicate1(int[] nums) {
        //Step1: Find intersection point in cycle
        int slow= nums[0], fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) break;
        }

        slow = nums[0]; //reset to starting

        //Step2: Cycle entrance -> duplicate
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    //Binary search on value range TC: O(n) SC: O(1)
    private int findDuplicate2(int[] nums) {
        int low = 1, high = nums.length-1;

        int count = 0;
        while(low < high) {
            int mid = low + (high-low)/2;

            for(int num: nums) {
                if(num <= mid) {
                    count++;
                }
            }

           if(count > mid) {
               high = mid; // find duplicate in left part
            } else {
               low = mid+1; // find duplicate in right part
            }
        }
        return low;
    }
}
