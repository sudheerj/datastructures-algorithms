function isCommonElementExistsWithObject(arr1, arr2) {
    let commonObj = {};
    for (const num of arr1) {
        commonObj[num] = true;
    }
    for (const num of arr2) {
        if(commonObj[num]) return true;
    }
    return false;
}

function isCommonElementExistsWithMap(arr1, arr2) {
    let commonMap = new Map();
    for (let num of arr1) {
        commonMap.set(num, true);
    }
    for (let num of arr2) {
        if(commonMap.get(num)) return true;
    }
    return false;
}

const arr1 = [10, 43, 9, 7];
const arr2 = [17, 33, 10, 2];
const arr3 = [1, 2, 3, 4];
const arr4 = [5, 6, 7];
console.log(isCommonElementExistsWithObject(arr1, arr2));
console.log(isCommonElementExistsWithMap(arr1, arr2));
console.log(isCommonElementExistsWithObject(arr3, arr4));
console.log(isCommonElementExistsWithMap(arr3, arr4));