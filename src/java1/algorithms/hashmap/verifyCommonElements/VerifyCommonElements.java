package java1.algorithms.hashmap.verifyCommonElements;

import java.util.HashMap;
import java.util.Map;

public class VerifyCommonElements {
    private static boolean isCommonElementExists(int[] arr1, int[] arr2){
        Map<Integer, Boolean> commonMap = new HashMap<>();

        for (int num : arr1) {
            commonMap.put(num, true);
        }

        for (int num : arr2) {
            if(commonMap.get(num) != null) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 43, 9, 7};
        int[] arr2 = new int[]{17, 33, 10, 2};
        int[] arr3 = new int[]{1, 2, 3, 4};
        int[] arr4 = new int[]{5, 6, 7};
        System.out.println(isCommonElementExists(arr1, arr2));
        System.out.println(isCommonElementExists(arr1, arr2));
        System.out.println(isCommonElementExists(arr3, arr4));
        System.out.println(isCommonElementExists(arr3, arr4));
    }
}
