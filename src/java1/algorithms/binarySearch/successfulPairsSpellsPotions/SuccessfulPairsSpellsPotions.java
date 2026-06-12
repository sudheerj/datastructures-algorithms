package java1.algorithms.binarySearch.successfulPairsSpellsPotions;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {
    // Sorting on potions + binary search on potions TC: O(n * log m) SC: O(n) n = number of spells, m = number of potions
    private int[] successfulPairsSpellsPotions(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int[] result = new int[n];

        
        for(int i=0; i<spells.length; i++) {
            int firstValid = n;

            int left = 0, right = n-1;
            while(left <= right) {
                int mid = left + (right-left)/2;

                long product = spells[i] * potions[mid];
                if(product >= success) {
                    firstValid = mid;
                    right = mid-1; // look for left part
                }  else {
                    left = mid +1;
                }
            }

            result[i] = firstValid;
        }

        return result;
    }
}
