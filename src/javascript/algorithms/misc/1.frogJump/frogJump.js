function frogJump(X, Y, D) {
    //Distance needs to be covered by frog
    const distance = Y - X;
    //Number of jumps required to cover the distance
    return Math.ceil(distance/D);
}

console.log(frogJump(10, 85, 30)); // Output: 3
