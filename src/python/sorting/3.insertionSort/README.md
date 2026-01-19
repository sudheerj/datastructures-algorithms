# Insertion Sort

Insertion Sort builds the final sorted array one item at a time by repeatedly picking the next item and inserting it into its correct position.

## Complexity

| Case    | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Best    | O(n)           | O(1)             |
| Average | O(n²)          | O(1)             |
| Worst   | O(n²)          | O(1)             |

## How it Works

1. Start from the second element
2. Compare with all previous elements
3. Shift larger elements to the right
4. Insert the element at its correct position
5. Repeat for all elements

## When to Use

- Small datasets
- Nearly sorted data (very efficient)
- Online algorithms (can sort as data arrives)
- Stable sort needed
