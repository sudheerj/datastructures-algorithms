/**
 * Sorting TC: O(n log n) SC: O(log n)
 */
function kthClosest1(points, k) {
    points.sort((a, b) => (a[0]**2 + a[1]**2) - (b[0]**2 + b[1]**2));
    return points.slice(0, k);
}

/**
 * Max Heap size k TC: O(n log k) SC: O(k)
 */
class MaxHeap {
    constructor() { this.data = []; }
    dist(p) { return p[0]**2 + p[1]**2; }
    push(p) {
        this.data.push(p);
        this._bubbleUp(this.data.length - 1);
    }
    pop() {
        const top = this.data[0];
        const last = this.data.pop();
        if (this.data.length > 0) { this.data[0] = last; this._sinkDown(0); }
        return top;
    }
    size() { return this.data.length; }
    _bubbleUp(i) {
        while (i > 0) {
            const parent = Math.floor((i - 1) / 2);
            if (this.dist(this.data[parent]) >= this.dist(this.data[i])) break;
            [this.data[parent], this.data[i]] = [this.data[i], this.data[parent]];
            i = parent;
        }
    }
    _sinkDown(i) {
        const n = this.data.length;
        while (true) {
            let largest = i;
            const l = 2*i + 1, r = 2*i + 2;
            if (l < n && this.dist(this.data[l]) > this.dist(this.data[largest])) largest = l;
            if (r < n && this.dist(this.data[r]) > this.dist(this.data[largest])) largest = r;
            if (largest === i) break;
            [this.data[largest], this.data[i]] = [this.data[i], this.data[largest]];
            i = largest;
        }
    }
}

function kthClosest2(points, k) {
    const heap = new MaxHeap();
    for (const p of points) {
        heap.push(p);
        if (heap.size() > k) heap.pop();
    }
    return heap.data;
}

/**
 * Min Heap (sort + slice simulates heapify + k pops) TC: O(n + k log n) SC: O(n)
 */
function kthClosest3(points, k) {
    const sorted = [...points].sort((a, b) => (a[0]**2 + a[1]**2) - (b[0]**2 + b[1]**2));
    return sorted.slice(0, k);
}

/**
 * QuickSelect TC: O(n) avg, O(n²) worst SC: O(log n)
 */
function kthClosest4(points, k) {
    function dist(p) { return p[0]**2 + p[1]**2; }
    function partition(left, right) {
        const pivotDist = dist(points[right]);
        let store = left;
        for (let i = left; i < right; i++) {
            if (dist(points[i]) <= pivotDist) {
                [points[store], points[i]] = [points[i], points[store]];
                store++;
            }
        }
        [points[store], points[right]] = [points[right], points[store]];
        return store;
    }
    let left = 0, right = points.length - 1;
    while (left < right) {
        const pivotIdx = partition(left, right);
        if (pivotIdx === k) break;
        else if (pivotIdx < k) left = pivotIdx + 1;
        else right = pivotIdx - 1;
    }
    return points.slice(0, k);
}

const testCases = [
    { points: [[1, 3], [-2, 2]],           k: 1, expected: [[-2, 2]] },
    { points: [[3, 3], [5, -1], [-2, 4]],  k: 2, expected: [[-2, 4], [3, 3]] },
    { points: [[0, 1], [1, 0]],            k: 2, expected: [[0, 1], [1, 0]] },
    { points: [[1, 0]],                    k: 1, expected: [[1, 0]] },
    { points: [[-5, 4], [0, 0], [1, 1]],   k: 2, expected: [[0, 0], [1, 1]] },
];

function normalize(pts) {
    return pts.map(p => p.join(",")).sort().join("|");
}

function runTests(fn, label) {
    console.log(`--- ${label} ---`);
    for (const { points, k, expected } of testCases) {
        const result = fn(points.map(p => [...p]), k);
        const pass = normalize(result) === normalize(expected);
        console.log(`[${pass ? "PASS" : "FAIL"}] result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    }
}

runTests(kthClosest1, "kthClosest1 (sorting)");
runTests(kthClosest2, "kthClosest2 (max heap)");
runTests(kthClosest3, "kthClosest3 (min heap)");
runTests(kthClosest4, "kthClosest4 (quickselect)");
