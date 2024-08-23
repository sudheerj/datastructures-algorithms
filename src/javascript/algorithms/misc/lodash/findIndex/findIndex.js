function findIndex(arr, predicate, fromIndex=0){
    const length = arr.length;

    if(fromIndex <0) {
        fromIndex = -fromIndex > length ? 0 : fromIndex+length;
    }

    for (let index = fromIndex; index < length; index++) {
        if(predicate(arr[index], index, arr)) {
            return index;
        }
    }

    return -1;
}

const arr1 = [1,2,3,4,5], predicate1 = (value) => value > 2;
const arr2 = [1,2,3,4,5], predicate2 = (value) => value > 8;
const arr3 = [1,2,3,4,5], predicate3 = (value) => value > 3;
console.log(findIndex(arr1, predicate1, 3)); //3
console.log(findIndex(arr2, predicate2, 4)); //-1
console.log(findIndex(arr3, predicate3, -2)); //3