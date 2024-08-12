function clamp1(num, min, max){
    if(num < min) {
        return min;
    } else if(num > max) {
        return max;
    }
    return num;
}

function clamp2(num, min, max){
    return Math.min(max, Math.max(num, min));
}


console.log(clamp1(4, 0, 6)); // Within boundaries range
console.log(clamp1(-5, -1, 8)); // Smaller than lower bound
console.log(clamp1(15, -1, 10)); // Bigger than upper bound
