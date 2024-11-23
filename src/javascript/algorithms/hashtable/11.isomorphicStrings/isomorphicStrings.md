**Problem statement:**
Given two strings `s` and `t`, determine if they are isomorphic or not.

**Note:** Two strings can be called as isomorphic if the characters in one word can be replaced to get another word. You need to make sure that all occurrences of a character must be replaced with another character while preserving the order of characters. Also, no two unique characters map to the same character, but a character map to itself.

## Examples:
Example 1:

Input: s = "dad", t="mom"

Output: true


Example 2: 

Input: s = "zoo", t="cat"

Output: false


**Algorithmic Steps**
This problem is solved with the help of maps to verify one-to-one mapping between every character of the first string to the second string. 

1. Add a base case check by returning false when two strings lengths are not equal.
    
2. Define two hash maps(i.e, `sMap`, `tMap`) to track mappings between two strings.
   
3. Iterate over characters of given string(either string `s` or `t`).
   1. If the current character of first string already exists in `sMap`, and if the current character in the first string has been mapped to a conflict character in the second string, return `false`indicating that given strings are not isomorphic. Otherwise(when there is no conflict mapping), add the character mapping in `sMap`. 
   
   2. If the current character of second string already exists in `tMap`, and if the current character in the second string has been mapped to a conflict character in the first string, return `false`indicating that given strings are not isomorphic. Otherwise(when there is no conflict mapping), add the character mapping in `tMap`. 
   
4. If the above iteration is complete without any conflicts, those two strings are considered as isomorphic. i.e, Return `true` indicating the given strings as isomorphic strings.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, Where `n` is the length of the input strings. This is because we traverse the string once and perform constant time operations for hash map lookups and insertions.

Here, it takes time complexity of `O(n)`. This is because of the space required by two hash maps(i.e, `sMap`,`tMap`).
