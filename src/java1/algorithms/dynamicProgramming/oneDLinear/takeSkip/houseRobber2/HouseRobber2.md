**Description:**
Given an integer array `nums` where `nums[i]` represents the amount of money in the `i`th house. Calculate the maximum amount of money you can rob from the houses which are arranged in a circle. Remember that you cannot rob two adjacent houses(including the first and last house) because the security system will automatically alert the police if two adjacent houses were broken into on the same night.

## Examples:
Example 1:

Input: nums1 = [1,5,7,2,4]
Output: 11

Example 2: 

Input: nums2 = [1, 2, 3]
Output: 3

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **Fibonacci pattern bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Accepts `nums` as input array which indicates the amount of money of each house.
   
2. Add base case conditions for zero and one houses. If there are no houses(`nums.length === 0`), the maximum money can get is zero. In case there is only one house(`nums.length === 1`), return that money as maximum amount.
   
3. Since the houses are arranged in a circle, the maximum money stolen from houses needs to be calculated for two sub-arrays(i.e, first subarray from first to last before house and second subarray from second to last house)
   
4. Create a helper function which accepts subarray as input to calculate the maximum amount can be robbed.

5. Start the helper function by initializing first(`rob1`) and second(`rob2`) houses money with zero.
   
6. Iterate over all the houses and get the money at each `i`th house.

7. Find the maximum possible money which can be robbed at each house. This is calculated by taking the maximum between sum of current house with second previous house and previous house money. This maximum money can be stored in a temporary varaible(`newRob`).
   
8. Move `rob1` pointing to next house(`rob2`). i.e, `rob1 = rob2`.
      
9. Update `rob2` pointing to current house(`newRob`) where the maximum possible money which can robbed at night is stored.

10.  Repeat steps 3-5 until all the houses visited.

11. Return `rob2` which contains the maximum possible money which you can rob in the sequence of houses

12. Return the maximum money by invoking the helper function for subarrays mentioned in step3.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`(i.e, `O(2n) ~ O(n)`), where `n` is the number of houses with money stashed. This is because we need to traverse over two subarray sequence of houses to find the maximum money. 

Here, we are not using any additonal datastructure other than two variables to store money. Hence, the space complexity will be `O(1)`.
