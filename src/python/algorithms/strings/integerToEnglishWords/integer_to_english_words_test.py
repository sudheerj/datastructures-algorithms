from integer_to_english_words import number_to_words

def run_tests():
    test_cases = [
        (0, "Zero"),
        (5, "Five"),
        (13, "Thirteen"),
        (20, "Twenty"),
        (45, "Forty Five"),
        (100, "One Hundred"),
        (123, "One Hundred Twenty Three"),
        (1000, "One Thousand"),
        (12345, "Twelve Thousand Three Hundred Forty Five"),
        (1000000, "One Million"),
        (1000000000, "One Billion"),
        (1234567891, "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"),
    ]
    for num, expected in test_cases:
        result = number_to_words(num).replace("  ", " ").strip()
        status = "PASS" if result == expected else "FAIL"
        print(f"Input: {num} | Output: '{result}' | Expected: '{expected}' | {status}")

if __name__ == "__main__":
    run_tests()
