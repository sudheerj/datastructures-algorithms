Array.prototype.square1 = function() {
    return this.map((el) => el * el);
}

Array.prototype.square2 = function() {
    const len = this.length;
    let newArr = new Array(len);

    for (let i = 0; i < len; i++) {
        newArr[i] = this[i] * this[i];
    }

    return newArr;
}

const arr1 = [-2, 4, 6];
const arr2 = [];
console.log(arr1.square1(arr1));
console.log(arr1.square1(arr2));
console.log(arr1.square2(arr1));
console.log(arr1.square2(arr2));