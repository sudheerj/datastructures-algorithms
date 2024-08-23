function fill(arr, value, start=0, end= arr.length) {
    let length = arr.length;

    if(end <= start) {
        return arr;
    }

    if(start < 0) {
        start = -start < length ? start+length : 0;
    }

    if(end < 0) {
        end = end+length;
    }

    for (let i = start; i < Math.min(end, length); i++) {
        arr[i] = value;
    }

    return arr;
}

const arr1 = [1, 2, 3, 4, 5];
const arr2 = [1, 2, 3, 4, 5];
const arr3 = [1, 2, 3, 4, 5];
console.log(fill(arr1, '*', 2, 4));
console.log(fill(arr2, '*', -4, -1));
console.log(fill(arr3, '*', -1, -4));