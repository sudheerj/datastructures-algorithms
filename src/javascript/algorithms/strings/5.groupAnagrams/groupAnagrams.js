//Character count:- TC:O(m * n) OC: O(m * n)
function groupAnagram1(strs) {
    let groupAnagramObj = {};

    for(let str of strs) {
        const charFrequency = new Array(26).fill(0);
        for(let i=0; i<str.length; i++) {
            const charIndex = str.charCodeAt(i) - 97;
            charFrequency[charIndex]++;
        }
        const key = charFrequency.join("#");
        if(groupAnagramObj[key]) {
            groupAnagramObj[key].push(str);
        } else {
            groupAnagramObj[key] = [str];
        }
    }
    return Object.values(groupAnagramObj);
}

//Using object and sort:- TC: O(m * n log n) OC: O(m * n)
function groupAnagram2(strs) {
    let groupAnagramObj = {};

    for(let str of strs) {
        const sortedString = str.split("").sort().join("");
        if(groupAnagramObj[sortedString]) {
            groupAnagramObj[sortedString].push(str);
        } else {
            groupAnagramObj[sortedString] = [str];
        }
    }
    return Object.values(groupAnagramObj);
}

let strs1 = ["eat","tea","tan","ate","nat","bat"];    
console.log(groupAnagram1(strs1));   
console.log(groupAnagram2(strs1));   

let strs2 = ["hello"];    
console.log(groupAnagram1(strs2));
console.log(groupAnagram2(strs2));