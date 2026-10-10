**Description:**
You are required to climb a staircase that consists of `n` individual steps. Determine the total number of distinct ways to reach the top of the staircase.

**Note:** Each time you can either climb 1 or 2 steps.

## Examples:
Example 1:

Input: n = 5
Output: 8

Example 2: 

Input: n = 6
Output: 13

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Add a preliminary check like if the step value is less than or equal to 2, return the possible ways to reach them as step's value.

2. Create two variables(`first` and `second`) to store the possible ways to reach the current step and the next step. Since the first step takes one possible way and second step takes two possible ways, those varaibles needs to be  initialized to 1 & 2 respectively.

3. Iterate `n-1` times to calculate the next step until `n`th step is reached.

4. The number of possible ways to reach next step is the combination of previous two steps possibilities. Because any particular step is reached either through 1 step or 2 steps.

5. Calculate the sum of first and second pointers in a temporary variable(`temp`). Assign the second pointer variable to first and update the second pointer variable to temporary variable.

6. Repeat steps 4-5 until the nth step is reached.

7. Return second pointer value which indicates the possible ways to reach top stair.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of steps. This is because we are traversing all the steps to calculate the possible ways for nth step. 

Here, we don't use any additional datastructure other than two variables. Hence, the space complexity will be `O(1)`.
