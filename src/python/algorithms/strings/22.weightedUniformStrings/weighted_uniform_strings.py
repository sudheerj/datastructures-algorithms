"""
Weighted Uniform Strings

A uniform string consists of a single repeating character.
The weight of a character is its 1-indexed position in the alphabet (a=1, b=2, ..., z=26).
The weight of a uniform string is the weight of its character times its length.
Given a string, find all weights of its uniform substrings and answer queries.

Time Complexity: O(n + q) where q is the number of queries
Space Complexity: O(n)
"""


def weighted_uniform_strings(s, queries):
    """
    Collects all uniform substring weights, then answers queries.
    TC: O(n + q), SC: O(n)
    """
    weights = set()
    curr_weight = 0
    prev_char = ""

    for ch in s:
        char_weight = ord(ch) - 96
        if ch == prev_char:
            curr_weight += char_weight
        else:
            curr_weight = char_weight
            prev_char = ch
        weights.add(curr_weight)

    return ["Yes" if query in weights else "No" for query in queries]


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("abccddde", [1, 3, 12, 5, 9, 10], ["Yes", "Yes", "Yes", "Yes", "No", "No"]),
        ("aaabbbbcccddd", [9, 7, 8, 12, 5], ["Yes", "No", "Yes", "Yes", "No"]),
        ("abcd", [1, 2, 3, 4, 5], ["Yes", "Yes", "Yes", "Yes", "No"]),
        ("zzzyyy", [26, 52, 78, 80], ["Yes", "Yes", "Yes", "No"]),
    ]

    for s, queries, expected in test_cases:
        result = weighted_uniform_strings(s, queries)
        print(f"Input: \"{s}\", queries={queries} | Output: {result} | Expected: {expected}")
