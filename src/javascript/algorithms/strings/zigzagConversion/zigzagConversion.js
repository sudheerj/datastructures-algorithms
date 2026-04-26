function zigzagConversion(s, numRows) {
    if (numRows <= 1 || numRows >= s.length) return s;
    const rows = Array.from({length: numRows}, () => '');
    let currRow = 0, goingDown = false;
    for (const ch of s) {
        rows[currRow] += ch;
        if (currRow === 0 || currRow === numRows-1) goingDown = !goingDown;
        currRow += goingDown ? 1 : -1;
    }
    return rows.join('');
}

// Example 1: "PAYPALISHIRING", 3
// Expected: "PAHNAPLSIIGYIR"
console.log(zigzagConversion("PAYPALISHIRING", 3));
// Example 2: "PAYPALISHIRING", 4
// Expected: "PINALSIGYAHRPI"
console.log(zigzagConversion("PAYPALISHIRING", 4));
// Example 3: "A", 1
// Expected: "A"
console.log(zigzagConversion("A", 1));
// Example 4: "AB", 1
// Expected: "AB"
console.log(zigzagConversion("AB", 1));
// Example 5: "ABC", 2
// Expected: "ACB"
console.log(zigzagConversion("ABC", 2));
