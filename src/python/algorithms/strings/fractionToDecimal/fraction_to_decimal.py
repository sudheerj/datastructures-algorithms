# Long division with HashMap  TC: O(d) SC: O(d)
def fraction_to_decimal(numerator, denominator):
    if numerator == 0:
        return "0"

    result = []

    if (numerator < 0) ^ (denominator < 0):
        result.append("-")

    num = abs(numerator)
    den = abs(denominator)

    result.append(str(num // den))
    remainder = num % den

    if remainder == 0:
        return "".join(result)

    result.append(".")

    seen = {}

    while remainder > 0:
        if remainder in seen:
            index = seen[remainder]
            result.insert(index, "(")
            result.append(")")
            break

        seen[remainder] = len(result)
        remainder *= 10
        result.append(str(remainder // den))
        remainder %= den

    return "".join(result)


if __name__ == "__main__":
    test_cases = [
        (1,  2,   "0.5"),
        (2,  1,   "2"),
        (4,  333, "0.(012)"),
        (1,  3,   "0.(3)"),
        (-1, -2,  "0.5"),
    ]

    for numerator, denominator, expected in test_cases:
        result = fraction_to_decimal(numerator, denominator)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
