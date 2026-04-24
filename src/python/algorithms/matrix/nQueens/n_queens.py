def solve_n_queens(n):
    def backtrack(r):
        if r == n:
            board = [''.join(row) for row in curr]
            result.append(board)
            return
        for c in range(n):
            if c in cols or (r+c) in pos_diag or (r-c) in neg_diag:
                continue
            cols.add(c)
            pos_diag.add(r+c)
            neg_diag.add(r-c)
            curr[r][c] = 'Q'
            backtrack(r+1)
            cols.remove(c)
            pos_diag.remove(r+c)
            neg_diag.remove(r-c)
            curr[r][c] = '.'
    result = []
    cols, pos_diag, neg_diag = set(), set(), set()
    curr = [['.']*n for _ in range(n)]
    backtrack(0)
    return result

if __name__ == "__main__":
    print("Input: n = 1\nOutput:", solve_n_queens(1))
    print("Input: n = 2\nOutput:", solve_n_queens(2))
    print("Input: n = 3\nOutput:", solve_n_queens(3))
    print("Input: n = 4\nOutput:", solve_n_queens(4))
    print("Input: n = 5\nOutput:", solve_n_queens(5))
