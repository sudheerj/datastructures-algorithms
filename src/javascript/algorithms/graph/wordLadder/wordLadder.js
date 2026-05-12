/**
 * Word Ladder (LeetCode 127)
 *
 * Return the number of words in the shortest transformation sequence
 * from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Approach: BFS level-by-level
 * TC: O(n * m * 26)  SC: O(n)
 */

function wordLadder(beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);

    if (!wordSet.has(endWord)) return 0;

    const queue = [beginWord];
    let steps = 1;

    while (queue.length > 0) {
        const size = queue.length;

        for (let i = 0; i < size; i++) {
            const word = queue.shift();

            if (word === endWord) return steps;

            for (let j = 0; j < word.length; j++) {
                for (let c = 97; c <= 122; c++) { // 'a' to 'z'
                    const next = word.slice(0, j) + String.fromCharCode(c) + word.slice(j + 1);
                    if (wordSet.has(next)) {
                        queue.push(next);
                        wordSet.delete(next);
                    }
                }
            }
        }

        steps++;
    }

    return 0;
}

const testCases = [
    { begin: "hit", end: "cog", words: ["hot","dot","dog","lot","log","cog"], expected: 5, label: "hit→hot→dot→dog→cog" },
    { begin: "hit", end: "cog", words: ["hot","dot","dog","lot","log"],       expected: 0, label: "no path (cog not in list)" },
    { begin: "hot", end: "hot", words: ["hot"],                               expected: 1, label: "begin == end" },
    { begin: "ab",  end: "cb",  words: ["cb"],                                expected: 2, label: "one step away" },
    { begin: "hit", end: "xyz", words: ["hot","dot","dog"],                   expected: 0, label: "endWord not in list" },
];

testCases.forEach(({ begin, end, words, expected, label }) => {
    const result = wordLadder(begin, end, words);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${result} (expected ${expected})`);
});
