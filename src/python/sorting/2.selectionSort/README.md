# Selection Sort

Selection Sort divides the input list into a sorted and an unsorted region, and repeatedly selects the smallest element from the unsorted region to add to the sorted region.

## Complexity

| Case    | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Best    | O(n²)          | O(1)             |
| Average | O(n²)          | O(1)             |
| Worst   | O(n²)          | O(1)             |

## How it Works

1. Find the minimum element in the unsorted portion
2. Swap it with the first unsorted element
3. Move the boundary between sorted and unsorted regions
4. Repeat until fully sorted

## When to Use

- Simple implementation needed
- Memory is limited (in-place sorting)
- Small datasets
