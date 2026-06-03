package java1.algorithms.strings.integerToEnglishWords;

public class IntegerToEnglishWords {
    private String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    //Recursion + divide the number into 3-digit chunks(thousands grouping) TC: O(1) or O(d/3) SC: O(1)
    private String numberToWords(int num) {
        //Base case
        if(num == 0) return "Zero";

        //Thousand positions
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        int i=0;
        StringBuilder result = new StringBuilder();

        //Partition into 3-digit chunk
        while(num >0) {
            int chunk = num % 1000;
            if(chunk != 0) {
                result.insert(0, helper(chunk) + thousands[i] + " ");
            }

            num= num/1000;
            i++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {
        if(num == 0) return "";

        // below 20
        if(num < 20) {
            return below20[num] + " ";
        }

        // 20 -99
        if(num < 100) {
            return tens[num/10] + " " + helper(num%10);
        }

        //100-999
        return below20[num/100] + " Hundred " + helper(num%100);
    }
    public static void main(String[] args) {
        IntegerToEnglishWords obj = new IntegerToEnglishWords();
        int[] testCases = {0, 5, 13, 20, 45, 100, 123, 1000, 12345, 1000000, 1000000000, 1234567891};
        String[] expected = {
            "Zero",
            "Five",
            "Thirteen",
            "Twenty",
            "Forty Five",
            "One Hundred",
            "One Hundred Twenty Three",
            "One Thousand",
            "Twelve Thousand Three Hundred Forty Five",
            "One Million",
            "One Billion",
            "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        };
        for (int i = 0; i < testCases.length; i++) {
            int input = testCases[i];
            String exp = expected[i];
            String result = obj.numberToWords(input).replaceAll("\\s+", " ").trim();
            String status = result.equals(exp) ? "PASS" : "FAIL";
            System.out.printf("Input: %d | Output: \"%s\" | Expected: \"%s\" | %s\n", input, result, exp, status);
        }
    }
}
