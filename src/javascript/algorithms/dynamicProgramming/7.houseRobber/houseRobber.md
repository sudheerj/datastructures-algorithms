**Description:**
Given an integer array `nums` where `nums[i]` represents the amount of money in the `ith` house. Calculate the maximum amount of money you can rob from the houses. Remember that you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were broken into on the same night.

## Examples:
Example 1:

Input: nums1 = [1,5,7,2,4]
Output: 12

Example 2: 

Input: nums2 = [8, 1, 2, 9]
Output: 17

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **Fibonacci pattern bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Initialize first(`rob1`) and second(`rob2`) houses money with zero.
   
2. Iterate over all the houses and get the money at each `i`th house.

3. Find the maximum possible money which can be robbed at each house. This is calculated by taking the maximum between sum of current house with second previous house and previous house money. This maximum money can be stored in a temporary varaible(`newRob`).
   
4. Move `rob1` pointing to next house(`rob2`). i.e, `rob1 = rob2`.
      
5. Update `rob2` pointing to current house(`newRob`) where the maximum possible money which can robbed at night is stored.

6. Repeat steps 3-5 until all the houses visited.

7. Return `rob2` which contains the maximum possible money which you can rob in the sequence of houses


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of houses with money stashed. This is because we need to traverse over each house to find the maximum money. 

Here, we are not using any additonal datastructure other than two variables to store money. Hence, the space complexity will be `O(1)`.
