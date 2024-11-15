**Problem statement:**
Given a string `text`, find the maximum number of possible instances of the word "balloon" using the characters of given text. Each character in text is used at most once.

## Examples:
Example 1:

Input: text = "lenobxlao"

Output: 1


Example 2: 

Input: text = "lollbcolatnaboon"

Output: 2


**Algorithmic Steps**
This problem is solved with the help of map(or object) data structure to store the character count. The algorithmic approach can be summarized as follows: 

1. Initialize a balloon map(`balloonMap`) to store the number of occurances of each character in "balloon" word.
    
2. Define a character occurances of given text(`text`) in `countTextMap` variable.
   
3. Iterate over characters of given text and update `countTextMap` with it's character occurances. The character count is calculated only for the characters which present in "balloon" word. 
   
4. Define a `minBalloons` variable, initialized to maximum value.

5. Iterate over characters of balloon word, calculate the possible number of balloon words based on given text.
   
6. Return `minBalloons` indicating the possible maximum number of balloon words.
   

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, Where `n` is the length of the input string (`text`). This is because we traverse the entire string once to count characters and then iterate over the fixed size(5 characters) of the `balloonMap`.

Here, it takes constant time complexity of `O(1)`. This is because the size of `balloonMap` is constant and doesn't scale with input size. Eventhough `countTextMap` grows based on number of characters in `text`, its size is capped by the distinct characters of "balloon" word.
