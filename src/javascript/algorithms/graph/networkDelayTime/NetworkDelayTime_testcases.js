// Network Delay Time - Test Cases
// This file contains test cases for the Network Delay Time algorithm in JavaScript.

function testNetworkDelayTime(networkDelayTime) {
  console.assert(networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2) === 2, 'Test Case 1 Failed');
  console.assert(networkDelayTime([[1,2,1]], 2, 1) === 1, 'Test Case 2 Failed');
  console.assert(networkDelayTime([[1,2,1]], 2, 2) === -1, 'Test Case 3 Failed');
  console.assert(networkDelayTime([[1,2,1],[2,3,2]], 4, 1) === -1, 'Test Case 4 Failed');
  console.log('All test cases passed!');
}

// To use, import your networkDelayTime function and call testNetworkDelayTime(networkDelayTime);