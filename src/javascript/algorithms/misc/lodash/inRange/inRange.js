function inRange1(value, start, end=0){
    return Math.min(start, end) <= value && value < Math.max(start, end);
}

function inRange2(value, startParam=0, endParam){
    const [start, end] = endParam !== undefined ? [startParam, endParam] : [0, startParam] 
    return Math.min(start, end) <= value && value < Math.max(start, end);
}

function inRange3(value, start=0, end){
    if(end === undefined){
        end = start;
        start = 0;
    }

    if(start < end) {
        return (start <= value && value < end);
    }
    return end <= value && value < start;
}

console.log(inRange1(3, 2, 4)); 
console.log(inRange1(4, 8)); 
console.log(inRange1(4, 2)); 
console.log(inRange1(2, 2)); 
console.log(inRange1(1.2, 2)); 
console.log(inRange1(5.2, 4)); 
console.log(inRange1(-3, -2, -6));

console.log(inRange2(3, 2, 4)); 
console.log(inRange2(4, 8)); 
console.log(inRange2(4, 2)); 
console.log(inRange2(2, 2)); 
console.log(inRange2(1.2, 2)); 
console.log(inRange2(5.2, 4)); 
console.log(inRange2(-3, -2, -6));

console.log(inRange3(3, 2, 4)); 
console.log(inRange3(4, 8)); 
console.log(inRange3(4, 2)); 
console.log(inRange3(2, 2)); 
console.log(inRange3(1.2, 2)); 
console.log(inRange3(5.2, 4)); 
console.log(inRange3(-3, -2, -6));