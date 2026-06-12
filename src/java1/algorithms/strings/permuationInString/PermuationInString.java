package java1.algorithms.strings.permuationInString;

public class PermuationInString {
    private static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] count = new int[26];

        //count characters from s1
        for(char ch: s1.toCharArray()) {
            count[ch -'a']++;
        }

        int left = 0, needed = s1.length();
        for(int right=0; right<s2.length(); right++) {
            //Include right character in window
            if(count[s2.charAt(right) - 'a'] >0) {
                needed--;
            }
            count[s2.charAt(right)-'a']--;

            //Keep window length equals to s1.length
            if(right-left+1 > s1.length()) {
                if(count[s2.charAt(left) -'a'] >= 0) {
                    needed++;
                }

                count[s2.charAt(left)-'a']++;
                left++;
            }

            if(needed == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("adc", "dcda"));    // true
    }
}
