package java1.algorithms.array.randomization.shuffleArray;

import java.util.Random;

//Fisher-Yates TC: O(n) for shuffle,reset & constructor SC: O(n)
public class ShuffleArray {
    int[] original;
    int[] array;
    Random random;
    
    ShuffleArray(int[] nums) {
        original = nums.clone();
        array = nums.clone();
        random = new Random();
    }

    private int[] reset() {
        array = original.clone();
        return array;
    }

    private int[] shuffle() {
        for(int i= array.length-1; i>0; i--) {
            int j = random.nextInt(i+1);

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        ShuffleArray sol = new ShuffleArray(new int[]{1, 2, 3});

        System.out.println("Shuffle 1: ");
        print(sol.shuffle());

        System.out.println("Shuffle 2: ");
        print(sol.shuffle());

        System.out.println("Reset: ");
        print(sol.reset());

        System.out.println("Shuffle 3: ");
        print(sol.shuffle());
    }

    public static void print(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
