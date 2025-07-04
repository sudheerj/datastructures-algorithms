function frogRiverOne(destinationPosition, positionsList) {
    const positions = new Set();

    for(let i = 0; i < positionsList.length; i++) {
        positions.add(positionsList[i]);

        if(positions.size === destinationPosition) {
            return i;
        }
    }

    return -1;
}

function frogRiverTwo(destinationPosition, positionsList) {
    const seen = Array(destinationPosition+1).fill(false);
    let uncovered = destinationPosition;

    for(let i = 0; i < positionsList.length; i++) {
        if(!seen[positionsList[i]]) {
            seen[positionsList[i]] = true;
            uncovered--;

            if(uncovered === 0) {
                return i;
            }
        }
    }

    return -1;
}

// Example 1: Multiple positions in different times
console.log(frogRiverOne(5, [1, 3, 1, 4, 2, 3, 5, 4])); // Output: 6
// Example 2: Missing position, frog can't cross
console.log(frogRiverOne(3, [1, 3, 1, 1])); // Output: -1
// Example 3: Immediate success
console.log(frogRiverOne(1, [1])); // Output: 0
// Example 4: Leaves fall in reverse order
console.log(frogRiverOne(3, [3, 2, 1])); // Output: 2
// Example 5: Repeated positions
console.log(frogRiverOne(2, [1, 1, 1, 2])); // Output: 3
