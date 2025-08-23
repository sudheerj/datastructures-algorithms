function  plusminus(arr) {
    const len = arr.length;

    let positiveCount = 0;
    let negativeCount = 0;
    let zeroCount = 0;

    for(const num of arr) {
        if(num > 0) {
            positiveCount++;
        } else if(num < 0) {
            negativeCount++;
        } else {
            zeroCount++;
        }
    }

    console.log((positiveCount/len).toFixed(5), (negativeCount/len).toFixed(5), (zeroCount/len).toFixed(5));
}


// Example usage
const numbers1 = [1, -2, 0, 3, -4, 5, 0];
const numbers2 = [-1, -2, -3, 0, 0, 0];
const numbers3 = [1, 2, 3, 4, 5];

console.log(plusminus(numbers1));
console.log(plusminus(numbers2));
console.log(plusminus(numbers3));