package java1.algorithms.strings.countValidSpaceDelimitedWords;

public class CountValidSpaceDelimitedWords {
    //String traversal TC: O(n) SC: O(n)
    public static countValidWords(String txt) {
        String[] words = txt.trim().split("\\s+");
        int count = 0;

        for(String word: words) {
            boolean valid = true;

            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);

                if(Character.isLetter(ch)) {
                    continue;
                }

                if(i == word.length()-1 && (ch == '.' || ch == ',' || ch == '?' || ch == '!')) {
                    continue;
                }

                valid = false;
                break;
            }

            if(valid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}
