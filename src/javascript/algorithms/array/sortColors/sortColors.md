**Algorithmic Steps**
This problem is solved with the help of two pointers technique. It is also know as "Dutch National Flag problem". The algorithmic approach can be summarized as follows:


1. Initialize left and right pointers to first(i.e, 0) and end index of the array, to keep track of the current window boundaries.

3. Initialize current index pointer(i.e, i) to 0, to keep track of the current character while iterating the array.

4. Iterate over the input array using index pointer until the end of the array. 

5. If the current character is equals to 0, swap the character values at left pointer and index pointer. Also, increment the left pointer and index pointer.

6. If the current character is equals to 2, swap the character values at right pointer and index pointer. Also, decrement the right pointer. If the chracter is neither 0 or 2, then just increment the index pointer.

8. Repeat steps 5–6 until the index pointer reaches the end of the array.

9. Return the updated in-place array where chracters are sorted.

**Time and Space complexity:**
This algorithm has a time complexity of O(n) because we are traversing the array only once. Also, it takes requires space complexity of O(1) because we are updating the array in-place without using an additional array.