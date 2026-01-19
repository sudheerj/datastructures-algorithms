# **Encode and Decode Strings**

## **Problem Statement**
Design an algorithm to encode a list of strings to a single string, and decode it back to the original list of strings.

---

## **Examples**

### Example 1:
- **Input**: `["Hello","World"]`
- **Encoded**: Some encoded string
- **Decoded**: `["Hello","World"]`

---

## **Algorithmic Approach (Length Prefix)**

### Encode:
For each string, prepend its length followed by a delimiter (e.g., "#"):
- "Hello" → "5#Hello"
- Result: "5#Hello5#World"

### Decode:
1. Read characters until delimiter to get length.
2. Read that many characters as the string.
3. Repeat until end.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Where n is total length of all strings.

- **Space Complexity**: `O(1)`  
  Extra space (excluding output).
