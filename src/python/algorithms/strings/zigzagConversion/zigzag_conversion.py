def zigzag_conversion(s, numRows):
    if numRows <= 1 or numRows >= len(s):
        return s
    rows = ['' for _ in range(numRows)]
    curr_row, going_down = 0, False
    for ch in s:
        rows[curr_row] += ch
        if curr_row == 0 or curr_row == numRows-1:
            going_down = not going_down
        curr_row += 1 if going_down else -1
    return ''.join(rows)

if __name__ == "__main__":
    # Example 1: "PAYPALISHIRING", 3
    # Expected: "PAHNAPLSIIGYIR"
    print(zigzag_conversion("PAYPALISHIRING", 3))
    # Example 2: "PAYPALISHIRING", 4
    # Expected: "PINALSIGYAHRPI"
    print(zigzag_conversion("PAYPALISHIRING", 4))
    # Example 3: "A", 1
    # Expected: "A"
    print(zigzag_conversion("A", 1))
    # Example 4: "AB", 1
    # Expected: "AB"
    print(zigzag_conversion("AB", 1))
    # Example 5: "ABC", 2
    # Expected: "ACB"
    print(zigzag_conversion("ABC", 2))
