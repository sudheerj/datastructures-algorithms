# Merge sort 
Merge sort is based on **divide and conquer technique** in which the list breaking down into several sub-lists until each sublist consists of a single element and merging those sublists in a manner that results into a sorted list.

## How it works
1. At first, divide the unsorted array into two half-sized sub-arrays.
2. Continue to divide the sub-arrays until the array has one element.
3. Merge each sub-array pairs together by keeping the lowest value first.
4. Repeat step3 until there are no sub-arrays left.

## Complexity

| Best            | Average             | Worst               | Space (Memory)    | Stable    | Advantage  |
| :-------------: | :-----------------: | :-----------------: | :-------: | :-------: | :-------- |
|  Ω(n log(n))               | θ(n log(n))       | O(n log(n))       | O(n)         | Yes       |   Sort efficiently large data sets        |