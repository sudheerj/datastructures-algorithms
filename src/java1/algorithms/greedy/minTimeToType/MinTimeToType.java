package java1.algorithms.greedy.minTimeToType;

public class MinTimeToType {
    //Simulation + Greedy(minimum circular distance)
    private static int minTimeToType(String word) {
        char currentChar = 'a';
        int time = 0;

        for(char ch: word.toCharArray()) {
            int diff = Math.abs(ch - currentChar);

            //Min rotation in circular alphabet
            time +=  Math.min(diff, 26-diff);
            //Type the key
            time++;

            currentChar = ch; 
        }

        return time;
    }
    
    public static void main(String[] args) {
        System.out.println(minTimeToType("abc"));      // 5
        System.out.println(minTimeToType("bza"));      // 7
        System.out.println(minTimeToType("zjpc"));     // 34
        System.out.println(minTimeToType("a"));        // 1
        System.out.println(minTimeToType("z"));        // 2
        System.out.println(minTimeToType("leetcode")); // 70
    }

}
