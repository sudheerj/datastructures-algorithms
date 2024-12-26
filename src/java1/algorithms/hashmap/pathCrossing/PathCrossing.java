package java1.algorithms.hashmap.pathCrossing;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    private static boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x=0, y = 0;

        visited.add(x+","+y);

        for (char move : path.toCharArray()) {
            if(move == 'N') y++;
            if(move == 'S') y--;
            if(move == 'E') x++;
            if(move == 'W') x--;

            if(visited.contains(x+","+y)) {
                return true;
            }
    
            visited.add(x+","+y);
        }

        return false;
    }

    public static void main(String[] args) {
        String path1="NESE";
        String path2="NEWS";

        System.out.println(isPathCrossing(path1));
        System.out.println(isPathCrossing(path2));
    }
}
