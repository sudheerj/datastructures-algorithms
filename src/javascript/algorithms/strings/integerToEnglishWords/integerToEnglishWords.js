function numberToWords(num) {
    if (num === 0) return "Zero";
    const below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
    const tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
    const thousands = ["", "Thousand", "Million", "Billion"];
    function helper(n) {
        if (n === 0) return "";
        if (n < 20) return below20[n] + " ";
        if (n < 100) return tens[Math.floor(n / 10)] + " " + helper(n % 10);
        return below20[Math.floor(n / 100)] + " Hundred " + helper(n % 100);
    }
    let res = "";
    let i = 0;
    while (num > 0) {
        if (num % 1000 !== 0) {
            res = helper(num % 1000) + thousands[i] + " " + res;
        }
        num = Math.floor(num / 1000);
        i++;
    }
    return res.trim();
}

module.exports = { numberToWords };
