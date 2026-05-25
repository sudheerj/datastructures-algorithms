package java1.algorithms.math.countPrimes;

public class CountPrimes {
    //Bruteforce(divisors upto square root of a number) TC: O(n sqaureRoot(n)) SC: O(1)
    private static int countPrimes1(int n) {
        int count = 0;
        for(int num=2; num<n; num++) {
            boolean isPrime = true;
            for(int i=2; i*i<=num; i++) {
                if(num%i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
            }
        }

        return count;
    }

    //Sieve of Eratosthenes TC: O(n log(log n)) SC: O(n)
    private static int countPrimes2(int n) {
        boolean[] sieve = new boolean[n];
        int count = 0;
        for(int num=2; num<n; num++) {
            if(!sieve[num]) {
                count++;

                for(long i= num * 1L * num; i<n; i+=num) {
                    sieve[(int)i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Approach 1: brute force
        int r1 = countPrimes1(10);
        System.out.println("Test 1a (brute) - n=10: " + (r1 == 4 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=4");
        int r2 = countPrimes1(0);
        System.out.println("Test 2a (brute) - n=0: " + (r2 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=0");
        int r3 = countPrimes1(2);
        System.out.println("Test 3a (brute) - n=2: " + (r3 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=0");
        int r4 = countPrimes1(20);
        System.out.println("Test 4a (brute) - n=20: " + (r4 == 8 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=8");
        int r5 = countPrimes1(100);
        System.out.println("Test 5a (brute) - n=100: " + (r5 == 25 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=25");

        // Approach 2: sieve
        int r6 = countPrimes2(10);
        System.out.println("Test 1b (sieve) - n=10: " + (r6 == 4 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=4");
        int r7 = countPrimes2(0);
        System.out.println("Test 2b (sieve) - n=0: " + (r7 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=0");
        int r8 = countPrimes2(2);
        System.out.println("Test 3b (sieve) - n=2: " + (r8 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=0");
        int r9 = countPrimes2(20);
        System.out.println("Test 4b (sieve) - n=20: " + (r9 == 8 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=8");
        int r10 = countPrimes2(100);
        System.out.println("Test 5b (sieve) - n=100: " + (r10 == 25 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=25");
    }
}
