function dropWhile(arr, predicate){
    let index = 0;

    while(index < arr.length && predicate(arr[index], index, arr)) {
        index++;
    }

    return arr.slice(index);
}

const arr1 = [{
    name: 'banana', type: 'fruit'},
    {name: 'tomato', type: 'veggie'},
    {name: 'apple', type: 'fruit'}
];
console.log(dropWhile(arr1, (el) => el.name === 'banana'));