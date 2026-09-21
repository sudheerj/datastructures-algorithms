def maximize_toys(prices, budget):
    prices.sort()

    count = 0
    for price in prices:
        if price > budget:
            break
        budget -= price
        count += 1

    return count


if __name__ == "__main__":
    test_cases = [
        ([1, 12, 5, 111, 200, 1000, 10], 50, 4),
        ([3, 5, 7], 10, 2),
        ([10, 20], 10, 1),
        ([5, 6], 4, 0),
    ]

    for index, (prices, budget, expected) in enumerate(test_cases, 1):
        result = maximize_toys(prices, budget)
        status = "PASS" if result == expected else "FAIL"
        print(f"Test {index} | Output: {result} | Expected: {expected} | {status}")