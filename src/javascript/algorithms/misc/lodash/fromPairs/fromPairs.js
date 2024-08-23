function fromPairs1(pairs){
    let pairsObj = {};
    for (const [key, value] of pairs) {
        pairsObj[key] = value;
    }

    return pairsObj;
}

function fromPairs2(pairs){
    return Object.fromEntries(pairs);
}

const arr1 = [['x', 1], ['y', 2], ['z', 3]];
console.log(fromPairs1(arr1));
console.log(fromPairs2(arr1));