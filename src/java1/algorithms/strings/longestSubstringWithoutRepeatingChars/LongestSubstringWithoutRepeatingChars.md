**Algorithmic Steps**
This problem is solved with the help of sliding window approach using a HashSet. The algorithmic approach can be summarized as follows:

1. Initialize an empty HashSet to store unique characters within the current window.

2. Initialize left and right pointers to 0, to keep track of the substring window boundaries.

3. Initialize maxLength variable to 0, to store the length of the longest substring without repeating characters.

4. Iterate over the input string using right pointer until the end of the string. 

5. If a repeating character is found, remove the repeated character from the char set and move the left pointer to the right(i.e, increment left pointer) to shrink the window. This step need to be repeated until there is no repeated character in the set.

6. If the new character doesn't exist in the char set, add the character to the set and move the right pointer(i.e, increment right pointer) to expand the window.

7. Update the maxLength variable if the current window length is greater than the previous maxLength.

8. Repeat steps 4–7 until the right pointer reaches the end of the string.

9. Return the maxLength variable which indicates the longest substring length.

**Time and Space complexity:**
This algorithm has a time complexity of O(n) because we are traversing the string only once. Also, it requires space complexity of O(n) due to HashSet data structure.