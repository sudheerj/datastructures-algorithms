class SumRange {
    constructor(nums) {
        this.prefixSum = Array(nums.length+1).fill(0);

        for (let i = 0; i < nums.length; i++) {
            this.prefixSum[i+1] = this.prefixSum[i] + nums[i];
        }
    }

    sumRange(left, right){
        return this.prefixSum[right+1] - this.prefixSum[left];
    }
}

const nums1 = [6, -3, 1, 5, 3, 7, -5];
const sumRangeInstance = new SumRange(nums1);
console.log(sumRangeInstance.sumRange(0, 3));
console.log(sumRangeInstance.sumRange(2, 6));
console.log(sumRangeInstance.sumRange(0, 6));



