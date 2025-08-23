function  miniMaxSum(arr) {
   const min = Math.min(...arr);
   const max = Math.max(...arr);

   const sum = arr.reduce((acc, num) => acc + num, 0);

   console.log( (sum - max) +' ' + (sum - min) );
}

//Test case
miniMaxSum([1, 2, 3, 4, 5]); // Output: 10 14
miniMaxSum([7, 69, 2, 221, 8974]); // Output: 299 9271
miniMaxSum([1, 3, 5, 7, 9]); // Output: 16 24