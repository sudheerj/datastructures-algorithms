# Approach 1: Brute force trial division — O(n√n) time, O(1) space
def count_primes1(n):
    count = 0
    for num in range(2, n):
        is_prime = True
        i = 2
        while i * i <= num:
            if num % i == 0:
                is_prime = False
                break
            i += 1
        if is_prime:
            count += 1
    return count


# Approach 2: Sieve of Eratosthenes — O(n log log n) time, O(n) space
def count_primes2(n):
    if n < 2:
        return 0
    sieve = [False] * n
    count = 0
    for num in range(2, n):
        if not sieve[num]:
            count += 1
            i = num * num
            while i < n:
                sieve[i] = True
                i += num
    return count


if __name__ == "__main__":
    # Approach 1: brute force
    r1 = count_primes1(10)
    print(f"Test 1a (brute) - n=10: {'[PASS]' if r1 == 4 else '[FAIL]'} result={r1} expected=4")
    r2 = count_primes1(0)
    print(f"Test 2a (brute) - n=0: {'[PASS]' if r2 == 0 else '[FAIL]'} result={r2} expected=0")
    r3 = count_primes1(2)
    print(f"Test 3a (brute) - n=2: {'[PASS]' if r3 == 0 else '[FAIL]'} result={r3} expected=0")
    r4 = count_primes1(20)
    print(f"Test 4a (brute) - n=20: {'[PASS]' if r4 == 8 else '[FAIL]'} result={r4} expected=8")
    r5 = count_primes1(100)
    print(f"Test 5a (brute) - n=100: {'[PASS]' if r5 == 25 else '[FAIL]'} result={r5} expected=25")

    # Approach 2: sieve
    r6 = count_primes2(10)
    print(f"Test 1b (sieve) - n=10: {'[PASS]' if r6 == 4 else '[FAIL]'} result={r6} expected=4")
    r7 = count_primes2(0)
    print(f"Test 2b (sieve) - n=0: {'[PASS]' if r7 == 0 else '[FAIL]'} result={r7} expected=0")
    r8 = count_primes2(2)
    print(f"Test 3b (sieve) - n=2: {'[PASS]' if r8 == 0 else '[FAIL]'} result={r8} expected=0")
    r9 = count_primes2(20)
    print(f"Test 4b (sieve) - n=20: {'[PASS]' if r9 == 8 else '[FAIL]'} result={r9} expected=8")
    r10 = count_primes2(100)
    print(f"Test 5b (sieve) - n=100: {'[PASS]' if r10 == 25 else '[FAIL]'} result={r10} expected=25")
