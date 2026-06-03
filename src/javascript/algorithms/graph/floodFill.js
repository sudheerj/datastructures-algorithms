/**
 * Perform flood fill on an image starting from position (sr, sc).
 * 
 * TC: O(m * n) where m is rows and n is columns
 * SC: O(m * n) for recursion stack in worst case
 * 
 * @param {number[][]} image - 2D array representing the image
 * @param {number} sr - starting row index
 * @param {number} sc - starting column index
 * @param {number} color - new color to fill
 * @return {number[][]} Modified image after flood fill
 */
function floodFill(image, sr, sc, color) {
    const originalColor = image[sr][sc];
    
    // if already same color, no need to process
    if (originalColor === color) {
        return image;
    }
    
    function dfs(r, c) {
        // boundary + color check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] !== originalColor) {
            return;
        }
        
        // update current cell color
        image[r][c] = color;
        
        // explore all 4 directions
        dfs(r-1, c);  // up
        dfs(r, c+1);  // right
        dfs(r+1, c);  // down
        dfs(r, c-1);  // left
    }
    
    dfs(sr, sc);
    return image;
}

// Test cases
console.log("Test case 1:");
let image1 = [[1,1,1],[1,1,0],[1,0,1]];
console.log(`Input: image = ${JSON.stringify(image1)}`);
console.log("sr = 1, sc = 1, color = 2");
let result1 = floodFill(image1, 1, 1, 2);
console.log(`Output: ${JSON.stringify(result1)}`);
console.log("Expected: [[2,2,2],[2,2,0],[2,0,1]]");
console.log("Explanation: From the center of the image with position (sr, sc) = (1, 1) (0-indexed),");
console.log("all pixels connected by a path of the same color as the starting pixel are colored with the new color.");
console.log();

console.log("Test case 2:");
let image2 = [[0,0,0],[0,0,0]];
console.log(`Input: image = ${JSON.stringify(image2)}`);
console.log("sr = 0, sc = 0, color = 0");
let result2 = floodFill(image2, 0, 0, 0);
console.log(`Output: ${JSON.stringify(result2)}`);
console.log("Expected: [[0,0,0],[0,0,0]]");
console.log("Explanation: The starting pixel is already colored 0, so no change is made.");
console.log();

console.log("Test case 3:");
let image3 = [[0,0,0],[0,1,1]];
console.log(`Input: image = ${JSON.stringify(image3)}`);
console.log("sr = 1, sc = 1, color = 1");
let result3 = floodFill(image3, 1, 1, 1);
console.log(`Output: ${JSON.stringify(result3)}`);
console.log("Expected: [[0,0,0],[0,1,1]]");
console.log("Explanation: The starting pixel is already colored 1, which is the same as the new color.");
console.log();

console.log("Test case 4:");
let image4 = [[1,1,1],[1,1,0],[1,0,1]];
console.log(`Input: image = ${JSON.stringify(image4)}`);
console.log("sr = 1, sc = 0, color = 3");
let result4 = floodFill(image4, 1, 0, 3);
console.log(`Output: ${JSON.stringify(result4)}`);
console.log("Expected: [[3,3,3],[3,3,0],[3,0,1]]");
console.log("Explanation: All pixels with color 1 connected to position (1,0) are changed to 3.");
console.log();

console.log("Test case 5:");
let image5 = [[0,0,0],[0,1,0],[0,0,0]];
console.log(`Input: image = ${JSON.stringify(image5)}`);
console.log("sr = 1, sc = 1, color = 2");
let result5 = floodFill(image5, 1, 1, 2);
console.log(`Output: ${JSON.stringify(result5)}`);
console.log("Expected: [[0,0,0],[0,2,0],[0,0,0]]");
console.log("Explanation: Only the center pixel is changed since it's isolated.");

module.exports = floodFill;
