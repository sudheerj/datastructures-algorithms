package containerWithMostWater;
public class ContainerWithMostWater {
    private static int mostWater(int[] heights) {
        int maxCapacity = 0;
        int left = 0, right = heights.length-1;
        while(left < right) {
            int currentCapacity = (right - left) * Math.min(heights[left], heights[right]);
            maxCapacity = Math.max(maxCapacity, currentCapacity );
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxCapacity;
    }

    public static void main(String[] args) {
        int[] waterHeights1 = {3,9,4,1,5,4,7,1,7};
        System.out.println(mostWater(waterHeights1));

        int[] waterHeights2 = {1,1};
        System.out.println(mostWater(waterHeights2));
    }
}
