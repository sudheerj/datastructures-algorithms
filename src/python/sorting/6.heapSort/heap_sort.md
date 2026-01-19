# Heap Sort

Heap Sort uses a binary heap data structure to sort elements. It builds a max heap and repeatedly extracts the maximum element.

## Complexity

| Case    | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Best    | O(n log n)     | O(1)             |
| Average | O(n log n)     | O(1)             |
| Worst   | O(n log n)     | O(1)             |

## How it Works

1. Build a max heap from the input array
2. Swap the root (maximum) with the last element
3. Reduce heap size by 1 and heapify the root
4. Repeat until heap size is 1

## When to Use

- Guaranteed O(n log n) performance needed
- In-place sorting required
- Not stable sort needed
- Space is a constraint
