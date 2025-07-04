function countWaysToClimbLadders(steps, powers) {
    const length = steps.length;
    const maxStep = Math.max(...steps);
    const maxPower = Math.max(...powers);

    const modLimit = 1 << maxPower;
    const fib =[0, 1];

    for(let i= 2; i<= maxStep + 1; i++) {
        fib[i] = (fib[i-1] + fib[i-2]) % modLimit;
    }

    return steps.map((step, i) => {
        const mod = 1 << powers[i];
        return fib[step+1] % mod;
    })
}

console.log(countWaysToClimbLadders([10, 2, 4], [5, 3, 2])); // [25, 2, 1]
console.log(countWaysToClimbLadders([5, 3], [4, 2]));    // [8, 3]
console.log(countWaysToClimbLadders([4], [3]));          // [5]
