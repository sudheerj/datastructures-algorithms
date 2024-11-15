package java1.algorithms.hashmap.maximumBalloons;

import java.util.HashMap;
import java.util.Map;

public class MaximumBalloons {
    private static int maxNumBalloons(String text){
        Map<Character, Integer> balloonMap = new HashMap<>();
        balloonMap.put('b', 1);
        balloonMap.put('a', 1);
        balloonMap.put('l', 2);
        balloonMap.put('o', 2);
        balloonMap.put('n', 1);

        Map<Character, Integer> countTextMap = new HashMap<>();

        for (Character ch : text.toCharArray()) {
            if(balloonMap.containsKey(ch)) {
                countTextMap.put(ch, countTextMap.getOrDefault(ch, 0)+1);
            }
        }

        int minBalloons = Integer.MAX_VALUE;

        for (Character ch : balloonMap.keySet()) {
            if(countTextMap.get(ch) == 0) {
                return 0;
            }

            minBalloons = Math.min(minBalloons, countTextMap.get(ch)/balloonMap.get(ch));
        }

        return minBalloons;
    }
    public static void main(String[] args) {
        String text1 = "lenobxlao";
        System.out.println(maxNumBalloons(text1));
        String text2 = "lollbcolatnaboon";
        System.out.println(maxNumBalloons(text2));
    }
}
