**Description:**
 Given an array of coins(`coins`) that contains different coin denominations and an integer amount(`amount`) which represents the total amount of money you want to make with these coins. Calculate the minimum number of coins needed to make up the given amount. If it is not possible to made up the amount, return -1.

**Note:** There is no limit on number of times each coin to be used.

## Examples:
Example 1:

Input: coins = [1, 3, 4, 5], amount = 7
Output: 2

Example 2: 

Input: coins = [2, 4], amount = 3
Output: -1

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Initialize an array to hold the number of minimum coins for each amount value from `0` to given `amount`. By default, each value is assigned with out of bound value `amount+1`.
   
2. Since the amount `0` requires `0` coins, let's re-initialize the first value(`dp[0]=0`) with 0.
   
3. Iterate each amount value starting from `1` to `amount` to find the minimum coins required.

4. Iterate over each coin to make up the amount value.

5. If the difference between amount and coin value is greater than or equal to zero, the number of minimum coins is calculated by the minimum value of initial value(`dp[i]`) and remaining amount's coins incremented by 1(`1+dp[i-coin]`).
   
6. Repeat step 5 until all the icons verified.

7. Repeat steps 4-5 until the number of minimum coins calculated for each amount value.

8. Return `dp[amount]` which indicates the number of minimum coins required for give amount.


**Time and Space complexity:**
This algorithm has a time complexity of `O(amount * coins)`, where `amount` is the number of amount values from `1` to given input `amount` and `coins` indicates number of given coins. This is because we are traversing all the amount values with a list of coins. 

Here, we will use array datastructure to store the minimum coins count for each amount value. Hence, the space complexity will be `O(amount)`.
