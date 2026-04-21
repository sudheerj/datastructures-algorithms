def integer_to_roman(num):
    val = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    syms = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
    res = ""
    for i in range(len(val)):
        while num >= val[i]:
            res += syms[i]
            num -= val[i]
    return res

if __name__ == "__main__":
    tests = [3, 4, 9, 58, 1994, 40, 90, 400, 900]
    expected = ["III", "IV", "IX", "LVIII", "MCMXCIV", "XL", "XC", "CD", "CM"]
    for t, exp in zip(tests, expected):
        res = integer_to_roman(t)
        print(f"integer_to_roman({t}) = '{res}' | Expected: '{exp}'")
