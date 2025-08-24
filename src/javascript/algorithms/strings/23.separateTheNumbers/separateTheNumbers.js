function separateTheNumbers(str) {
    const len = str.length;

    for(let i = 1; i <= Math.floor(len / 2); i++) {
        let firstNum = BigInt(str.slice(0, i));
        let sequence = firstNum.toString();

        while(sequence.length < len) {
            firstNum++;
            sequence += firstNum.toString();
        }

        if(sequence === str) {
            return `YES ${str.slice(0, i)}`;
        }
    }

    return 'NO';
}

// Test cases
console.log(separateTheNumbers("1234")); // Output: "YES 1"
console.log(separateTheNumbers("91011")); // Output: "YES 9"
console.log(separateTheNumbers("99100")); // Output: "YES 99"
console.log(separateTheNumbers("101103")); // Output: "NO"
console.log(separateTheNumbers("010203")); // Output: "NO"
console.log(separateTheNumbers("13")); // Output: "NO"