**Problem statement:**
Given an integer `n`, return the count of prime numbers strictly less than `n`.

## Examples:
Input: n = 10
Output: 4 (primes: 2, 3, 5, 7)

Input: n = 20
Output: 8 (primes: 2, 3, 5, 7, 11, 13, 17, 19)

**Algorithmic Steps**

Approach 1 — Brute Force (trial division):
1. For each `num` from 2 to `n-1`, assume it is prime.
2. Check divisors `i` from 2 while `i*i <= num`. If `num % i == 0`, mark as not prime and break.
3. Increment count for each prime found.

Approach 2 — Sieve of Eratosthenes:
1. Create a boolean array `sieve` of size `n`, all initialised to false (= potentially prime).
2. For each `num` from 2 to `n-1`: if `sieve[num]` is false, it is prime — increment count.
3. Mark all multiples of `num` starting from `num²` as true (= composite).
4. Return count.

**Time and Space complexity:**
| | Time | Space |
|---|---|---|
| Approach 1 (brute force) | O(n√n) | O(1) |
| Approach 2 (sieve) | O(n log log n) | O(n) |
