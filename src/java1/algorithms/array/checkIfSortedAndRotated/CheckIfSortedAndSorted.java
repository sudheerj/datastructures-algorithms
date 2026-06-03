
public class CheckIfSortedAndSorted {
    private boolean check(int[] nums) {
        int n = nums.length;
        int drops = 0;

        for(int i=0; i<nums.length; i++) {
            //compare current with next circularly
            if(nums[i] > nums[(i+1)%n]) {
                drops++;
            }

            //more than one drop is invalid
            if(drops > 1) {
                return false;
            }
        }

        return true;
    }
}