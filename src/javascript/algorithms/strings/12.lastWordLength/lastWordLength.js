function lengthOfLastWord(str){
    let i = str.length-1, length = 0;

    while(str[i] === ' '){
        i--;
    }

    while(i >=0 && str[i] !== ' '){
        length++;
        i--;
    }

    return length;
}

let str1 = "Welcome to DSA";
let str2 = " My pet is fluffy  ";

console.log(lengthOfLastWord(str1));
console.log(lengthOfLastWord(str2));