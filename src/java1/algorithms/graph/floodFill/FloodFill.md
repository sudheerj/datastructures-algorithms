**Description:**
An image is represented by an `m x n` integer grid `image` where `image[i][j]` represents the pixel value of the image. You are also given three integers `sr`, `sc`, and `color`. You should perform a flood fill on the image starting from the pixel `image[sr][sc]`.

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with `color`.

Return the modified image after performing the flood fill.

## Problem Statement:
Given a 2D grid representing an image and a starting position (sr, sc), change the color of the starting pixel and all connected pixels of the same original color to a new color. Pixels are considered connected if they are adjacent horizontally or vertically (4-directional connectivity).

## Examples:

**Example 1:**
```
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (0-indexed),
all pixels connected by a path of the same color as the starting pixel (color 1) are 
colored with the new color (2). Note the bottom corner is not colored 2, because it is 
not 4-directionally connected to the starting pixel.
```

**Example 2:**
```
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, which is the same as the target 
color, so no changes are made to the image.
```

**Example 3:**
```
Input: image = [[0,0,0],[0,1,1]], sr = 1, sc = 1, color = 1
Output: [[0,0,0],[0,1,1]]
Explanation: The starting pixel is already colored 1, which is the same as the new color.
```

**Example 4:**
```
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 0, color = 3
Output: [[3,3,3],[3,3,0],[3,0,1]]
Explanation: All pixels with color 1 connected to position (1,0) are changed to 3.
```

**Example 5:**
```
Input: image = [[0,0,0],[0,1,0],[0,0,0]], sr = 1, sc = 1, color = 2
Output: [[0,0,0],[0,2,0],[0,0,0]]
Explanation: Only the center pixel is changed since it's isolated (not connected to 
any other pixel with the same color).
```

## Algorithmic Steps (DFS Approach)

This problem is solved efficiently using **Depth-First Search (DFS)** to explore all connected pixels with the same original color. The algorithm works as follows:

1. **Check if color change is needed**:
   - Get the original color at position (sr, sc)
   - If the original color is the same as the new color, return the image unchanged (optimization to prevent infinite recursion)

2. **Start DFS from the starting position**:
   - Call the DFS helper function with the starting position, new color, and original color

3. **DFS Helper Function**:
   - **Base cases (boundary and color checks)**:
     - If the position is out of bounds (row < 0 or row >= m or col < 0 or col >= n), return
     - If the current pixel's color is not the original color, return
   
   - **Update the current pixel**:
     - Change the current pixel's color to the new color
   
   - **Explore all 4 directions**:
     - Recursively call DFS on the top neighbor (r-1, c)
     - Recursively call DFS on the right neighbor (r, c+1)
     - Recursively call DFS on the bottom neighbor (r+1, c)
     - Recursively call DFS on the left neighbor (r, c-1)

4. **Return the modified image**

## Key Insights:

- **Early termination**: If the original color is the same as the new color, no changes are needed, preventing infinite recursion
- **4-directional connectivity**: Only pixels adjacent horizontally or vertically (not diagonally) are considered connected
- **In-place modification**: The image is modified directly without creating a copy
- **Visited tracking**: By changing the color immediately when visiting a pixel, we implicitly mark it as visited (no separate visited array needed)

## Alternative Approach (BFS):

This problem can also be solved using Breadth-First Search (BFS) with a queue:
- Add the starting position to a queue
- While the queue is not empty, dequeue a position
- Change its color and enqueue all valid 4-directional neighbors

## Time and Space Complexity:

**Time Complexity:** `O(m × n)` where `m` is the number of rows and `n` is the number of columns.
- In the worst case, we visit every pixel in the image once
- Each pixel is processed in constant time

**Space Complexity:** `O(m × n)` 
- In the worst case (when all pixels have the same color), the recursion stack can go as deep as the total number of pixels
- For BFS approach: O(m × n) for the queue in the worst case

## Constraints:
- m == image.length
- n == image[i].length
- 1 ≤ m, n ≤ 50
- 0 ≤ image[i][j], color < 2¹⁶
- 0 ≤ sr < m
- 0 ≤ sc < n
