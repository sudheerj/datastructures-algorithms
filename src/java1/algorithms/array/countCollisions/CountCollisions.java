package countCollisions;

public class CountCollisions {
    //Array traversal TC: O(n) SC: O(1)
    private static int countCollisions(int[] positions, int[] speed, int pivot) {
        int collisions = 0;
        int pivotPos = positions[pivot];
        int pivotSpeed = speed[pivot];

        for(int i=0; i< positions.length; i++) {
            if(i == pivot) continue;

            //behind pivot position and speed > pivot
            if(positions[i] < pivotPos && speed[i] > pivotSpeed) {
                collisions++;
            }

            //ahead pivot position and speed < pivot
            if(positions[i] > pivotPos && speed[i] < pivotSpeed) {
                collisions++;
            }
        }

        return collisions;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] position1 = {2, 5, 8, 12, 15};
        int[] speed1 = {6, 4, 5, 3, 7};
        int pivot1 = 2;
        System.out.println(countCollisions(position1, speed1, pivot1)); // 2

        // Test Case 2
        int[] position2 = {1, 3, 6, 10};
        int[] speed2 = {1, 2, 3, 4};
        int pivot2 = 1;
        System.out.println(countCollisions(position2, speed2, pivot2)); // 0

        // Test Case 3
        int[] position3 = {1, 2, 3, 4, 5};
        int[] speed3 = {10, 9, 8, 7, 6};
        int pivot3 = 4;
        System.out.println(countCollisions(position3, speed3, pivot3)); // 4

        // Test Case 4
        int[] position4 = {10, 20, 30, 40};
        int[] speed4 = {5, 1, 10, 2};
        int pivot4 = 1;
        System.out.println(countCollisions(position4, speed4, pivot4)); // 1

        // Test Case 5
        int[] position5 = {1, 5, 9};
        int[] speed5 = {5, 5, 5};
        int pivot5 = 1;
        System.out.println(countCollisions(position5, speed5, pivot5)); // 0
    }
}
