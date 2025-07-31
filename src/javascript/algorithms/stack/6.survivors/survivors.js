function survivors(A, B) {
    const downstream = [];
    let survivors = 0;

    for(let i=0; i<A.length; i++) {
        if(B[i] === 1) {
            //Fish moving downstream- store its size
            downstream.push(A[i]);
        } else {
            //Fish moving upstream - fight any upstream fish
            while(downstream.length > 0) {
                //Downstream fish eats upstream fish
                if(downstream[downstream.length-1] > A[i]) {
                    //upstream fish is eaten
                    break;
                } else {
                    //upstream fish eats downstream fish
                    downstream.pop();
                }
            }

            //If no downstream fish left, upstream fish survives
            if(downstream.length === 0) {
                survivors++;
            }
        }
    }

    //Survived upstream fish + all downstream fish left
    return survivors + downstream.length;
}

const testCases = [
  {
    A: [4, 3, 2, 1, 5],
    B: [0, 1, 0, 0, 0],
    expected: 2, // Classic mix of directions, upstream fish eats downstream
  },
  {
    A: [1, 2, 3, 4, 5],
    B: [0, 0, 0, 0, 0],
    expected: 5, // All fish go upstream, no conflict
  },
  {
    A: [5, 4, 3, 2, 1],
    B: [1, 1, 1, 1, 1],
    expected: 5, // All fish go downstream, no conflict
  },
  {
    A: [5, 3, 8, 6, 2],
    B: [1, 1, 0, 0, 0],
    expected: 3, // Upstream fish eats all smaller downstream ones
  },
  {
    A: [5],
    B: [1],
    expected: 1, // Single downstream fish survives
  }
];

testCases.forEach(({ A, B, expected }, index) => {
    const result = survivors(A, B);
    console.log(`Test Case ${index + 1}: ${result === expected ? "✅ Passed" : "❌ Failed"} (Expected ${expected}, got ${result})`);
});
