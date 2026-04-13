package java1.algorithms.strings.longestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interspecies", "interstellar", "interstate"},
            {"a"},
            {"", "b"},
            {"abc", "abc", "abc"},
            {"ab", "a"},
            {"cir", "car"}
        };
        String[] expected = {"fl", "", "inters", "a", "", "abc", "a", "c"};

        for (int i = 0; i < testCases.length; i++) {
            String result = obj.longestCommonPrefix(testCases[i]);
            System.out.println(java.util.Arrays.toString(testCases[i]) + " => \"" + result + "\"" + (result.equals(expected[i]) ? " ✓" : " ✗ (expected \"" + expected[i] + "\")"));
        }
    }

    private String longestCommonPrefix(String[] strs) {

        for(int i=0; i< strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for(int j=1; j< strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
