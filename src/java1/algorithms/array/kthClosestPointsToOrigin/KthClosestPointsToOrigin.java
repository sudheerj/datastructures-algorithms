package java1.algorithms.array.kthClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthClosestPointsToOrigin {

    // Approach 1: Sorting TC: O(n log n) SC: O(log n)
    private static int[][] kthClosestPointsToOrigin1(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    // Approach 2: Max Heap size k TC: O(n log k) SC: O(k)
    private static int[][] kthClosestPointsToOrigin2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p, q) -> Long.compare((long) (q[0] * q[0] + q[1] * q[1]), (long) (p[0] * p[0] + p[1] * p[1])));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = pq.poll();
        return result;
    }

    // Approach 3: Min Heap TC: O(n + k log n) SC: O(n)
    private static int[][] kthClosestPointsToOrigin3(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p, q) -> Long.compare((long) (p[0] * p[0] + p[1] * p[1]), (long) (q[0] * q[0] + q[1] * q[1])));
        for (int[] point : points)
            pq.offer(point);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = pq.poll();
        return result;
    }

    // Approach 4: QuickSelect TC: O(n) avg, O(n²) worst SC: O(log n) recursion
    // stack
    private static int[][] kthClosestPointsToOrigin4(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private static void quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right)
            return;
        int pivotIndex = partition(points, left, right);
        if (pivotIndex == k)
            return;
        if (pivotIndex < k)
            quickSelect(points, pivotIndex + 1, right, k);
        else
            quickSelect(points, left, pivotIndex - 1, k);
    }

    private static int partition(int[][] points, int left, int right) {
        int pivot = distance(points[right]);
        int i = left;
        for (int j = left; j < right; j++) {
            if (distance(points[j]) <= pivot) {
                int[] tmp = points[i];
                points[i] = points[j];
                points[j] = tmp;
                i++;
            }
        }
        int[] tmp = points[i];
        points[i] = points[right];
        points[right] = tmp;
        return i;
    }

    private static int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    private static boolean equals(int[][] a, int[][] b) {
        if (a.length != b.length)
            return false;
        int[][] ac = a.clone(), bc = b.clone();
        Arrays.sort(ac, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        Arrays.sort(bc, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        for (int i = 0; i < ac.length; i++) {
            if (!Arrays.equals(ac[i], bc[i]))
                return false;
        }
        return true;
    }

    private static String fmt(int[][] pts) {
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j < pts.length; j++) {
            if (j > 0)
                sb.append(",");
            sb.append(Arrays.toString(pts[j]));
        }
        return sb.append("]").toString();
    }

    private static int[][] copy(int[][] pts) {
        int[][] c = new int[pts.length][2];
        for (int i = 0; i < pts.length; i++)
            c[i] = pts[i].clone();
        return c;
    }

    public static void main(String[] args) {
        int[][][] allPoints = {
                { { 1, 3 }, { -2, 2 } },
                { { 3, 3 }, { 5, -1 }, { -2, 4 } },
                { { 0, 1 }, { 1, 0 } },
                { { 1, 0 } },
                { { -5, 4 }, { 0, 0 }, { 1, 1 } },
        };
        int[] ks = { 1, 2, 2, 1, 2 };
        int[][][] expecteds = {
                { { -2, 2 } },
                { { 3, 3 }, { -2, 4 } },
                { { 0, 1 }, { 1, 0 } },
                { { 1, 0 } },
                { { 0, 0 }, { 1, 1 } },
        };

        String[] labels = {
                "kthClosestPointsToOrigin1 (sorting)",
                "kthClosestPointsToOrigin2 (max heap)",
                "kthClosestPointsToOrigin3 (min heap)",
                "kthClosestPointsToOrigin4 (quickselect)"
        };
        for (int approach = 0; approach < 4; approach++) {
            System.out.println("--- " + labels[approach] + " ---");
            for (int i = 0; i < ks.length; i++) {
                int[][] pts = copy(allPoints[i]);
                int[][] result = switch (approach) {
                    case 0 -> kthClosestPointsToOrigin1(pts, ks[i]);
                    case 1 -> kthClosestPointsToOrigin2(pts, ks[i]);
                    case 2 -> kthClosestPointsToOrigin3(pts, ks[i]);
                    default -> kthClosestPointsToOrigin4(pts, ks[i]);
                };
                boolean pass = equals(result, expecteds[i]);
                System.out.println(
                        "[" + (pass ? "PASS" : "FAIL") + "] result=" + fmt(result) + " expected=" + fmt(expecteds[i]));
            }
        }
    }
}
