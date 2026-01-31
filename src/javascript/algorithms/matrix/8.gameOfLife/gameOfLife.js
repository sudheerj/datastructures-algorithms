/**
 * Game of Life
 *
 * Given an m x n grid of cells where each cell is either live (1) or dead (0),
 * compute the next state according to Conway's Game of Life rules:
 * 1. Live cell with < 2 live neighbors dies (under-population).
 * 2. Live cell with 2-3 live neighbors lives.
 * 3. Live cell with > 3 live neighbors dies (over-population).
 * 4. Dead cell with exactly 3 live neighbors becomes live (reproduction).
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) - in-place modification
 */

/**
 * In-place solution using state encoding
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
function gameOfLife(board) {
    if (!board || board.length === 0) {
        return;
    }

    const rows = board.length;
    const cols = board[0].length;

    // State encoding:
    // 0: dead -> dead
    // 1: live -> dead
    // 2: dead -> live
    // 3: live -> live

    function countLiveNeighbors(r, c) {
        let count = 0;
        for (let dr = -1; dr <= 1; dr++) {
            for (let dc = -1; dc <= 1; dc++) {
                if (dr === 0 && dc === 0) continue;
                const nr = r + dr;
                const nc = c + dc;
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    // Check original state (1 or 3 means originally alive)
                    if (board[nr][nc] === 1 || board[nr][nc] === 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // First pass: encode new state
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            const liveNeighbors = countLiveNeighbors(r, c);

            if (board[r][c] === 1) {
                // Currently alive
                if (liveNeighbors === 2 || liveNeighbors === 3) {
                    board[r][c] = 3; // Stays alive
                }
                // else stays 1 (will die)
            } else {
                // Currently dead
                if (liveNeighbors === 3) {
                    board[r][c] = 2; // Becomes alive
                }
            }
        }
    }

    // Second pass: decode final state
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            board[r][c] = board[r][c] >= 2 ? 1 : 0;
        }
    }
}

// Test cases
const board1 = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]];
console.log("Before:", JSON.stringify(board1));
gameOfLife(board1);
console.log("After:", JSON.stringify(board1)); // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

const board2 = [[1, 1], [1, 0]];
console.log("\nBefore:", JSON.stringify(board2));
gameOfLife(board2);
console.log("After:", JSON.stringify(board2)); // [[1,1],[1,1]]
