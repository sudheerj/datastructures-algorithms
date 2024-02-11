function mostWater(heights) {
    let capacity = 0;
    let left = 0, right = heights.length-1;

    while(left < right) {
        let minHeight = Math.min(heights[left], heights[right]);
        capacity = Math.max(capacity, minHeight * (right - left));
        if(heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }
    return capacity;
}

let waterHeights = [3,9,4,1,5,4,7,1,7];
console.log(mostWater(waterHeights));