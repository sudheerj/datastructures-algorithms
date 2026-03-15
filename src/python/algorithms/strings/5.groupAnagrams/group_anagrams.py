"""
Group Anagrams

Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

Time Complexity: O(m * n) - character count approach
Space Complexity: O(m * n)
"""


def group_anagrams_by_count(strs):
    """
    Groups anagrams using character frequency as key.
    TC: O(m * n), SC: O(m * n)
    """
    group_anagram_map = {}

    for s in strs:
        char_frequency = [0] * 26
        for ch in s:
            char_frequency[ord(ch) - 97] += 1
        key = tuple(char_frequency)
        if key in group_anagram_map:
            group_anagram_map[key].append(s)
        else:
            group_anagram_map[key] = [s]

    return list(group_anagram_map.values())


def group_anagrams_by_sort(strs):
    """
    Groups anagrams by sorting each string.
    TC: O(m * n log n), SC: O(m * n)
    """
    group_anagram_map = {}

    for s in strs:
        key = "".join(sorted(s))
        if key in group_anagram_map:
            group_anagram_map[key].append(s)
        else:
            group_anagram_map[key] = [s]

    return list(group_anagram_map.values())


# Test cases
if __name__ == "__main__":
    test_cases = [
        ["eat", "tea", "tan", "ate", "nat", "bat"],
        ["hello"],
        ["", ""],
        ["abc", "bca", "cab", "bac", "acb", "cba"],
        ["a"],
        ["ab", "ba", "abc", "cab", "bac", "bca", "cba"],
    ]

    for strs in test_cases:
        print(f"Input: {strs}")
        print(f"By Count: {group_anagrams_by_count(strs)}")
        print(f"By Sort: {group_anagrams_by_sort(strs)}")
        print("---")
