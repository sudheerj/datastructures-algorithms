function staircase(num) {
    for (let i = 1; i <= num; i++) {
        const spaces = ' '.repeat(num - i);
        const hashes = '#'.repeat(i);
        console.log(spaces + hashes);
    }
}


// Test cases
const n1 = 4;
const n2 = 6;
staircase(n1);
console.log('------------');
staircase(n2);