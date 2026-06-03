package rangeProductQueriesOfPowers;

import java.util.ArrayList;
import java.util.List;

//Extract bit sets to find powers of 2 and 
public class RangeProductQueriesOfPowers {
    private final int MOD = 1_000_000_007;
    private int[] productQueries(int n, int[][] queries){
        //Extract powers of 2 up to n
        List<Integer> powers = new ArrayList<>();
        for(int bit=0; bit<31; bit++) {
            if((n & (1<<bit)) !=0) {
                powers.add(bit);
            }
        }

        //Apply range product of queries
        List<Integer> result = new ArrayList<>();
        for(int[] query: queries) {
            int left = query[0];
            int right = query[1];

            int product = 1;

            for(int i=left; i<=right; i++) {
                product = product * powers.get(i) % MOD;
            }
            result.add(product);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
