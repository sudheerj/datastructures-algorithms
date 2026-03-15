"""
Time Conversion

Given a time in 12-hour AM/PM format, convert it to 24-hour (military) time.

Time Complexity: O(1)
Space Complexity: O(1)
"""


def time_conversion(s):
    """
    Converts 12-hour time format to 24-hour format.
    TC: O(1), SC: O(1)
    """
    period = s[-2:]
    hh, mm, ss = s[:-2].split(":")

    hh = int(hh)
    if period == "AM":
        if hh == 12:
            hh = 0
    else:
        if hh != 12:
            hh += 12

    return f"{hh:02d}:{mm}:{ss}"


# Test cases
if __name__ == "__main__":
    test_cases = [
        ("07:05:45PM", "19:05:45"),
        ("12:00:00AM", "00:00:00"),
        ("12:00:00PM", "12:00:00"),
        ("01:15:30AM", "01:15:30"),
    ]

    for s, expected in test_cases:
        result = time_conversion(s)
        print(f"Input: \"{s}\" | Output: \"{result}\" | Expected: \"{expected}\"")
