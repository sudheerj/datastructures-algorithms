function dropRightWhile(arr, predicate){
    let endIndex = arr.length-1;

    while(endIndex >=0 && predicate(arr[endIndex], endIndex, arr)){
        endIndex--;
    }

    return arr.slice(0, endIndex+1);
}


const arr1 = [{
    name: 'banana', type: 'fruit'},
    {name: 'tomato', type: 'veggie'},
    {name: 'apple', type: 'fruit'}
];
console.log(dropRightWhile(arr1, (el) => el.name === 'apple'));