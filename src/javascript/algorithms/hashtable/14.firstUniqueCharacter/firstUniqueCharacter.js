function firstUniqChar(str){
    const charCount = new Map();

    for (const ch of str) {
        charCount.set(ch, (charCount.get(ch) || 0) +1);
    }

    for (let i = 0; i < str.length; i++) {
        if(charCount.get(str[i]) === 1) {
            return i;
        }        
    }

    return -1;
}

const str1 = "zeep";
const str2 = "mama";

console.log(firstUniqChar(str1));
console.log(firstUniqChar(str2));