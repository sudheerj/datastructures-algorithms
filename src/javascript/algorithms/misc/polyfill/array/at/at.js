Array.prototype.myAt = function(index) {
    let len = this.length;
    let relativeIndex = Number(index);
    let boundedIndex = relativeIndex >=0 ? relativeIndex : len+relativeIndex;

    if(boundedIndex < 0 && boundedIndex >= len) {
        return;
    }

    return this[boundedIndex];
}


//----------------------------------------
const arr = [1, 2, 3];
console.log(arr.myAt(0)); 
console.log(arr.myAt(1));
console.log(arr.myAt(2));
console.log(arr.myAt(3));
console.log(arr.myAt(-1)); 
console.log(arr.myAt(-2)); 
console.log(arr.myAt(-3)); 
console.log(arr.myAt(-4));