# Line-by-line scan with block flag  TC: O(n * L)  SC: O(n * L)

def remove_comments(source: list[str]) -> list[str]:
    result = []
    sb = []
    is_block = False

    for line in source:
        i = 0
        if not is_block:
            sb = []

        while i < len(line):
            if not is_block:
                if i + 1 < len(line) and line[i] == '/' and line[i + 1] == '/':
                    break  # rest of line is a line comment
                elif i + 1 < len(line) and line[i] == '/' and line[i + 1] == '*':
                    is_block = True
                    i += 2
                else:
                    sb.append(line[i])
                    i += 1
            else:
                if i + 1 < len(line) and line[i] == '*' and line[i + 1] == '/':
                    is_block = False
                    i += 2
                else:
                    i += 1  # skip characters inside block comment

        if not is_block and sb:
            result.append("".join(sb))

    return result


if __name__ == "__main__":
    test_cases = [
        (
            ["int x = 1; // this is a comment", "int y = 2;"],
            ["int x = 1; ", "int y = 2;"],
        ),
        (
            ["/* Test program */", "int main()", "{",
             "  // variable declaration", "int a, b, c;",
             "/* This is a test", "   multiline  ", "   comment for",
             "   testing */", "int d = b + c;", "}"],
            ["int main()", "{", "int a, b, c;", "int d = b + c;", "}"],
        ),
        (
            ["a/*comment*/b", "c"],
            ["ab", "c"],
        ),
        (
            ["// full line comment", "code line"],
            ["code line"],
        ),
        (
            ["int a = 1;", "int b = 2;"],
            ["int a = 1;", "int b = 2;"],
        ),
        (
            ["before/*skip*/after"],
            ["beforeafter"],
        ),
    ]

    for source, expected in test_cases:
        result = remove_comments(source)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
