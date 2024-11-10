package java1.algorithms.array.canPlaceFlowers;

public class CanPlaceFlowers {
    private static boolean canPlaceFlowers(int[] flowersbed, int n){
        int count = 0;

        for (int i = 0; i < flowersbed.length; i++) {
            if(flowersbed[i] == 0 && (i == 0 || flowersbed[i-1] == 0) && (i == flowersbed.length-1 || flowersbed[i+1] == 0)) {
                flowersbed[i] = 1;
                count++;

                if(count >= n) {
                    return true;
                }

                i++;
            }
        }
        return count >= n;
    }
    public static void main(String[] args) {
        int[] flowerbed1 = new int[]{1,0,0,1}; int n1= 1;
        int[] flowerbed2 = new int[]{1,0,0,0,1}; int n2= 1;
        int[] flowerbed3 = new int[]{1,0,0,0,1}; int  n3= 2;
        System.out.println(canPlaceFlowers(flowerbed1, n1));
        System.out.println(canPlaceFlowers(flowerbed2, n2));
        System.out.println(canPlaceFlowers(flowerbed3, n3));
    }
}
