function countApplesAndOranges(s,t,a,b,apples,oranges) {
    let appleCount = apples.filter((pos) => pos + a >= s && pos + a <= t).length;
    let orangeCount = oranges.filter((pos) => pos + b >= s && pos + b <= t).length;

    console.log(appleCount, ' ', orangeCount);
}

// Test cases
countApplesAndOranges(7, 11, 5, 15, [-2, 2, 1], [5, -6]); // Output: 1 1
countApplesAndOranges(10, 20, 5, 25, [10, -5, 0, 15], [-10, 5, 20]); // Output: 2 1
countApplesAndOranges(5, 15, 3, 17, [2, 3, -4], [3, -2, -1]); // Output: 2 1
countApplesAndOranges(1, 5, 0, 6, [1, 2, 3], [-1, -2, -3]); // Output: 3 3
