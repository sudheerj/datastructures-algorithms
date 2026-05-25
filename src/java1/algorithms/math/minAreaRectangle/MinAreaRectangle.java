package java1.algorithms.math.minAreaRectangle;

import java.util.HashSet;
import java.util.Set;

public class MinAreaRectangle {
    private static int minAreaRectangle(int[][] points) {
        Set<String> set = new HashSet<>();
        int n = points.length;

        //store points
        for(int[] point: points) {
            set.add(point[0]+"#"+point[1]);
        }

        int minArea = Integer.MAX_VALUE;

        //Try other pairs as diagonal
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int x1= points[i][0], y1=points[i][1];
                int x2=points[j][0], y2=points[j][1];

                //skip same row or column(no rectangle)
                if(x1 == x2 || y1 == y2) continue;

                //look for other missing corners
                String p3= x1 +"#"+y2;
                String p4= x2 + "#"+y1;

                if(set.contains(p3) && set.contains(p4)) {
                    int area = Math.abs(x1-x2) * Math.abs(y1-y2);
                    minArea = Math.min(minArea, area);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[] args) {
        int[][] points1 = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        int r1 = minAreaRectangle(points1);
        System.out.println("Test 1 - single rectangle 2x2: " + (r1 == 4 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=4");

        int[][] points2 = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        int r2 = minAreaRectangle(points2);
        System.out.println("Test 2 - min rect is 1x2: " + (r2 == 2 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=2");

        int[][] points3 = {{0,0},{0,1},{1,0},{1,1}};
        int r3 = minAreaRectangle(points3);
        System.out.println("Test 3 - unit square: " + (r3 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=1");

        int[][] points4 = {{0,0},{0,2},{3,0},{3,2}};
        int r4 = minAreaRectangle(points4);
        System.out.println("Test 4 - 3x2 rectangle: " + (r4 == 6 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=6");

        int[][] points5 = {{1,1},{2,2},{3,1},{1,3}};
        int r5 = minAreaRectangle(points5);
        System.out.println("Test 5 - no valid rectangle: " + (r5 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=0");
    }
}
