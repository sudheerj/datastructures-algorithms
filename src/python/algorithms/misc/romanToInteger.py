"""
Roman to Integer

Time Complexity: O(n), where n is the length of the input string.
Space Complexity: O(1), since the map size is constant and only a few variables are used.
"""
def roman_to_integer(s):
    roman = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    result = 0
    prev = 0
    for c in reversed(s):
        curr = roman[c]
        if curr < prev:
            result -= curr
        else:
            result += curr
        prev = curr
    return result

if __name__ == "__main__":
    tests = ["III", "IV", "IX", "LVIII", "MCMXCIV", "XL", "XC", "CD", "CM"]
    expected = [3, 4, 9, 58, 1994, 40, 90, 400, 900]
    for t, exp in zip(tests, expected):
        res = roman_to_integer(t)
        print(f"roman_to_integer('{t}') = {res} | Expected: {exp}")
