package java1.algorithms.strings.lastWordLength;

public class LastWordLength {
    private static int lengthOfLastWord(String str){
        int i = str.length()-1, length = 0;

        while(str.charAt(i) == ' '){
            i--;
        }

        while (i >= 0 && str.charAt(i) != ' ') {
            i--;
            length++;
        }

        return length;
    }
    public static void main(String[] args) {
        String str1 = "Welcome to DSA";
        String str2 = " My pet is fluffy  ";

        System.out.println(lengthOfLastWord(str1));
        System.out.println(lengthOfLastWord(str2));
    }
}
