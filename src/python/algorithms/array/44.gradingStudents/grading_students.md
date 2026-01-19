# **Grading Students**

## **Problem Statement**
Round each student's grade according to these rules:
- If the grade is less than 38, no rounding occurs (failing grade).
- If the difference between the grade and the next multiple of 5 is less than 3, round up to the next multiple of 5.

---

## **Examples**

### Example 1:
- **Input**: `grades = [73, 67, 38, 33]`
- **Output**: `[75, 67, 40, 33]`
- **Explanation**:
  - 73 → 75 (75-73 < 3)
  - 67 → 67 (70-67 = 3, not < 3)
  - 38 → 40 (40-38 < 3)
  - 33 → 33 (failing grade)

---

## **Algorithmic Approach**

1. For each grade:
   - If grade < 38: Keep as is (failing).
   - Calculate next multiple of 5.
   - If difference < 3: Round up.
   - Otherwise: Keep original grade.
2. Return the modified grades.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the grades.

- **Space Complexity**: `O(n)`  
  For the result array.
