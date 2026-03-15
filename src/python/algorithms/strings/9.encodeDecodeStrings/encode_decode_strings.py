"""
Encode and Decode Strings

Write an algorithm to encode a list of strings to a single string,
and then decode it back to the original list.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def encode_strings(strs):
    """
    Encodes a list of strings to a single string using length-prefix encoding.
    TC: O(n), SC: O(n)
    """
    encoded_str = ""
    for s in strs:
        encoded_str += str(len(s)) + "#" + s
    return encoded_str


def decode_string(s):
    """
    Decodes a single string back to a list of strings.
    TC: O(n), SC: O(n)
    """
    decoded_str_arr = []
    i = 0
    while i < len(s):
        j = i
        while s[j] != "#":
            j += 1
        word_length = int(s[i:j])
        start = j + 1
        sub_str = s[start:start + word_length]
        decoded_str_arr.append(sub_str)
        i = start + word_length
    return decoded_str_arr


# Test cases
if __name__ == "__main__":
    test_cases = [
        ["learn", "datastructure", "algorithms", "easily"],
        ["one", "two", "three"],
        ["", "a", ""],
        ["#", "##", "abc#def"],
        [],
        ["", ""],
    ]

    for arr in test_cases:
        encoded = encode_strings(arr)
        decoded = decode_string(encoded) if encoded else []
        print(f"Input: {arr} | Encoded: \"{encoded}\" | Decoded: {decoded}")
