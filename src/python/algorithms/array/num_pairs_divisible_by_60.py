def num_pairs_divisible_by_60(time):
    count = [0] * 60
    pairs = 0
    for t in time:
        rem = t % 60
        comp = (60 - rem) % 60
        pairs += count[comp]
        count[rem] += 1
    return pairs

if __name__ == "__main__":
    test_cases = [
        [30, 20, 150, 100, 40],    # 3 pairs
        [60, 60, 60],              # 3 pairs
        [10, 50, 90, 30],          # 2 pairs
        [1, 2, 3, 4, 5, 6],        # 0 pairs
        [60, 120, 180],            # 3 pairs
        [20, 40, 60, 80, 100, 120] # 7 pairs
    ]
    expected = [3, 3, 2, 0, 3, 7]
    for i, (tc, exp) in enumerate(zip(test_cases, expected)):
        result = num_pairs_divisible_by_60(tc)
        status = "PASS" if result == exp else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {exp} | {status}")
