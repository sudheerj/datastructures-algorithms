import java.util.Arrays;

// TC:O(mlog m + n) SC: O(n)
public class RedistributionIntoBoxes {
    public static void main(String[] args) {
        // Test 1: General case
        System.out.println("Test 1: " + minBoxes(new int[] { 1, 3, 2 }, new int[] { 4, 3, 1, 5, 2 })); // 2

        // Test 2: Single apple pack, single box
        System.out.println("Test 2: " + minBoxes(new int[] { 5 }, new int[] { 5 })); // 1

        // Test 3: All apples fit in one large box
        System.out.println("Test 3: " + minBoxes(new int[] { 2, 3, 1 }, new int[] { 10, 1, 1 })); // 1

        // Test 4: Each box holds exactly one apple pack
        System.out.println("Test 4: " + minBoxes(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 })); // 3

        // Test 5: Need all boxes
        System.out.println("Test 5: " + minBoxes(new int[] { 5, 5, 5 }, new int[] { 5, 5, 5 })); // 3

        // Test 6: Boxes much larger than needed
        System.out.println("Test 6: " + minBoxes(new int[] { 1 }, new int[] { 100, 50, 25 })); // 1
    }

    private static int minBoxes(int[] apples, int[] capacity) {
        int total = 0;
        for (int count : apples) {
            total += count;
        }
        Arrays.sort(capacity);

        int minBoxes = 0;
        int i = capacity.length - 1;

        while (total > 0) {
            total -= capacity[i];
            minBoxes++;
            i--;
        }

        return minBoxes;
    }
}
