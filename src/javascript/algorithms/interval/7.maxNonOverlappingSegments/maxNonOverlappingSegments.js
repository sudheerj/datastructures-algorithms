function maxNonOverlappingSegments(startPoints, endPoints) {
    const length = startPoints.length;
    if(startPoints.length === 0) return 0;

    const intervals = startPoints.map((startPoint, i) => {
        return {
            start: startPoint,
            end: endPoints[i]
        }
    })

    intervals.sort((a, b) => a.end - b.end);

    let selectedCount = 0;
    let lastSelectedEnd = -Infinity;

    for ( const segment of intervals ) {
        if(segment.start > lastSelectedEnd){
            selectedCount++;
            lastSelectedEnd = segment.end;
        }
    }

    return selectedCount;
}

// Example 1
const startPoints1 = [1, 3, 7, 9, 9];
const endPoints1   = [5, 6, 8, 9, 10];
console.log(maxNonOverlappingSegments(startPoints1, endPoints1)); // Output: 3

// Example 2
const startPoints2 = [1, 2, 3, 4, 5];
const endPoints2   = [2, 3, 4, 5, 6];
console.log(maxNonOverlappingSegments(startPoints2, endPoints2)); // Output: 3

// Example 3
const startPoints3 = [0, 0, 0];
const endPoints3   = [0, 0, 0];
console.log(maxNonOverlappingSegments(startPoints3, endPoints3)); // Output: 1
