package java1.algorithms.misc.insertRemoveRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertRemoveRandom {
    private Map<Integer, Integer> numMap;
    private List<Integer> nums;
    private Random rand;

    InsertRemoveRandom() {
        numMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(numMap.containsKey(val)) return false;

        numMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!numMap.containsKey(val)) return false;

        int index = numMap.get(val);
        int last = nums.get(nums.size()-1);
        nums.set(index, last);
        numMap.put(last, index);
        nums.remove(nums.size()-1);
        numMap.remove(val);
        return true;
    }

    public int getRandomValue() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        InsertRemoveRandom obj = new InsertRemoveRandom();

        // Test 1: insert new element → true
        boolean r1 = obj.insert(1);
        System.out.println("Test 1 - insert(1) new element: " + (r1 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=true");

        // Test 2: insert duplicate → false
        boolean r2 = obj.insert(1);
        System.out.println("Test 2 - insert(1) duplicate: " + (!r2 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=false");

        // Test 3 & 4: insert more elements
        boolean r3 = obj.insert(2);
        System.out.println("Test 3 - insert(2): " + (r3 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=true");
        boolean r4 = obj.insert(3);
        System.out.println("Test 4 - insert(3): " + (r4 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=true");

        // Test 5: remove existing element → true
        boolean r5 = obj.remove(2);
        System.out.println("Test 5 - remove(2) exists: " + (r5 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=true");

        // Test 6: remove already-removed element → false
        boolean r6 = obj.remove(2);
        System.out.println("Test 6 - remove(2) already removed: " + (!r6 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=false");

        // Test 7: remove element that never existed → false
        boolean r7 = obj.remove(99);
        System.out.println("Test 7 - remove(99) never existed: " + (!r7 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=false");

        // Test 8: getRandomValue() returns element from current set {1, 3}
        java.util.Set<Integer> valid8 = new java.util.HashSet<>(java.util.Arrays.asList(1, 3));
        int r8 = obj.getRandomValue();
        System.out.println("Test 8 - getRandomValue() in {1,3}: " + (valid8.contains(r8) ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=one of {1,3}");

        // Test 9: getRandomValue() after insert; set becomes {1, 3, 4}
        obj.insert(4);
        java.util.Set<Integer> valid9 = new java.util.HashSet<>(java.util.Arrays.asList(1, 3, 4));
        int r9 = obj.getRandomValue();
        System.out.println("Test 9 - getRandomValue() in {1,3,4}: " + (valid9.contains(r9) ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=one of {1,3,4}");
    }
}
