**Description:**
Given an array of unique integers `nums` and a target integer `target`, find out the number of possible combinations that add up to given target.

**Note:** Same element from `nums` can be used multiple times if required. Also, the different elements order considered as a different combination.

## Examples:
Example 1:

Input: nums1 = [1, 2, 4], target1 = 5
Output: 10

Example 2: 

Input: nums2 = [7], target2 = 6
Output: 0

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Create an array(`dp`) with the size of `length+1` and initialized all values to zero. This array is used to store the number of combinations that sum up to each value from `0` up to `target`.
   
2. The first value(`dp[0]=1`) is set to 1 since there will be only one possible combination(not using any elements) results in a sum of zero.
   
3. Iterate over all possible sub-targets(`i`) starting from `1` to `target` to find the combinations.
      
4. For each sub-target value `i`, iterate through all numbers of given array.

5. If the number(`num`) is less than or equal to current sub-target(`i`), then update the possible combinations by adding the previous combinations.

6. Repeat steps 4-5 until the target value is reached.

7. Return the number of combinations from the last element of an array(i.e, `dp[target]`)


**Time and Space complexity:**
This algorithm has a time complexity of `O(target * n)`, where `n` is the number of elements in `nums` and `target` is the number for which combinations needs to be calculated. This is because we need to traverse each sub-target and find the possible comnitions for each element of given array. 

Here, we will use an array datastructure to store possible combinations for each sub-target. Hence, the space complexity will be `O(target)`.
