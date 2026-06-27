package java1.algorithms.binary.numberComplement;

public class NumberComplement {
    //Building mask of consequtive 1's TC: O(log n) SC: O(1)
    private static int findComplement(int num) {
        int mask = 1;

        while(mask < num) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }

    public static void main(String[] args) {
        int[] tests = {1, 2, 5, 10, 100};

        for (int num : tests) {
            int complement = findComplement(num);

            System.out.println(
                "num = " + num +
                ", binary = " + Integer.toBinaryString(num) +
                ", complement = " + complement +
                ", binary = " + Integer.toBinaryString(complement)
            );
        }
    }
}
