package java1.algorithms.strings.minSwapsToMakeStringsEqual;

public class MinSwapsToMakeStringsEqual {
    private int minSwaps(String s1, String s2) {
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
}
