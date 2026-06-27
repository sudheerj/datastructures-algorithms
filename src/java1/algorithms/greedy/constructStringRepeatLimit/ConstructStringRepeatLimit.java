package java1.algorithms.greedy.constructStringRepeatLimit;

public class ConstructStringRepeatLimit {
    // Greedy + frequency counting TC: O(n) SC: O(26) ~O(1)
    private static String repeatLimitedString(String s, int repeatLimit) {
        int[] freqCount = new int[26];

        //count frequency
        for(char ch: s.toCharArray()) {
            freqCount[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while(true) {
            //Find the largest available character

            int large = 25;

            while(large >=0 && freqCount[large] == 0) {
                large--;
            }

            //if no letters left
            if(large == -1) break;

            int use = Math.min(freqCount[large], repeatLimit);

            //Add it at most repeatLimit times
            for(int i=0; i<use; i++) {
                sb.append((char)('a'+large));
            }

            freqCount[large] -= use;

            //if all used
            if(freqCount[large] == 0) {
                continue;
            }

            //Find next smaller character
            int small = large -1;

            while(small >=0 && freqCount[small] == 0) {
                small--;
            }

            //cannot break the sequency anymore
            if(small == -1) {
                break;
            }

            //Add one small character
            sb.append((char)('a'+small));
            freqCount[small]--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc", 3)); // zzcccac
        System.out.println(repeatLimitedString("aababab", 2)); // bbabaa
        System.out.println(repeatLimitedString("zzzz", 2));    // zz
    }

}
