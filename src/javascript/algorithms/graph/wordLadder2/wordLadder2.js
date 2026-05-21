// BFS (shortest paths) + DFS backtracking => TC: O(N*M*26) SC: O(N*M)
function findLadders(beginWord, endWord, wordList) {
    const result = [];
    const wordSet = new Set(wordList);

    if (!wordSet.has(endWord)) return result;

    const parents = new Map();
    const visited = new Set([beginWord]);
    let queue = [beginWord];
    let found = false;

    while (queue.length && !found) {
        const levelVisited = new Set();
        const nextQueue = [];

        for (const word of queue) {
            const arr = word.split('');
            for (let j = 0; j < arr.length; j++) {
                const original = arr[j];
                for (let c = 97; c <= 122; c++) {
                    arr[j] = String.fromCharCode(c);
                    const nextWord = arr.join('');

                    if (!wordSet.has(nextWord)) continue;

                    if (!visited.has(nextWord)) {
                        nextQueue.push(nextWord);
                        levelVisited.add(nextWord);
                    }

                    if (!parents.has(nextWord)) parents.set(nextWord, []);
                    parents.get(nextWord).push(word);

                    if (nextWord === endWord) found = true;
                }
                arr[j] = original;
            }
        }

        for (const w of levelVisited) visited.add(w);
        queue = nextQueue;
    }

    function dfs(word, path) {
        if (word === beginWord) {
            result.push([...path].reverse());
            return;
        }
        if (!parents.has(word)) return;
        for (const parent of parents.get(word)) {
            path.push(parent);
            dfs(parent, path);
            path.pop();
        }
    }

    dfs(endWord, [endWord]);
    return result;
}

const testCases = [
    {
        beginWord: 'hit', endWord: 'cog',
        wordList: ['hot','dot','dog','lot','log','cog'],
        expected: '[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]'
    },
    {
        beginWord: 'hit', endWord: 'hot',
        wordList: ['hot'],
        expected: '[["hit","hot"]]'
    },
    {
        beginWord: 'hit', endWord: 'cog',
        wordList: ['hot','dot','dog','lot','log'],
        expected: '[]'
    },
    {
        beginWord: 'abc', endWord: 'xyz',
        wordList: ['def','ghi','xyz'],
        expected: '[]'
    },
    {
        beginWord: 'a', endWord: 'c',
        wordList: ['a','b','c'],
        expected: '[["a","c"]]'
    },
];

testCases.forEach(({ beginWord, endWord, wordList, expected }, i) => {
    const result = findLadders(beginWord, endWord, wordList);
    console.log(`Test ${i + 1}: Result=${JSON.stringify(result)}, Expected=${expected}`);
});
