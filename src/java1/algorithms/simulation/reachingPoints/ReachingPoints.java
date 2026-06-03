package java1.algorithms.simulation.reachingPoints;

public class ReachingPoints {
    //Backward simulation TC: O(log(max(tx, ty))) SC: O(1)
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while(tx >= sx && ty >= sy) {

            //If we reached the source
            if(tx == sx && ty == sy) return true;

            //Reduce the larger coordinate
            if(tx > ty) {

                //If y is already fixed, check feasability directly
                if(ty == sy) {
                    return (tx - sx) % ty == 0;
                }
                tx %= ty;
            } else {

                //If x is already fixed, check feasability directly
                if(tx == sx) {
                    return (ty - sy) % tx == 0;
                }
                ty %= tx;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Object[][] tests = {
            // {sx, sy, tx, ty, expected}
            {1, 1, 3, 5,  true},   // (1,1)→(1,2)→(1,3)→(4,3)? no, backwards: 3%... → origin
            {1, 1, 2, 2,  false},  // no path to equal diagonal
            {3, 5, 3, 5,  true},   // already at target
            {1, 2, 5, 4,  true},   // backwards verifiable
            {2, 3, 8, 3,  true},   // y fixed at 3, (8-2)%3==0
            {1, 3, 10, 12, false}, // no valid path
        };

        for (Object[] test : tests) {
            int sx = (int) test[0], sy = (int) test[1];
            int tx = (int) test[2], ty = (int) test[3];
            boolean expected = (boolean) test[4];
            boolean result = reachingPoints(sx, sy, tx, ty);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] sx=" + sx + " sy=" + sy +
                " tx=" + tx + " ty=" + ty + " result=" + result + " expected=" + expected);
        }
    }
}
