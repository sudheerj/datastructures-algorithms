# Radix Sort

Radix Sort is a non-comparative sorting algorithm that sorts integers by processing individual digits.

## Complexity

| Case    | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| Best    | O(nk)          | O(n + k)         |
| Average | O(nk)          | O(n + k)         |
| Worst   | O(nk)          | O(n + k)         |

Where `n` is the number of elements and `k` is the number of digits in the maximum number.

## How it Works

1. Find the maximum number to know the number of digits
2. For each digit position (from least to most significant):
   - Put each number in a bucket based on that digit
   - Collect numbers from buckets in order

## When to Use

- Sorting integers or strings of fixed length
- When comparison-based sorting is not efficient
- Data has limited range of digits/characters
