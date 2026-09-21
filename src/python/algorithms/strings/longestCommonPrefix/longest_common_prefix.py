# Longest Common Prefix
# Vertical scanning approach
# TC: O(S) where S = sum of all characters, SC: O(1)

def longest_common_prefix1(strs: list[str]) -> str:
    if not strs:
        return ""
    for i in range(len(strs[0])):
        ch = strs[0][i]
        for j in range(1, len(strs)):
            if i >= len(strs[j]) or strs[j][i] != ch:
                return strs[0][:i]
    return strs[0]

def longest_common_prefix2(strs: list[str]) -> str:
    if not strs:
        return ""

    prefix = strs[0]

    for str in strs[1:]:
        while not str.startswith(prefix):
            prefix = prefix[:-1]

            if not prefix:
                return ""
    return prefix   
    
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
    result1 = longest_common_prefix1(inputs)
    result2 = longest_common_prefix2(inputs)

    status1 = "✓" if result1 == expected else f'✗ (expected "{expected}")'
    status2 = "✓" if result2 == expected else f'✗ (expected "{expected}")'

    print(f'{inputs} => "{result1}" {status1}')
    print(f'{inputs} => "{result2}" {status2}')

