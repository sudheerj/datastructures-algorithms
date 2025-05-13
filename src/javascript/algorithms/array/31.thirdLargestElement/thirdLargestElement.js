function thirdLargestElement1(arr){
    let first = -Infinity, second = -Infinity, third = -Infinity;

    for (const num of arr) {
        if(num === first || num === second || num === third) {
            continue;
        }

        if(num > first) {
            [first, second, third] = [num, first, second];
        } else if(num > second && num < first) {
            [second, third] = [num, second];
        } else if(num > third && num < second) {
            third = num;
        }
    }

    return third === -Infinity ? "There are no 3 unique elements in an array" : third;
}

function thirdLargestElement2(arr) {
    let uniqueArr = [...new Set(arr)];

    if(uniqueArr.length < 3) {
        return "There are no 3 unique elements in an array";
    }

    uniqueArr.sort((a, b) => b-a);

    return uniqueArr[2];
}

console.log(thirdLargestElement1([33, 90, 10, 50, 33, 77, 90, 4]));
console.log(thirdLargestElement2([33, 90, 10, 50, 33, 77, 90, 4]));