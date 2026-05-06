// Interval List Intersections
// Given two lists of closed intervals, each list pairwise disjoint and sorted,
// return the intersection of the two interval lists.
// Time Complexity: O(n + m), Space Complexity: O(1) excluding result

function listIntersection(firstList, secondList) {
    const result = [];
    let i = 0, j = 0;

    while (i < firstList.length && j < secondList.length) {
        const [firstStart, firstEnd] = firstList[i];
        const [secondStart, secondEnd] = secondList[j];

        const start = Math.max(firstStart, secondStart);
        const end = Math.min(firstEnd, secondEnd);

        // Verify valid intersection
        if (start <= end) {
            result.push([start, end]);
        }

        // Move the pointer with smaller end
        if (firstEnd < secondEnd) {
            i++;
        } else {
            j++;
        }
    }

    return result;
}

// Test 1: General case with multiple overlaps
console.log(listIntersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]]));
// [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

// Test 2: Simple partial overlap
console.log(listIntersection([[0,2],[5,10]], [[1,5],[8,12]]));
// [[1,2],[5,5],[8,10]]

// Test 3: No overlaps
console.log(listIntersection([[0,2],[5,7]], [[3,4],[8,10]]));
// []

// Test 4: One list is empty
console.log(listIntersection([[0,5]], []));
// []

// Test 5: Complete containment
console.log(listIntersection([[1,10]], [[2,3],[4,6]]));
// [[2,3],[4,6]]

// Test 6: Same intervals
console.log(listIntersection([[1,5]], [[1,5]]));
// [[1,5]]
