function isCommonElementExistsWithObject(arr1, arr2) {
    let obj = {};
    for (let i =0; i < arr1.length; i++) {
        obj[arr1[i]] = true;
    }
    for (let j =0; j < arr2.length; j++) {
        if(obj[arr2[j]]) return true;
    }
    return false;
}

function isCommonElementExistsWithMap(arr1, arr2) {
    let map = new Map();
    for (let i of arr1) {
        map.set(i, true);
    }
    for (let j of arr2) {
        if(map.get(j)) return true;
    }
    return false;
}

const arr1 = [10, 43, 9, 7];
const arr2 = [17, 33, 10, 2];
isCommonElementExistsWithObject(arr1, arr2);
isCommonElementExistsWithMap(arr1, arr2);