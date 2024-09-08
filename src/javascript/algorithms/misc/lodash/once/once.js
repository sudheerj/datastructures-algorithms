function once(func){
    let ranOnce = false;
    let value;

    return function(...args) {
        if(!ranOnce) {
            value = func.apply(this, args);
            ranOnce = true;
        }

        return value;
    }
}
// --------------------------------------------------------------
let index = 1;

function incrementBy(value) {
    index += value;
    return index;
}

const incrementByOnce = once(incrementBy);
console.log(incrementByOnce(2));
console.log(incrementByOnce(3));
index = 4;
console.log(incrementByOnce(5));