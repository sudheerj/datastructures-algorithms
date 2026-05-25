// Approach 1: Brute force trial division — O(n√n) time, O(1) space
function countPrimes1(n) {
    let count = 0;
    for (let num = 2; num < n; num++) {
        let isPrime = true;
        for (let i = 2; i * i <= num; i++) {
            if (num % i === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) count++;
    }
    return count;
}

// Approach 2: Sieve of Eratosthenes — O(n log log n) time, O(n) space
function countPrimes2(n) {
    if (n < 2) return 0;
    const sieve = new Array(n).fill(false);
    let count = 0;
    for (let num = 2; num < n; num++) {
        if (!sieve[num]) {
            count++;
            for (let i = num * num; i < n; i += num) {
                sieve[i] = true;
            }
        }
    }
    return count;
}

// Approach 1: brute force
const r1 = countPrimes1(10);
console.log(`Test 1a (brute) - n=10: ${r1 === 4 ? '[PASS]' : '[FAIL]'} result=${r1} expected=4`);
const r2 = countPrimes1(0);
console.log(`Test 2a (brute) - n=0: ${r2 === 0 ? '[PASS]' : '[FAIL]'} result=${r2} expected=0`);
const r3 = countPrimes1(2);
console.log(`Test 3a (brute) - n=2: ${r3 === 0 ? '[PASS]' : '[FAIL]'} result=${r3} expected=0`);
const r4 = countPrimes1(20);
console.log(`Test 4a (brute) - n=20: ${r4 === 8 ? '[PASS]' : '[FAIL]'} result=${r4} expected=8`);
const r5 = countPrimes1(100);
console.log(`Test 5a (brute) - n=100: ${r5 === 25 ? '[PASS]' : '[FAIL]'} result=${r5} expected=25`);

// Approach 2: sieve
const r6 = countPrimes2(10);
console.log(`Test 1b (sieve) - n=10: ${r6 === 4 ? '[PASS]' : '[FAIL]'} result=${r6} expected=4`);
const r7 = countPrimes2(0);
console.log(`Test 2b (sieve) - n=0: ${r7 === 0 ? '[PASS]' : '[FAIL]'} result=${r7} expected=0`);
const r8 = countPrimes2(2);
console.log(`Test 3b (sieve) - n=2: ${r8 === 0 ? '[PASS]' : '[FAIL]'} result=${r8} expected=0`);
const r9 = countPrimes2(20);
console.log(`Test 4b (sieve) - n=20: ${r9 === 8 ? '[PASS]' : '[FAIL]'} result=${r9} expected=8`);
const r10 = countPrimes2(100);
console.log(`Test 5b (sieve) - n=100: ${r10 === 25 ? '[PASS]' : '[FAIL]'} result=${r10} expected=25`);
