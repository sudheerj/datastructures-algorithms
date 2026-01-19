# Quick Sort

Quick Sort is a divide-and-conquer algorithm that picks an element as pivot and partitions the array around it.

## Complexity

| Case    | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Best    | O(n log n)     | O(log n)         |
| Average | O(n log n)     | O(log n)         |
| Worst   | O(n²)          | O(n)             |

## How it Works

1. Choose a pivot element
2. Partition: put smaller elements left, larger elements right
3. Recursively apply to left and right partitions

## When to Use

- In-memory sorting
- General-purpose sorting
- Average case performance matters
- Not stable sort needed
