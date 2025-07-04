function  minPerimeterRectangle(area) {
    let minPerimeterRectangle = Infinity;

    for(let a= 1; a * a <= area; a++) {
        if(area % a === 0) {
            const b = area/a;
            const perimeter = 2 * ( a + b);
            minPerimeterRectangle = Math.min(minPerimeterRectangle, perimeter);
        }
    }

    return minPerimeterRectangle;
}

console.log(minPerimeterRectangle(30)); // ➞ 22 // 5 x 6 => 2*(5+6) = 22
console.log(minPerimeterRectangle(36)); // ➞ 24 // 6 x 6 => 2*(6+6) = 24
console.log(minPerimeterRectangle(1));  // ➞ 4 // 1 x 1 => 2*(1+1) = 4
console.log(minPerimeterRectangle(101)); // ➞ 204 // 1 x 101 => 2*(1+101) = 204 (101 is prime)