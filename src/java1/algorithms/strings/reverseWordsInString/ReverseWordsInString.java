package java1.algorithms.strings.reverseWordsInString;

public class ReverseWordsInString {

    //Two pointer array reversal TC: O(n) SC: O(n)
    private static String reverseWordsInString1(String str) {
        String[] words = str.trim().split("\\s+");
        int i = 0, j = words.length - 1;

        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        return String.join(" ", words);
    }

    //String builder array reversal TC: O(n) SC: O(n)
    private static String reverseWordsInString2(String str) {
        String[] words = str.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i != 0){
                sb.append(" ");               
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "It is fun to learn DSA";
        String str2 = "  hello DSA  ";
        System.out.println(reverseWordsInString1(str1));
        System.out.println(reverseWordsInString1(str2));

        System.out.println(reverseWordsInString2(str1));
        System.out.println(reverseWordsInString2(str2));
    }
}
