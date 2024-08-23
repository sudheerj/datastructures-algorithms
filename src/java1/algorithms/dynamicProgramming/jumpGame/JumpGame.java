package java1.algorithms.dynamicProgramming.jumpGame;

public class JumpGame {

    //Greedy:- TC:O(n) SC:O(1)
    private static boolean canJump1(int[] nums) {
        int goalPost = nums.length-1;

        for(int i= nums.length-1; i>=0; i--) {
            int jumpDistance = i + nums[i];
            if(jumpDistance >= goalPost) {
                goalPost = i;
            }
        }
        return goalPost == 0;
    }

    //DP:- TC:O(n*2) SC:O(n)
    private static boolean canJump2(int[] nums) {
        int length = nums.length;
        if(length == 1) return true;
        if(nums[0] == 0) return false;

        boolean[] dp = new boolean[length];
        dp[0] = true;

        for(int i=1; i<length; i++){
            for(int j=0; j<i; j++) {
                if(dp[j] && j+ nums[j] >=i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump1(nums1));
        System.out.println(canJump1(nums2));
        System.out.println(canJump2(nums1));
        System.out.println(canJump2(nums2));
    }
    
}
