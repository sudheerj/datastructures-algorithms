function canSeePersonsCount(heights) {
    let length = heights.length;
    let visibilityCount = Array(length).fill(0);
    let stack = [];

    for(let i = length-1; i>-1; i--) {
        while(stack.length && stack[stack.length-1] < heights[i]) {
            stack.pop();
            ++visibilityCount[i];
        }

        if(stack.length) {
            ++visibilityCount[i];
        }
        stack.push(heights[i]);
    }
    return visibilityCount;
}

let heights1 = [10,6,8,5,11,9];
console.log(canSeePersonsCount(heights1));

let heights2 = [6, 5, 4, 3, 2, 1];
console.log(canSeePersonsCount(heights2));

let heights3 = [1, 2, 3, 4, 5, 6];
console.log(canSeePersonsCount(heights3));