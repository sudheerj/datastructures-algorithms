from collections import deque
from copy import deepcopy

def get_pos(num, n):
    row_from_bottom = (num-1)//n
    row = n-1-row_from_bottom
    col = (num-1)%n
    if row_from_bottom%2 == 1:
        col = n-1-col
    return row, col

def snakes_and_ladders(board):
    n = len(board)
    visited = [False]*(n*n+1)
    queue = deque([1])
    visited[1] = True
    moves = 0
    while queue:
        for _ in range(len(queue)):
            curr = queue.popleft()
            if curr == n*n:
                return moves
            for dice in range(1,7):
                next_ = curr + dice
                if next_ > n*n:
                    continue
                r, c = get_pos(next_, n)
                if board[r][c] != -1:
                    next_ = board[r][c]
                if not visited[next_]:
                    visited[next_] = True
                    queue.append(next_)
        moves += 1
    return -1

def run_tests():
    test_cases = [
        # Example 1
        [
            [-1,-1,-1,-1,-1,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,35,-1,-1,13,-1],
            [-1,-1,-1,-1,-1,-1],
            [-1,15,-1,-1,-1,-1]
        ],
        # Example 2 (no snakes/ladders)
        [
            [-1,-1,-1],
            [-1,-1,-1],
            [-1,-1,-1]
        ],
        # Example 3 (ladder at start)
        [
            [-1,-1,-1],
            [-1,9,8],
            [-1,8,9]
        ]
    ]
    expected = [4, 2, 1]
    for i, (board, exp) in enumerate(zip(test_cases, expected)):
        result = snakes_and_ladders(deepcopy(board))
        status = "PASS" if result == exp else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {exp} | {status}")

if __name__ == "__main__":
    run_tests()
