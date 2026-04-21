// Integer to Roman
function integerToRoman(num) {
  const val = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  const syms = [
    "M",
    "CM",
    "D",
    "CD",
    "C",
    "XC",
    "L",
    "XL",
    "X",
    "IX",
    "V",
    "IV",
    "I",
  ];
  let res = "";
  for (let i = 0; i < val.length; i++) {
    while (num >= val[i]) {
      res += syms[i];
      num -= val[i];
    }
  }
  return res;
}

// Test cases
const tests = [3, 4, 9, 58, 1994, 40, 90, 400, 900];
const expected = [
  "III",
  "IV",
  "IX",
  "LVIII",
  "MCMXCIV",
  "XL",
  "XC",
  "CD",
  "CM",
];
for (let i = 0; i < tests.length; i++) {
  const res = integerToRoman(tests[i]);
  console.log(
    `integerToRoman(${tests[i]}) = '${res}' | Expected: '${expected[i]}'`,
  );
}
