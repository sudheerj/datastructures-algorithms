package java1.algorithms.strings.goatLatin;

public class GoatLatin {
    //String parsing + per-token transformation TC: O(N + n^2) SC: O(N) N=Number of total chars n=Number of words
    private static String goatLatin(String str) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        String[] words = str.split(" ");
        for(int i=0; i<words.length; i++) {
            String word = words[i];

            //check for consonants
            if(vowels.indexOf(word.charAt(0)) == -1) {
                word = word.substring(1) + word.charAt(0);
            }

            word +="ma";

            for(int j=0; j<=i; j++) {
                word +="a";
            }

            result.append(word);

            if(i != words.length-1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Object[][] tests = {
            {"I speak Goat Latin",          "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"},
            {"The quick brown fox jumped",   "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa"},
            {"Each word starts anew",        "Eachmaa ordwmaaa tartssmaaaa anewmaaaaa"},
            {"I am",                         "Imaa ammaaa"},
            {"mad",                          "admmaa"},
        };

        for (Object[] t : tests) {
            String input    = (String) t[0];
            String expected = (String) t[1];
            String result   = goatLatin(input);
            String status   = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
