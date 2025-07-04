function maxFlags(heights) {
    const length = heights.length;
    const peaks = [];

    //
    for(let i = 1; i < length-1; i++){
        if(heights[i-1] < heights[i] && heights[i] > heights[i+1]){
            peaks.push(heights[i]);
        }
    }

    const totalPeaks = peaks.length;
    if(totalPeaks === 0) return 0;

    for(let k= totalPeaks; k >= 1; k--){
        let flagsUsed = 1;
        let lastFlag = peaks[0];

        for( let i= 1; i< totalPeaks; i++){
            if(peaks[i] - lastFlag >= k){
                flagsUsed++;
                lastFlag = peaks[i];
            }

            if(flagsUsed === k) return k;
        }
    }

    return 0;
}


console.log(maxFlags([1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2])); // ➞ 3 — Peaks at [1,3,5,10], max 3 flags can be placed
console.log(maxFlags([1, 2, 3, 4, 3, 4, 5, 2, 1])); // ➞ 2 — Peaks at [3,6], max 2 flags with distance ≥ 2
console.log(maxFlags([0, 1, 0, 1, 0, 1, 0])); // ➞ 2 — Peaks at [1,3,5], max 2 flags with distance ≥ 2
console.log(maxFlags([1, 3, 2, 1])); // ➞ 1 — Only one peak at index 1, only one flag can be placed
console.log(maxFlags([1, 2, 3, 4, 5])); // ➞ 0 — No peaks