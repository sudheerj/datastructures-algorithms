// String parsing + per-token transformation  TC: O(N + n^2) SC: O(N)
const VOWELS = new Set(['a','e','i','o','u','A','E','I','O','U']);

function goatLatin(s) {
    return s.split(' ').map((word, i) => {
        if (!VOWELS.has(word[0])) {
            word = word.slice(1) + word[0];
        }
        return word + 'ma' + 'a'.repeat(i + 1);
    }).join(' ');
}

function runTests() {
    const tests = [
        { s: "I speak Goat Latin",        expected: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa" },
        { s: "The quick brown fox jumped", expected: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa" },
        { s: "Each word starts anew",      expected: "Eachmaa ordwmaaa tartssmaaaa anewmaaaaa" },
        { s: "I am",                       expected: "Imaa ammaaa" },
        { s: "mad",                        expected: "admmaa" },
    ];

    tests.forEach(({ s, expected }) => {
        const result = goatLatin(s);
        const status = result === expected ? "PASS" : "FAIL";
        console.log(`[${status}] result=${result} expected=${expected}`);
    });
}

runTests();
