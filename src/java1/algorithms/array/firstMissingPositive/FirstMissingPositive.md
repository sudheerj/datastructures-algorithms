**Algorithmic Steps**
This problem is solved with the help of in-place input array using its index as hash key. This is known as **in-place hashing** technique. The algorithmic approach can be summarized as follows:

1. Initialize a `length` variable to store the length of input array and `nonExistNum` to store out of bounds value.

2. Iterate over the input array and replace their values to `nonExistNum` if the value is not a positive number(i.e, `<=0 or > length`). This logic is helpful to ignore the non-positive values because the smallest positive number exists with in the range between `1` and `length` values. In the worst case, the input array may contain all numbers with in a sequence until the length of array, therefore we will consider `length+1` as the next smallest number.

3. Iterage over the input array again and find the absolute value(i.e, `index`) for each value in the array. If this value is equals to `nonExistNum`, the current iteration is going to be skipped. This absolute value presence will be indicated by negative sign at the correct index position. The correct index position is calculated by `nums[index]`. 
 
 **Note:** This negation applies only when the value is positive only.

4. You need to iterate one final time to find any positive value after the negation process(step 3). If there is any positive value at index `i`, return `i+1` as the first missing positive number.

5. when there are no positive numbers exists, return `length+1` as first missing positive number.


**Time and Space complexity:**
This algorithm has a time complexity of O(n)(i.e, `O(n) + O(n) + O(n)`) because we are traversing array thrice sequentially. Since we are using in-place input array as datastructure, the space complexity will be O(1).