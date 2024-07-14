# Heap Sort
HeapSort is an in-place comparison based sorting algorithm that uses **binary heap** data structure. The main idea behind this heap sort is to find either the highest value(max heap) or lowest value(min heap) and place it at the end, repeating the process until all the values are sorted.

## How it works
1. Build a max heap based on given input array.
2. Switch the top root with the last node and then remove it from the heap.
3. Rebuild the max heap again and repeat until there is only one element remaining in the heap.

## Complexity

| Best            | Average             | Worst               | Space (Memory)    | Stable    | Advantage  |
| :-------------: | :-----------------: | :-----------------: | :-------: | :-------: | :-------- |
|  Ω(n log(n))               | θ(n log(n))       | O(n log(n))       | O(1)         | Yes       |   Sort efficiently large data sets        |