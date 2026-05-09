package java1.algorithms.binarySearch.smallestDivisor;

public class SmallestDivisor {
    //TC: O(log max(nums) * n) TC: O(1)
    private static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;

        //Find the maximum for binary search upper bound
        for(int num: nums) {
            right = Math.max(right, num);
        }

        while(left <= right) {
            int divisor = left +(right-left)/2; //mid value
            int sum = 0;

            for(int num: nums) {
                sum += (num+divisor-1)/divisor; // or (int)Math.ceil((double)num/divisor)
            }

            if(sum <= threshold) {
                right = divisor-1;
            } else {
                left = divisor+1;
            }
        }

        return left;
    }

    //BrutForce TC: O(max(nums) * n) SC: O(1)
    private static int smallestDivisor1(int[] nums, int threshold) {
        int max = 0;

        for(int num: nums) {
            max = Math.max(max, num);
        }

        for(int divisor=1; divisor<=max; divisor++) {
            int sum = 0;

            for(int num: nums) {
                sum += (num+divisor-1)/divisor;
            }

            if(sum <= threshold) {
                return divisor;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        // Test 1: [1,2,5,9], threshold=6 → 5
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));           // 5
        System.out.println(smallestDivisor1(new int[]{1, 2, 5, 9}, 6));          // 5

        // Test 2: [2,3,5,7,11], threshold=11 → 3
        System.out.println(smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));      // 3
        System.out.println(smallestDivisor1(new int[]{2, 3, 5, 7, 11}, 11));     // 3

        // Test 3: [19], threshold=5 → 4
        System.out.println(smallestDivisor(new int[]{19}, 5));                   // 4
        System.out.println(smallestDivisor1(new int[]{19}, 5));                  // 4

        // Test 4: [1,2,3], threshold=6 → 1
        System.out.println(smallestDivisor(new int[]{1, 2, 3}, 6));              // 1
        System.out.println(smallestDivisor1(new int[]{1, 2, 3}, 6));             // 1

        // Test 5: [44,22,33,11,1], threshold=5 → 44
        System.out.println(smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5));    // 44
        System.out.println(smallestDivisor1(new int[]{44, 22, 33, 11, 1}, 5));   // 44

        // Test 6: [1], threshold=1 → 1
        System.out.println(smallestDivisor(new int[]{1}, 1));                    // 1
        System.out.println(smallestDivisor1(new int[]{1}, 1));                   // 1

        // Test 7: [1000000], threshold=1 → 1000000
        System.out.println(smallestDivisor(new int[]{1000000}, 1));              // 1000000
        System.out.println(smallestDivisor1(new int[]{1000000}, 1));             // 1000000
    }
}
