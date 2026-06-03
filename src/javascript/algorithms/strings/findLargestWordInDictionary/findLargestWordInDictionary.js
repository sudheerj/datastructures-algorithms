// Longest Word in Dictionary through Deleting (LC 524)
// TC: O(n * m)  SC: O(1)  n = dictionary size, m = length of s

/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {string}
 */
function findLargestWordInDictionary(s, dictionary) {
    let largestWord = "";

    for (const word of dictionary) {
        if (isSubsequence(s, word)) {
            if (
                word.length > largestWord.length ||
                (word.length === largestWord.length && word < largestWord)
            ) {
                largestWord = word;
            }
        }
    }

    return largestWord;
}

function isSubsequence(s, word) {
    let left = 0, right = 0;
    while (left < s.length && right < word.length) {
        if (s[left] === word[right]) right++;
        left++;
    }
    return right === word.length;
}

function runTests() {
    const tests = [
        { s: "abpcplea",               dictionary: ["ale","apple","monkey","plea"], expected: "apple" },
        { s: "abpcplea",               dictionary: ["a","b","c"],                  expected: "b"     },
        { s: "abpcplea",               dictionary: ["ale","plea"],                 expected: "plea"  },
        { s: "aewfafwafjlwajflwajflfa",dictionary: ["apple","ewaf"],               expected: "ewaf"  },
        { s: "z",                      dictionary: ["a","b"],                      expected: ""      },
        { s: "",                       dictionary: ["a"],                          expected: ""      },
    ];

    for (const { s, dictionary, expected } of tests) {
        const result = findLargestWordInDictionary(s, dictionary);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] s="${s}" result="${result}" expected="${expected}"`);
    }
}

runTests();
