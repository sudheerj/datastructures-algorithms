function chunk1(arr, size) {
    let splitArr = [];

    if(!Array.isArray(arr) || size < 1) {
        return [];
    }

    for (let i = 0; i < arr.length; i += size) {
        let chunk = arr.slice(i, i+size);
        splitArr.push(chunk);
    }

    return splitArr;
}

function chunk2(arr, size) {
    let splitArr = [];
    let chunk = [];

    if(!Array.isArray(arr) || size < 1) {
        return [];
    }

    for (let i = 0; i < arr.length; i++) {
        chunk.push(arr[i]);
        if(chunk.length === size || i === arr.length-1){
            splitArr.push(chunk);
            chunk = [];
        }
    }

    return splitArr;
}

const arr1 = [1, 2, 3, 4, 5, 6, 7];
const arr2 = ['a', 'b', 'c', 'd', 'e'];
console.log(chunk1(arr1, 3));
console.log(chunk1(arr2, 2));
console.log(chunk2(arr1, 3));
console.log(chunk2(arr2, 2));