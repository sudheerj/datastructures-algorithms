package java1.algorithms.strings.removeComments;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    // TC: O(n * L) SC: O(n * L) n=lines, L=line length
    public static List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlock = false;

        for (String line : source) {
            int i = 0;

            if (!isBlock) {
                sb.setLength(0);
            }

            while (i < line.length()) {
                if (!isBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break; // rest of line is a line comment
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        isBlock = true;
                        i += 2;
                    } else {
                        sb.append(line.charAt(i));
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        isBlock = false;
                        i += 2;
                    } else {
                        i++; // skip characters inside block comment
                    }
                }
            }

            if (!isBlock && sb.length() > 0) {
                result.add(sb.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                // Test 1: line comment strips rest of line
                new Object[] {
                        new String[] { "int x = 1; // this is a comment", "int y = 2;" },
                        List.of("int x = 1; ", "int y = 2;")
                },
                // Test 2: block comment spanning multiple lines
                new Object[] {
                        new String[] { "/* Test program */", "int main()", "{",
                                "  // variable declaration", "int a, b, c;",
                                "/* This is a test", "   multiline  ", "   comment for",
                                "   testing */", "int d = b + c;", "}" },
                        List.of("int main()", "{", "int a, b, c;", "int d = b + c;", "}")
                },
                // Test 3: block comment inline, code before and after
                new Object[] {
                        new String[] { "a/*comment*/b", "c" },
                        List.of("ab", "c")
                },
                // Test 4: full-line comment — empty after removal, excluded
                new Object[] {
                        new String[] { "// full line comment", "code line" },
                        List.of("code line")
                },
                // Test 5: no comments — source unchanged
                new Object[] {
                        new String[] { "int a = 1;", "int b = 2;" },
                        List.of("int a = 1;", "int b = 2;")
                },
                // Test 6: block open and close on same line with surrounding code
                new Object[] {
                        new String[] { "before/*skip*/after" },
                        List.of("beforeafter")
                },
        };

        for (int t = 0; t < tests.length; t++) {
            String[] source = (String[]) tests[t][0];
            @SuppressWarnings("unchecked")
            List<String> expected = (List<String>) tests[t][1];
            List<String> result = removeComments(source);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
