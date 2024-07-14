# QuickSort

QuickSort is a sorting algorithm based on **Divide and Conquer technique** that picks any one element(last, first, middle or random element) which can be choosen as a pivot and partitions the given array around the picked pivot by keeping the pivot in its correct position in the sorted array. The elements less than pivot are kept on the left side and elements greater than pivot are on the right side of the pivot.

## How it works
1. Choose any value in the array as pivot element.
2. Order the array elements in such a way that lower values than pivot element are on the the left side, and higher values are on the right side.
3. Swap the pivot element with first higher value to keep the pivot between the lower and higher values.
4. Repeat steps 1-3 recursively for the sub-arrays on the left side and right side of pivot element until the sub-array contain only one element.

## Complexity

| Best            | Average             | Worst               | Space (Memory)    | Stable    | Advantage  |
| :-------------: | :-----------------: | :-----------------: | :-------: | :-------: | :-------- |
|  Ω(n log(n))               | θ(n log(n))       | O(n<sup>2</sup>)       | O(log n)         | Yes       |   Efficient alogorithm except for almost sorted arrays        |