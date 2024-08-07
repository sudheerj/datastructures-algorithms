package java1.algorithms.strings.greatestCommonDivisor;

public class GreatestCommonDivisor {
    //1. GCD using Euclidean's algorithm TC: O(n+m)(i.e, O(n + m + log(min(n, m)))), SC: O(n+m)
    private static String gcdOfStrings1(String str1, String str2) {
        if(!((str1+str2).equals(str2+str1))) return "";

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);

    }

    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }

    // 2. BrutForce (Time complexity: O(min(m,n) . (m+n)), Space complexity: O(min(m,n)))
    private static String gcdOfStrings2(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();

        for(int i = Math.min(l1, l2); i >=1; i++){
            if(hasGcdString(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }

        return "";
    }

    private static boolean hasGcdString(String str1, String str2, int k){
        int l1 = str1.length(), l2 = str2.length();

        if(l1%k > 0 || l2%k > 0){
            return false;
        }

        int f1 = l1/k, f2 = l2/k;
        String base = str1.substring(0, k);

        return base.repeat(f1) == str1 && base.repeat(f2) == str2;
    }
    
    public static void main(String[] args) {
        System.out.println(gcdOfStrings1("AB", "AB"));
        System.out.println(gcdOfStrings1("ABCABCABC", "ABCABC"));
        System.out.println(gcdOfStrings1("ABABAB", "AB"));

        System.out.println(gcdOfStrings2("AB", "AB"));
        System.out.println(gcdOfStrings2("ABCABCABC", "ABCABC"));
        System.out.println(gcdOfStrings2("ABABAB", "AB"));
    }
}

