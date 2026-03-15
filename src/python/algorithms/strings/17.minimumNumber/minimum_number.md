**Description:**
Given a password of length `n`, find the minimum number of characters that must be added to make it a strong password. A strong password has at least 6 characters and contains at least one digit, one lowercase letter, one uppercase letter, and one special character (`!@#$%^&*()-+`).

## Examples

**Example 1:**  
Input: `n = 3, password = "Ab1"`  
Output: `3`

**Example 2:**  
Input: `n = 4, password = "4700"`  
Output: `3`

**Example 3:**  
Input: `n = 5, password = "aB1@"`  
Output: `1`

**Example 4:**  
Input: `n = 6, password = "aB1@xyz"`  
Output: `0`

## Algorithm

1. Check whether the password contains at least one digit, one lowercase letter, one uppercase letter, and one special character using regex.
2. Count the number of missing character types.
3. Return the maximum of the missing types count and `6 - n` (to ensure minimum length of 6).

## Complexity

- **Time Complexity:** O(n), where n is the length of the password (for regex checks).
- **Space Complexity:** O(1), as only a few variables are used.