function letterCombinations(digits){
    let combinations = [];
    if(digits.length === 0) {
        return combinations;
    }
    let digitToChar = new Map();

    digitToChar.set('2', "abc");
    digitToChar.set('3', "def");
    digitToChar.set('4', "ghi");
    digitToChar.set('5', "jkl");
    digitToChar.set('6', "mno");
    digitToChar.set('7', "pqrs");
    digitToChar.set('8', "tuv");
    digitToChar.set('9', "wxyz");

    backtrack(0, "", digits, digitToChar, combinations);

    return combinations;
}

function backtrack(i, currStr, digits, digitToChar, combinations){
    if(digits.length === currStr.length) {
        combinations.push(currStr);
        return;
    }

    for (const ch of digitToChar.get(digits[i])) {
        backtrack(i+1, currStr+ch, digits, digitToChar, combinations);
    }
}

let digits1 = "24";
let digits2 = "";
console.log(letterCombinations(digits1));
console.log(letterCombinations(digits2));

