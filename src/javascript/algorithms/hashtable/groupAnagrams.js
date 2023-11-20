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

// Multiple Anagrams
console.log("Input: ['eat', 'tea', 'tan', 'ate', 'nat', 'bat']");
console.log("Output: ", groupAnagramsWithObject(['eat', 'tea', 'tan', 'ate', 'nat', 'bat']));
console.log("---------------");

// Mixed Case Anagrams
console.log("Input: ['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']");
console.log("Output: ", groupAnagramsWithObject(['Eat', 'Tea', 'Tan', 'Ate', 'Nat', 'Bat']));
console.log("---------------");

// No Anagrams
console.log("Input: ['apple', 'orange', 'banana']");
console.log("Output: ", groupAnagramsWithMap(['apple', 'orange', 'banana']));
console.log("---------------");
