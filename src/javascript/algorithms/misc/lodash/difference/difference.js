function difference1(arr1, arr2){
    if(arr1.length === 0) return [];
    if(arr2.length === 0) return arr1;

    return arr1.filter(val => !arr2.includes(val));
}

function difference2(arr1, arr2){
    if(arr1.length === 0) return [];
    if(arr2.length === 0) return arr1;

    const excludeSet = new Set(arr2);

    return arr1.filter(val => !excludeSet.has(val));
}

function difference3(arr1, arr2){
    if(arr1.length === 0) return [];
    if(arr2.length === 0) return arr1;

    const excludeSet = new Set(arr2);
    let result = [];

    for (let i = 0; i < arr1.length; i++) {
        const value = arr1[i];
        if(!excludeSet.has(value) && ! (value === undefined && !(i in arr1))) {
            result.push(arr1[i]);
        }
    }

    return result;
}

const arr1 = [1, 2, 2, 3, 2], arr2 = [2];
const arr3 = [1, 2, 3], arr4 = [];
const arr5 = [], arr6 = [];
console.log(difference1(arr1, arr2));
console.log(difference2(arr1, arr2));
console.log(difference3(arr1, arr2));
console.log(difference1(arr3, arr4));
console.log(difference1(arr5, arr6));