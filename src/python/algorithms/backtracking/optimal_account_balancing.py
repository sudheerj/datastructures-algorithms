def min_transfers(transactions):
    from collections import defaultdict
    def dfs(debt, start):
        while start < len(debt) and debt[start] == 0:
            start += 1
        if start == len(debt):
            return 0
        min_tx = float('inf')
        for i in range(start+1, len(debt)):
            if debt[i] * debt[start] < 0:
                debt[i] += debt[start]
                min_tx = min(min_tx, 1 + dfs(debt, start+1))
                debt[i] -= debt[start]
        return min_tx
    balance = defaultdict(int)
    for f, t, amt in transactions:
        balance[f] -= amt
        balance[t] += amt
    debt = [v for v in balance.values() if v != 0]
    return dfs(debt, 0)

if __name__ == "__main__":
    tests = [
        ([[0,1,10],[2,0,5]], 2),
        ([[0,1,10],[1,0,10]], 0),
        ([[0,1,10],[1,2,5],[2,0,5]], 1),
        ([[0,1,10],[1,2,5],[2,3,5],[3,0,5]], 2),
        ([[0,1,5],[0,2,10],[1,2,5]], 2),
        ([[0,1,1],[1,2,1],[2,0,1]], 1),
    ]
    for idx, (transactions, expected) in enumerate(tests, 1):
        result = min_transfers([x[:] for x in transactions])
        print(f"Test {idx}: Output={result}, Expected={expected} [{'PASS' if result==expected else 'FAIL'}]")
