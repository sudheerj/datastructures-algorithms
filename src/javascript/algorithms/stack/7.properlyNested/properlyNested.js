function isProperlyNested(input) {
    let stackCount = 0;

    for(let ch of input) {
        if(ch === '(') {
            stackCount++;
        } else if(ch === ')'){
            if(stackCount === 0) return 0;
            stackCount--;
        }
    }

    return stackCount === 0 ? 1 : 0;
}

console.log(isProperlyNested("(()(())())")); // 1 (properly nested)
console.log(isProperlyNested("())"));        // 0 (improper)
console.log(isProperlyNested("("));          // 0 (unclosed)
console.log(isProperlyNested(""));           // 1 (empty string is properly nested)
