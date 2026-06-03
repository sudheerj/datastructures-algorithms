// Koko Eating Bananas (LeetCode 875)
// Binary Search and Brute Force solutions
function minEatingSpeedBinarySearch(piles, h) {
    let left = 1, right = Math.max(...piles), ans = right;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let hours = piles.reduce((acc, pile) => acc + Math.ceil(pile / mid), 0);
        if (hours <= h) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return ans;
}

function minEatingSpeedBruteForce(piles, h) {
    let maxPile = Math.max(...piles);
    for (let k = 1; k <= maxPile; k++) {
        let hours = piles.reduce((acc, pile) => acc + Math.ceil(pile / k), 0);
        if (hours <= h) return k;
    }
    return maxPile;
}

// Test harness
const testPiles = [
    [3, 6, 7, 11],
    [30, 11, 23, 4, 20],
    [30, 11, 23, 4, 20]
];
const testH = [8, 5, 6];
const expected = [4, 30, 23];

console.log("Testing Koko Eating Bananas (Binary Search):");
for (let i = 0; i < testPiles.length; i++) {
    const res = minEatingSpeedBinarySearch(testPiles[i], testH[i]);
    console.log((res === expected[i] ? "PASS" : "FAIL") + ` Test ${i+1}: got ${res}, expected ${expected[i]}`);
}

console.log("\nTesting Koko Eating Bananas (Brute Force):");
for (let i = 0; i < testPiles.length; i++) {
    const res = minEatingSpeedBruteForce(testPiles[i], testH[i]);
    console.log((res === expected[i] ? "PASS" : "FAIL") + ` Test ${i+1}: got ${res}, expected ${expected[i]}`);
}
