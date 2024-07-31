**Description:**
Given an unsorted set of numbers from `1` to `N` with exactly two of them missing, find those two missing numbers.

### Examples
Example 1:

Input: prices = [3, 2, 5, 1, 6, 8]
Output: [4,7]

Example 2:

Input: prices = [3, 2, 5, 1, 6, 4]
Output: [7,8]

**Algorithmic Steps**
This problem is solved with the help of sequential numbers sum and average calculations. The algorithmic approach can be summarized as follows:

1. Initialize missing two numbers array(i.e, `missingTwoNums`) to an empty array.

2. Store the length of input array along with missing numbers into `len` variable(i.e, `len = nums.length+2`).

3. Calculate the sum of all sequential numbers into `sum` variable.

    **Note:** Sum of `n` sequential number sum is `(n *(n+1))/2`.

4. Calculate the sum of given input array into `numsSum` by iterating over the array.

5. The sum of missing two numbers(`missingTwoNumsSum`) is calculated by the difference between sum calculated in step 3 & 4.

6. Find the average of missing two numbers sum into `missingTwoNumsAvg`.

7. Calculate the sequential numbers sum until missing numbers average value and store it in `sumUntilAvg`.

8. Also, calculate the sum of numbers until `missingTwoNumsAvg` into `numsSumUntilAvg` by iterating over the input array.

9. The difference between sums in step7 & 8 gives the first missing number. This number can be pushed to `missingTwoNums` array.

10. The second number is calculated by deducting first number from missing numbers sum. This number also stored into `missingTwoNums` array.

11. Return `missingTwoNums` array which stores two missing numbers.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`(`O(n) + O(n)`), where `n` is the number of stock prices. This is because we are traversing the array two times.
 
Here, we don't use any additional datastructure other than missing numbers array of size 2. Hence, the space complexity will be `O(1)`.