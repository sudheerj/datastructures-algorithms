def candy(ratings):
    n = len(ratings)
    candies = [1]*n
    for i in range(1, n):
        if ratings[i] > ratings[i-1]:
            candies[i] = candies[i-1] + 1
    for i in range(n-2, -1, -1):
        if ratings[i] > ratings[i+1]:
            candies[i] = max(candies[i], candies[i+1] + 1)
    return sum(candies)

if __name__ == "__main__":
    test_cases = [
        [1,0,2],
        [1,2,2],
        [1,3,2,2,1],
        [1,2,87,87,87,2,1],
        [1,3,4,5,2],
        [1,2,3,1,0],
        [1,6,10,8,7,3,2],
        [1,2,2,1,2,2,1],
        [1,2,3,4,5],
        [5,4,3,2,1]
    ]
    expected = [5,4,7,13,9,9,18,12,15,15]
    for i, (inp, exp) in enumerate(zip(test_cases, expected)):
        result = candy(inp)
        status = "PASS" if result == exp else "FAIL"
        print(f"Test {i+1} | Output: {result} | Expected: {exp} | {status}")
