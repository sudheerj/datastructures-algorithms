"""
Caesar Cipher

Given a string and a shift value, encrypt the string using Caesar cipher.
Each letter is shifted by the given number of positions in the alphabet.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def caesar_cipher(s, shift):
    """
    Shifts each letter by the given amount, wrapping around the alphabet.
    TC: O(n), SC: O(n)
    """
    shift = shift % 26
    result = ""

    for char in s:
        if "A" <= char <= "Z":
            code = ((ord(char) - 65 + shift + 26) % 26) + 65
            result += chr(code)
        elif "a" <= char <= "z":
            code = ((ord(char) - 97 + shift + 26) % 26) + 97
            result += chr(code)
        else:
            result += char

    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("Hello, World!", 3, "Khoor, Zruog!"),
        ("abcXYZ", 2, "cdeZAB"),
        ("abcXYZ", -2, "yzaVWX"),
        ("Caesar Cipher 123!", 4, "Geiwev Gmtliv 123!"),
    ]

    for s, shift, expected in test_cases:
        result = caesar_cipher(s, shift)
        print(f"Input: \"{s}\", shift={shift} | Output: \"{result}\" | Expected: \"{expected}\"")
