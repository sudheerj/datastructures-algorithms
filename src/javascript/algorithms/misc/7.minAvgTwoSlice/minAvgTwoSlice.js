function minAvgTwoSlice(numbers) {
    let minAvg = Infinity, minIndex = 0;

    for (let i = 0; i < numbers.length-1; i++) {
        const avg2 = (numbers[i] + numbers[i+1])/2;

        if(avg2 < minAvg) {
            minAvg = avg2;
            minIndex = i;
        }

        if(i < numbers.length -2 ) {
            const avg3 = (numbers[i] + numbers[i+1] + numbers[i+2])/2;

            if(avg3 < minAvg) {
                minAvg = avg3;
                minIndex = i;
            }
        }
    }

    return minIndex;
}

console.log(minAvgTwoSlice([4, 2, 2, 5, 1, 5, 8])); // ➞ 1
console.log(minAvgTwoSlice([1, 1, -10, -10, 1, 1])); // ➞ 2
