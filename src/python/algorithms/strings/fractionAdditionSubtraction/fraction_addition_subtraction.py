from math import gcd


# String parsing and simulation TC: O(n) SC: O(1)
def fraction_addition(expression: str) -> str:
    numerator, denominator = 0, 1
    i, n = 0, len(expression)

    while i < n:
        # Read sign
        sign = 1
        if expression[i] in ('+', '-'):
            if expression[i] == '-':
                sign = -1
            i += 1

        # Read numerator digits
        num = 0
        while i < n and expression[i].isdigit():
            num = num * 10 + int(expression[i])
            i += 1
        num *= sign

        # Skip '/'
        i += 1

        # Read denominator digits
        den = 0
        while i < n and expression[i].isdigit():
            den = den * 10 + int(expression[i])
            i += 1

        # Add fractions
        numerator = numerator * den + num * denominator
        denominator = denominator * den

        # Reduce fraction
        g = gcd(abs(numerator), denominator)
        numerator //= g
        denominator //= g

    return f"{numerator}/{denominator}"


if __name__ == "__main__":
    test_cases = [
        ("-1/2+1/2",       "0/1"),
        ("-1/2+1/2+1/3",  "1/3"),
        ("1/3-1/2",        "-1/6"),
        ("5/3+1/3",        "2/1"),
        ("-3/2+3/2",       "0/1"),
        ("1/4+1/4",        "1/2"),
    ]

    for expression, expected in test_cases:
        result = fraction_addition(expression)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] expression="{expression}" result={result} expected={expected}')
