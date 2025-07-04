//Iteration over array TC: O(m+n), SC(n)
function maxCounters(n, operations) {
    const counters = Array(n).fill(0);

    let max = 0, lastUpdate = 0;

    for(let i = 0; i < operations.length; i++) {
        const counterNumber = operations[i];

        if(1 <= counterNumber && counterNumber <= n) {
            // Apply lazy update if needed
            if(counters[counterNumber-1] < lastUpdate) {
                counters[counterNumber-1] = lastUpdate;
            }

            //Increment counter by one
            counters[counterNumber-1]++;

            //Update maximum value so far
            if(counters[counterNumber-1] > max) {
                max = counters[counterNumber-1];
            }
        } else if(counterNumber === n+1) {
            //defer the update
            lastUpdate = max;
        }
    }

    // Final update: make all counters up to date
    for(let i=0; i < counters.length; i++) {
        if(counters[i] < lastUpdate) {
            counters[i] = lastUpdate;
        }
    }

    return counters;
}


// Example 1: Mixed operations
const n1 = 4;
const operations1 = [1, 4, 4, 5, 2, 4, 4];
console.log(maxCounters(n1, operations1)); // Output: [2, 3, 2, 4]

// Example 2: No max operation
const n2 = 3;
const operations2 = [1, 2, 1, 3];
console.log(maxCounters(n2, operations2)); // Output: [2, 1, 1]

// Example 3: All max operations
const n3 = 2;
const operations3 = [3, 3, 3];
console.log(maxCounters(n3, operations3)); // Output: [0, 0]
