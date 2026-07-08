package java1.algorithms.greedy.minSuffixFlips;

public class MinSuffixFlips {
    //Greedy + state tracking TC: O(n) SC: O(1)
    private static int minFlips(String s) {
        int minFlips = 0, effectiveBit = '0';

        for(char ch: s.toCharArray()) {
            if(ch != effectiveBit) {
                minFlips++;
                effectiveBit = ch;
            }
        }

        return minFlips;
    }

    public static void main(String[] args) {

        String[] tests = {
            "10111",
            "101",
            "00000",
            "11111",
            "001011101",
            "0",
            "1",
            "010101",
            "110011",
            "100000"
        };

        for (String target : tests) {
            System.out.printf(
                "target = %-10s -> flips = %d%n",
                target,
                minFlips(target)
            );
        }
    }
}
