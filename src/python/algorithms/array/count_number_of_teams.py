def count_number_of_teams(rating):
    n = len(rating)
    res = 0
    for j in range(n):
        left_less = left_greater = right_greater = right_less = 0
        for i in range(j):
            if rating[i] < rating[j]:
                left_less += 1
            elif rating[i] > rating[j]:
                left_greater += 1
        for k in range(j+1, n):
            if rating[k] > rating[j]:
                right_greater += 1
            elif rating[k] < rating[j]:
                right_less += 1
        res += left_less * right_greater + left_greater * right_less
    return res

if __name__ == "__main__":
    test_cases = [
        ([2, 5, 3, 4, 1], 3),
        ([2, 1, 3], 0),
        ([1, 2, 3, 4], 4),
        ([4, 3, 2, 1], 4),
        ([1, 3, 2, 4, 5], 5),
        ([1, 2, 3, 2, 1], 6),
        ([1, 1, 1, 1], 0),
        ([1, 2, 1, 2, 1, 2], 0)
    ]
    for i, (arr, expected) in enumerate(test_cases, 1):
        result = count_number_of_teams(arr)
        status = "PASS" if result == expected else "FAIL"
        print(f"Test {i} | Output: {result} | Expected: {expected} | {status}")
