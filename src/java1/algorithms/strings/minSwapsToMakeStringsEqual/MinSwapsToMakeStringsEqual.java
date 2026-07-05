package java1.algorithms.strings.minSwapsToMakeStringsEqual;

public class MinSwapsToMakeStringsEqual {
    private static int minSwaps(String s1, String s2) {
        int xy = 0, yx = 0;

        //count mismatches
        for(int i=0; i<s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if(a == 'x' && b =='y') {
                xy++;
            }

            if(a == 'y' && b == 'x') {
                yx++;
            }
        }

        //If total mismatches are odd, it is impossible
        if((xy+yx)%2 != 0) return -1;

        return xy/2+yx/2+(xy%2)*2;
    }

    public static void main(String[] args) {

        String[][] tests = {
                {"xx", "yy"},     // 1 swap
                {"xy", "yx"},     // 2 swaps
                {"xx", "xx"},     // 0
                {"xyxy", "yxyx"}, // 2
                {"xxyy", "yyxx"}, // 2
                {"xxxx", "yyyy"}, // 2
                {"xyyy", "yxyx"}, // 2
                {"xy", "xy"},     // 0
                {"xxyyxy", "yyxxyx"} // 3
        };

        System.out.println("Minimum Swaps to Make Strings Equal:");
        System.out.println("====================================");

        for (int i = 0; i < tests.length; i++) {
            String s1 = tests[i][0];
            String s2 = tests[i][1];

            int result = minSwaps(s1, s2);

            System.out.printf("Test %2d | s1=%-10s s2=%-10s | swaps=%d%n",
                    i + 1, s1, s2, result);
        }
    }
}
