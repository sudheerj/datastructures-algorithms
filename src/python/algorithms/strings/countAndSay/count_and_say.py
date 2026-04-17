# Count and Say
# TC: O(n * m), SC: O(m)

def count_and_say(n: int) -> str:
    result = "1"

    for _ in range(1, n):
        sb = []
        count = 1

        for j in range(1, len(result)):
            if result[j] == result[j - 1]:
                count += 1
            else:
                sb.append(str(count) + result[j - 1])
                count = 1

        sb.append(str(count) + result[-1])
        result = "".join(sb)

    return result


# Test cases
test_cases = [
    (1, "1"),
    (2, "11"),
    (3, "21"),
    (4, "1211"),
    (5, "111221"),
    (6, "312211"),
]

for n, expected in test_cases:
    result = count_and_say(n)
    status = "✓" if result == expected else f'✗ (expected "{expected}")'
    print(f'n={n} => "{result}" {status}')
