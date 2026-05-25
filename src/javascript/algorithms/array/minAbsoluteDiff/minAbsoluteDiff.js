// Sort + scan adjacent — O(n log n) time, O(n) space
function minAbsDifference(nums) {
    nums.sort((a, b) => a - b);
    let minDiff = Infinity;
    for (let i = 1; i < nums.length; i++) {
        minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
    }
    const result = [];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] - nums[i - 1] === minDiff) {
            result.push([nums[i - 1], nums[i]]);
        }
    }
    return result;
}

const r1 = minAbsDifference([4, 2, 1, 3]);
const e1 = [[1,2],[2,3],[3,4]];
console.log(`Test 1: ${JSON.stringify(r1) === JSON.stringify(e1) ? '[PASS]' : '[FAIL]'} result=${JSON.stringify(r1)} expected=${JSON.stringify(e1)}`);

const r2 = minAbsDifference([1, 3, 6, 10, 15]);
const e2 = [[1,3]];
console.log(`Test 2: ${JSON.stringify(r2) === JSON.stringify(e2) ? '[PASS]' : '[FAIL]'} result=${JSON.stringify(r2)} expected=${JSON.stringify(e2)}`);

const r3 = minAbsDifference([3, 8, -10, 23, 19, -4, -14, 27]);
const e3 = [[-14,-10],[19,23],[23,27]];
console.log(`Test 3: ${JSON.stringify(r3) === JSON.stringify(e3) ? '[PASS]' : '[FAIL]'} result=${JSON.stringify(r3)} expected=${JSON.stringify(e3)}`);

const r4 = minAbsDifference([1, 2, 3]);
const e4 = [[1,2],[2,3]];
console.log(`Test 4: ${JSON.stringify(r4) === JSON.stringify(e4) ? '[PASS]' : '[FAIL]'} result=${JSON.stringify(r4)} expected=${JSON.stringify(e4)}`);

const r5 = minAbsDifference([-5, 0, 5]);
const e5 = [[-5,0],[0,5]];
console.log(`Test 5: ${JSON.stringify(r5) === JSON.stringify(e5) ? '[PASS]' : '[FAIL]'} result=${JSON.stringify(r5)} expected=${JSON.stringify(e5)}`);
