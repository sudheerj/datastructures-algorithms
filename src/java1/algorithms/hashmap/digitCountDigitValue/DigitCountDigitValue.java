package java1.algorithms.hashmap.digitCountDigitValue;

public class DigitCountDigitValue {
    //Frequency counting TC: O(n) SC: O(1)
    private static boolean digitCount(String num) {
        int[] freqCount = new int[10];

        //frequency count of each digit
        for(char ch: num.toCharArray()) {
            freqCount[ch - '0']++;
        }

        //verify digit count
        for(int i=0; i<num.length(); i++) {
            if(freqCount[i] != num.charAt(i) - '0') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] tests = {
            "1210",
            "030",
            "2020",
            "3211000",
            "22",
            "0"
        };

        for (String test : tests) {
            System.out.println(
                "num = " + test +
                " -> " + digitCount(test)
            );
        }
    }
}
