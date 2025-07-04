function countTriangles(numbers) {
    numbers.sort((a, b) => a - b);
    const length = numbers.length;

    let count = 0;

    for(let i = 0; i < length-2; i++) {
        let k = i + 2;
        for(let j = i + 1; j < length-1; j++) {
            while(k < length && numbers[i] + numbers[j] > numbers[k]) {
                k++;
            }

            count += k-j-1;
        }
    }

    return count;
}

// Examples
const examples = [
    { input: [10, 2, 5, 1, 8, 12], expected: 4 },
    { input: [4, 6, 3, 7], expected: 3 },
    { input: [1, 1, 1, 1], expected: 4 },
    { input: [5, 10, 12, 15], expected: 3 },
    { input: [1, 2, 3], expected: 0 } // Cannot form any triangle
];

examples.forEach(({ input, expected }, idx) => {
    const result = countTriangles([...input]); // copy to preserve original
    console.log(`Example ${idx + 1}: Input = [${input}] → Count = ${result} | Expected = ${expected}`);
});
