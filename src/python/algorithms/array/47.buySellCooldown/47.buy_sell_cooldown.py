def buy_sell_cooldown(prices):
    hold = -prices[0]
    sold = 0
    rest = 0

    for price in prices[1: len(prices)]:
        prev_hold = hold
        prev_sold = sold
        prev_rest = rest

        hold = max(prev_hold, prev_rest-price)
        sold = price + prev_hold
        rest = max(prev_sold, prev_rest)

    return max(sold, rest)

def buy_sell_cooldown1(prices):

    memo = {}

    def dfs(i, holding):
        if i >= len(prices):
            return 0

        if (i, holding) in memo:
            return memo[(i, holding)]

        cooldown = dfs(i+1, holding)

        if holding:
            hold = dfs(i+1, not holding) -prices[i]
            memo[(i, holding)] = max(hold, cooldown)
        else:
            sell = dfs(i+2, not holding) + prices[i]
            memo[(i, holding)] = max(sell, cooldown)

        return memo[(i, holding)]

    return dfs(0, True)


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 0, 2],  # 3 (buy at 1, sell at 3, cooldown, buy at 0, sell at 2)
        [1],               # 0 (single price, no transaction possible)
        [1, 2, 4],         # 3 (buy at 1, sell at 4)
        [2, 1, 4],         # 3 (buy at 1, sell at 4)
        [1, 2, 3, 4, 5],  # 4 (buy at 1, sell at 5)
        [7, 6, 4, 3, 1],  # 0 (no profit possible)
    ]

    for prices in test_cases:
        print(f"Prices: {prices}")
        print(f"Max profit (DP): {buy_sell_cooldown(prices)}")
        print(f"Max profit (DFS): {buy_sell_cooldown1(prices)}")
        print()
