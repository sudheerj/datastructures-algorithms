function groupAnagramsWithMap(arr) {
    let anagramGroups = new Map();
    for(let str of arr) {
        let sortedString = str.split("").sort().join("");
        if(anagramGroups.has(sortedString)) {
            anagramGroups.get(sortedString).push(str);
        } else {
            anagramGroups.set(sortedString, [str]);
        }
    }
    return Array.from(anagramGroups.values());
}

function groupAnagramsWithObject(arr) {
    let anagramGroups = {};
    for(let str of arr) {
        let sortedString = str.split("").sort().join("");
        let group = anagramGroups[sortedString];
        if(group && group.length > 0) {
            anagramGroups[sortedString].push(str);
        } else {
            anagramGroups[sortedString] = [str];
        }
    }
    return Object.values(anagramGroups);
}

//Without sorting: TC(K * N) SC(K * N)
function groupAnagramsWithoutSorting(arr) {
    let anagramGroups = {};
    for(let str of arr) {

        let charCount = Array(26).fill(0);
        for(const ch of str.toLowerCase()){
            charCount[ch.charCodeAt(0)- 'a'.charCodeAt(0)]
        }
        let charCountkey = charCount.join("");
        if(!anagramGroups[charCountkey]) {
            anagramGroups[charCountkey] = [];
        }
        anagramGroups[charCountkey].push(str);
    }
    return Object.values(anagramGroups);
}

// Multiple Anagrams
console.log("Input: ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']");
console.log("Output1: ", groupAnagramsWithMap(['eat', 'tea', 'tan', 'ate', 'nat', 'bat']));
console.log("Output2: ", groupAnagramsWithoutSorting(['eat', 'tea', 'tan', 'ate', 'nat', 'bat']));
console.log("---------------");

// Mixed Case Anagrams
console.log("Input: ['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']");
console.log("Output1: ", groupAnagramsWithObject(['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']));
console.log("Output2: ", groupAnagramsWithoutSorting(['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']));

console.log("---------------");

// No Anagrams
console.log("Input: ['apple', 'orange', 'banana']");
console.log("Output1: ", groupAnagramsWithMap(['apple', 'orange', 'banana']));
console.log("Output2: ", groupAnagramsWithoutSorting(['apple', 'orange', 'banana']));

console.log("---------------");
