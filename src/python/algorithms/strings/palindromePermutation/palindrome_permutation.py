# Palindrome Permutation
# Given a string, determine if a permutation of the string could form a palindrome.
# TC: O(n), SC: O(1)

def can_permute_palindrome(s: str) -> bool:
    odd_set = set()
    for ch in s:
        if ch in odd_set:
            odd_set.remove(ch)
        else:
            odd_set.add(ch)
    return len(odd_set) <= 1


# Test cases
test_cases = ["aab", "code", "carerac", "", "a", "aa", "ab", "aaabbbb", "aabbccdd"]
expected   = [True,  False,  True,      True, True, True, False, True,    True]

for i in range(len(test_cases)):
    result = can_permute_palindrome(test_cases[i])
    status = "✓" if result == expected[i] else f"✗ (expected {expected[i]})"
    print(f'"{test_cases[i]}" => {result} {status}')
