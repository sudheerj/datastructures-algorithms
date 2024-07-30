function mostWater(heights) {
    let maxCapacity = 0;
    let left = 0, right = heights.length-1;

    while(left < right) {
        let currentCapacity = (right - left) * Math.min(heights[left], heights[right]);
        maxCapacity = Math.max(maxCapacity, currentCapacity);

        if(heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxCapacity;
}

let waterHeights1 = [3,9,4,1,5,4,7,1,7];
console.log(mostWater(waterHeights1));

let waterHeights2 = [1, 1];
console.log(mostWater(waterHeights2));