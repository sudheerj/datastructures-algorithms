function findLastIndex(arr, predicate, fromIndex=arr.length-1){
    const length = arr.length;
    fromIndex = fromIndex < 0 ? Math.max(fromIndex+length, 0) : Math.min(fromIndex, length-1);

    let index = fromIndex;

    while(index >= 0) {
        if(predicate(arr[index], index, arr)) {
            return index;
        }
        index--;
    }

    return -1;
}

const arr1 = [6, 5, 4, 3, 2, 1], predicate1 = (value) => value > 2;
const arr2 = [6, 5, 4, 3, 2, 1], predicate2 = (value) => value > 3;
const arr3 = [6, 5, 4, 3, 2, 1], predicate3 = (value) => value > 3;
console.log(findLastIndex(arr1, predicate1, 3)); //3
console.log(findLastIndex(arr2, predicate2, -9)); //0
console.log(findLastIndex(arr3, predicate3, 7)); //3