# Longest Common Prefix
# Vertical scanning approach
# TC: O(S) where S = sum of all characters, SC: O(1)

def longest_common_prefix(strs: list[str]) -> str:
    for i in range(len(strs[0])):
        ch = strs[0][i]
        for j in range(1, len(strs)):
            if i >= len(strs[j]) or strs[j][i] != ch:
                return strs[0][:i]
    return strs[0]


# Test cases
test_cases = [
    (["flower", "flow", "flight"], "fl"),
    (["dog", "racecar", "car"], ""),
    (["interspecies", "interstellar", "interstate"], "inters"),
    (["a"], "a"),
    (["", "b"], ""),
    (["abc", "abc", "abc"], "abc"),
    (["ab", "a"], "a"),
    (["cir", "car"], "c"),
]

for inputs, expected in test_cases:
    result = longest_common_prefix(inputs)
    status = "✓" if result == expected else f'✗ (expected "{expected}")'
    print(f'{inputs} => "{result}" {status}')
