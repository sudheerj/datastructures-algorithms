package java1.algorithms.strings.addSpacesToString;

public class AddSpacesToString {
    //Two pointers TC: O(n) SC: O(n)
    private static String addSpaces(String str, int[] spaces) {
        int j=0; //pointer to spaces
        StringBuilder result = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            if(j< spaces.length && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(str.charAt(i));
        }

        return result.toString();
    }

    //Bruteforce solution TC: O(n^k) SC: O(n) k=number of spaces
    private static String addNewSpaces1(String str, int[] spaces) {
        String result = str;

        int shift = 0; //track how string grows
        for(int space: spaces) {
            int index = space + shift;
            result = result.substring(0, index) + " " +result.substring(index);

            shift++; //string length increased by one.
        }

        return result; 
    }

    public static void main(String[] args) {
        Object[][] tests = {
            {"LeetcodeHelpsMeLearn", new int[]{8, 13, 15}, "Leetcode Helps Me Learn"},
            {"icodeinpython",        new int[]{1, 6, 8},    "i code in python"},
            {"spacing",              new int[]{},            "spacing"},
            {"ab",                   new int[]{1},           "a b"},
            {"hello",                new int[]{1, 2, 3, 4},  "h e l l o"},
        };

        for (Object[] t : tests) {
            String input    = (String) t[0];
            int[]  spaces   = (int[])  t[1];
            String expected = (String) t[2];
            String result1  = addSpaces(input, spaces);
            String result2  = addNewSpaces1(input, spaces);
            String status1  = result1.equals(expected) ? "PASS" : "FAIL";
            String status2  = result2.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status1 + "] twoPointers result=" + result1 + " expected=" + expected);
            System.out.println("[" + status2 + "] bruteForce  result=" + result2 + " expected=" + expected);
        }
    }
}
