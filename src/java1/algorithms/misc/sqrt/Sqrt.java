package java1.algorithms.misc.sqrt;

public class Sqrt {
    public static void main(String[] args) {
        int[] testCases = {0, 1, 4, 8, 9, 15, 16, 25, 26, 100, 101};
        System.out.println("Testing sqrt1:");
        for (int n : testCases) {
            System.out.printf("sqrt1(%d) = %d\n", n, sqrt1(n));
        }
        System.out.println("\nTesting sqrt2:");
        for (int n : testCases) {
            System.out.printf("sqrt2(%d) = %d\n", n, sqrt2(n));
        }
    }

    //Binary search approach: TC: O(log n)), SC:O(1)
    private static int sqrt1(int num) {
        if(num <2) return num;

        int left = 1, right = num/2;
        int result = 0;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(mid <= num/mid) {
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return result;
    }

    //Brute force approach: TC: O(sqrt(n)), SC:O(1)
    private static int sqrt2(int num) {
        if(num <2) return num;

        int result = 0;

        for(int i=1; i<=num/2; i++) {
            if(i *i > num) {
                return result;
            }
            result = i;
        }

        return result;
    }
}
