public class ContainerWithMostWater {
    private static int mostWater(int[] heights) {
        int capacity = 0;
        int left = 0, right = heights.length-1;
        while(left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            capacity = Math.max(capacity, minHeight * (right - left));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return capacity;
    }

    public static void main(String[] args) {
        int[] waterHeights = {3,9,4,1,5,4,7,1,7};
        System.out.println(mostWater(waterHeights));
    }
}
