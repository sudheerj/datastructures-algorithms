// Winner of Circular Game (Josephus Problem)
// n friends in a circle; every k-th friend is eliminated. Return the winner.

// Approach 1: Queue Simulation — TC: O(n * k), SC: O(n)
function winnerOfCircularGame1(n, k) {
  const queue = [];
  for (let i = 1; i <= n; i++) queue.push(i);

  while (queue.length > 1) {
    // Move k-1 people from front to back
    for (let j = 1; j < k; j++) queue.push(queue.shift());
    // Eliminate the k-th person
    queue.shift();
  }
  return queue[0];
}

// Approach 2: Iterative Josephus — TC: O(n), SC: O(1)
function winnerOfCircularGame2(n, k) {
  let winner = 0; // base case: 1 person, 0-based index
  for (let i = 2; i <= n; i++) {
    winner = (winner + k) % i;
  }
  return winner + 1; // convert to 1-based
}

// Approach 3: Recursive Josephus — TC: O(n), SC: O(n)
function winnerOfCircularGame3(n, k) {
  return josephus(n, k) + 1;
}

function josephus(n, k) {
  if (n === 1) return 0;
  return (josephus(n - 1, k) + k) % n;
}

// Test cases
const tests = [[5, 2, 3], [6, 5, 1], [1, 1, 1], [4, 1, 4], [3, 3, 2]];

console.log('=== Queue Simulation ===');
tests.forEach(([n, k, expected], i) =>
  console.log(`Test ${i + 1}: ${winnerOfCircularGame1(n, k)} (expected ${expected})`)
);

console.log('=== Iterative Josephus ===');
tests.forEach(([n, k, expected], i) =>
  console.log(`Test ${i + 1}: ${winnerOfCircularGame2(n, k)} (expected ${expected})`)
);

console.log('=== Recursive Josephus ===');
tests.forEach(([n, k, expected], i) =>
  console.log(`Test ${i + 1}: ${winnerOfCircularGame3(n, k)} (expected ${expected})`)
);
