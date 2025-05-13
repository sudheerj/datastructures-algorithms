import java.util.*;

public class ThirdLargestElement {

    private static String thirdLargestElement1(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int num : arr) {
            if(num == first || num == second || num == third ) {
                continue;
            }

            if(num > first) {
                third = second;
                second = first;
                first = num;
            } else if(num > second && num < first) {
                third = second;
                second = num;
            } else if(num > third && num < second) {
                third =  num;
            }
        }

        return third == Integer.MIN_VALUE ? "There are no 3 unique elements in an array" : String.valueOf(third);
    }

    private static String thirdLargestElement2(int[] arr){
        Set<Integer> uniqueArr = new TreeSet<>(Collections.reverseOrder());

        for (Integer num : arr) {
            uniqueArr.add(num);
        }

        if(uniqueArr.size() < 3) {
            return "There are no 3 unique elements in an array";
        }

        List<Integer> list = new ArrayList<>(uniqueArr);
        return String.valueOf(list.get(2));
    }

    public static void main(String[] args) {
        int[] array = {33, 90, 10, 50, 33, 77, 90, 4};
        System.out.println(thirdLargestElement1(array));
        System.out.println(thirdLargestElement2(array));
    }
}