"""
Group Anagrams

Given an array of strings strs, group the anagrams together.

Time Complexity: O(n * k log k) where k is max string length
Space Complexity: O(n * k)
"""

from collections import defaultdict


def group_anagrams(strs):
    """
    Using sorted string as key.
    TC: O(n * k log k), SC: O(n * k)
    """
    anagram_map = defaultdict(list)
    
    for s in strs:
        key = ''.join(sorted(s))
        anagram_map[key].append(s)
    
    return list(anagram_map.values())


def group_anagrams_count(strs):
    """
    Using character count as key.
    TC: O(n * k), SC: O(n * k)
    """
    anagram_map = defaultdict(list)
    
    for s in strs:
        count = [0] * 26
        for char in s:
            count[ord(char) - ord('a')] += 1
        key = tuple(count)
        anagram_map[key].append(s)
    
    return list(anagram_map.values())


# Test cases
if __name__ == "__main__":
    test_cases = [
        ["eat", "tea", "tan", "ate", "nat", "bat"],
        [""],
        ["a"],
    ]
    
    for strs in test_cases:
        print(f"Input: {strs}")
        print(f"Grouped: {group_anagrams(strs)}")
        print()
