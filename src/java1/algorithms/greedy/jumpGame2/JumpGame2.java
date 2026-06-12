package java1.algorithms.greedy.jumpGame2;

public class JumpGame2 {
    //BFS style range expansion(greedy) TC: O(n) SC: O(1)
    private int jump(int[] nums) {
        int jumps = 0;
        int currentWindowStart = 0, currentWindowEnd = 0;

        while(currentWindowEnd < nums.length-1) {
            int farthestReach = 0;
            for(int i=currentWindowStart; i<=currentWindowEnd; i++) {
                farthestReach = Math.max(farthestReach, i+nums[i]);
            }

            currentWindowStart = currentWindowEnd + 1;
            currentWindowEnd = farthestReach;
            jumps++;
        }

        return jumps;
    }
}
