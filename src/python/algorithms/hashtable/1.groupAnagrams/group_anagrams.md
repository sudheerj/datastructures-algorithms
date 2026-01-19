# **Group Anagrams**

## **Problem Statement**
Given an array of strings, group anagrams together. An anagram is a word formed by rearranging the letters of another word.

---

## **Examples**

### Example 1:
- **Input**: `strs = ["eat","tea","tan","ate","nat","bat"]`
- **Output**: `[["bat"],["nat","tan"],["ate","eat","tea"]]`

---

## **Algorithmic Approach (Hash Map)**

1. Create a hash map where key is sorted string (or character count tuple).
2. For each word:
   - Sort the word or create character count.
   - Add to corresponding group in hash map.
3. Return all values from hash map.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n * k log k)` or `O(n * k)`  
  Where n is number of strings, k is max string length.
  O(k log k) for sorting, O(k) for character count.

- **Space Complexity**: `O(n * k)`  
  For storing all strings in groups.
