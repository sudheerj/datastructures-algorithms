package java1.algorithms.strings.backspaceStringCompare;

import java.util.Stack;

public class BackspaceStringCompare {    
    //Two pointers + Reverse traversal + Skip count TC: O(n+m ) SC: O(1)
    private boolean backspaceCompare1(String s, String t) {
        int i = s.length()-1;
        int j = t.length() -1;

        while(i >= 0 || j>=0) {
            i = nextCharIndex(s, i);
            j = nextCharIndex(t, j);

            if(i < 0 || j < 0) {
                return i == j;
            }

            if(s.charAt(i) != t.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    private int nextCharIndex(String str, int index) {
        int skip = 0;

        while(index >=0) {
            char ch = str.charAt(index);

            if(ch == '#') {
                skip++;
            } else if(skip >0){
                skip--;
            } else {
                return index;
            }

            index--;
        }

        return -1;
    }

    //Using stack to remove characters before backspace TC: O(n+m) SC: O(n+m)
    private boolean backspaceCompare2(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(ch == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
            BackspaceStringCompare obj = new BackspaceStringCompare();
            String[][] testCases = {
                {"ab#c", "ad#c"},
                {"ab##", "c#d#"},
                {"a#c", "b"},
                {"a##c", "#a#c"},
                {"xywrrmp", "xywrrmu#p"},
                {"", ""},
                {"a#", ""},
                {"abc#d", "abzz##d"},
                {"bxj##tw", "bxo#j##tw"},
                {"nzp#o#g", "b#nzp#o#g"}
            };
            boolean[] expected = {true, true, false, true, true, true, true, true, true, true};
            for (int i = 0; i < testCases.length; i++) {
                String s = testCases[i][0];
                String t = testCases[i][1];
                boolean exp = expected[i];
                boolean result = obj.backspaceCompare1(s, t);
                String status = result == exp ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %b | Expected: %b | %s\n", i+1, result, exp, status);
            }
    }
}
