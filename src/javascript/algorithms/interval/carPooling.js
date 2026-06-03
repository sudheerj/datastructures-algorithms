function carPooling1(trips, capacity) {
    const occupancy = new Array(1001).fill(0);
    for (const [people, start, end] of trips) {
        occupancy[start] += people;
        occupancy[end] -= people;
    }
    let curr = 0;
    for (let occ of occupancy) {
        curr += occ;
        if (curr > capacity) return false;
    }
    return true;
}

function carPooling2(trips, capacity) {
    trips = trips.slice().sort((a, b) => a[1] - b[1]);
    const pq = [];
    let curr = 0;
    for (const [people, start, end] of trips) {
        while (pq.length && pq[0][0] <= start) {
            curr -= pq.shift()[1];
        }
        curr += people;
        if (curr > capacity) return false;
        pq.push([end, people]);
        pq.sort((a, b) => a[0] - b[0]);
    }
    return true;
}

function carPooling3(trips, capacity) {
    const events = [];
    for (const [people, start, end] of trips) {
        events.push([start, people]);
        events.push([end, -people]);
    }
    events.sort((a, b) => a[0] - b[0]);
    let curr = 0;
    for (const [_, change] of events) {
        curr += change;
        if (curr > capacity) return false;
    }
    return true;
}

function carPooling4(trips, capacity) {
    const occupancy = new Array(1001).fill(0);
    for (const [people, start, end] of trips) {
        for (let i = start; i < end; i++) {
            occupancy[i] += people;
            if (occupancy[i] > capacity) return false;
        }
    }
    return true;
}

function deepCopy(arr) {
    return arr.map(x => x.slice());
}

function runTests() {
    const tests = [
        [[[2,1,5],[3,3,7]], 4, false],
        [[[2,1,5],[3,3,7]], 5, true],
        [[[3,2,7],[3,7,9],[8,3,9]], 11, true],
        [[[3,2,7],[3,7,9],[8,3,9]], 10, false],
        [[[2,1,5],[3,5,7]], 3, true],
        [[[2,1,5],[3,5,7]], 2, false],
        [[[9,0,1],[3,3,7]], 10, true],
    ];
    console.log("Testing carPooling1 (difference array):");
    for (let i = 0; i < tests.length; i++) {
        const [trips, cap, exp] = tests[i];
        const result = carPooling1(deepCopy(trips), cap);
        console.log(`Test ${i+1}: Output=${result}, Expected=${exp} [${result === exp ? 'PASS' : 'FAIL'}]`);
    }
    console.log("\nTesting carPooling2 (min heap):");
    for (let i = 0; i < tests.length; i++) {
        const [trips, cap, exp] = tests[i];
        const result = carPooling2(deepCopy(trips), cap);
        console.log(`Test ${i+1}: Output=${result}, Expected=${exp} [${result === exp ? 'PASS' : 'FAIL'}]`);
    }
    console.log("\nTesting carPooling3 (event sweep):");
    for (let i = 0; i < tests.length; i++) {
        const [trips, cap, exp] = tests[i];
        const result = carPooling3(deepCopy(trips), cap);
        console.log(`Test ${i+1}: Output=${result}, Expected=${exp} [${result === exp ? 'PASS' : 'FAIL'}]`);
    }
    console.log("\nTesting carPooling4 (bruteforce):");
    for (let i = 0; i < tests.length; i++) {
        const [trips, cap, exp] = tests[i];
        const result = carPooling4(deepCopy(trips), cap);
        console.log(`Test ${i+1}: Output=${result}, Expected=${exp} [${result === exp ? 'PASS' : 'FAIL'}]`);
    }
}

runTests();
