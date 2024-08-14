function compact1(arr){
    return arr.filter(Boolean)
}

function compact2(arr){
    let compactArr = [];

    for (let i = 0; i < arr.length; i++) {
        if(arr[i]) {
            compactArr.push(arr[i]);
        }
    }

    return compactArr;
}

const arr1 =[1, 'hi', false, 0, 'a', null, undefined, NaN, {}, [], () => {}, ''];
console.log(compact1(arr1));
console.log(compact2(arr1));