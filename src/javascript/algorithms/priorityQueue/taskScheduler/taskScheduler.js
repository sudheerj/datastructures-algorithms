// Task Scheduler
// Given a list of tasks and cooldown n, return the minimum CPU intervals
// needed to finish all tasks (same task must wait n intervals between runs).
// TC: O(T log 26) ~= O(T), SC: O(1)

class MaxHeap {
  constructor() { this.heap = []; }
  push(val) {
    this.heap.push(val);
    this._bubbleUp(this.heap.length - 1);
  }
  pop() {
    const top = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = last;
      this._siftDown(0);
    }
    return top;
  }
  isEmpty() { return this.heap.length === 0; }
  _bubbleUp(i) {
    while (i > 0) {
      const parent = Math.floor((i - 1) / 2);
      if (this.heap[parent] >= this.heap[i]) break;
      [this.heap[parent], this.heap[i]] = [this.heap[i], this.heap[parent]];
      i = parent;
    }
  }
  _siftDown(i) {
    const n = this.heap.length;
    while (true) {
      let largest = i;
      const l = 2 * i + 1, r = 2 * i + 2;
      if (l < n && this.heap[l] > this.heap[largest]) largest = l;
      if (r < n && this.heap[r] > this.heap[largest]) largest = r;
      if (largest === i) break;
      [this.heap[largest], this.heap[i]] = [this.heap[i], this.heap[largest]];
      i = largest;
    }
  }
}

function leastIntervals(tasks, n) {
  const charFrequency = new Array(26).fill(0);
  for (const task of tasks) {
    charFrequency[task.charCodeAt(0) - 65]++;
  }

  const maxHeap = new MaxHeap();
  for (const freq of charFrequency) {
    if (freq > 0) maxHeap.push(freq);
  }

  let time = 0;

  while (!maxHeap.isEmpty()) {
    const temp = [];
    let cycle = n + 1;

    while (cycle > 0 && !maxHeap.isEmpty()) {
      const curr = maxHeap.pop();
      if (curr > 1) temp.push(curr - 1);
      time++;
      cycle--;
    }

    for (const val of temp) maxHeap.push(val);

    if (!maxHeap.isEmpty()) {
      time += cycle; // idle slots
    }
  }

  return time;
}

// Test cases
const taskSets = [
  [...'AAABBB'],
  [...'AAABBB'],
  [...'AAABBBCC'],
  [...'AAAAA'],
  [...'ABCDEF'],
  [...'AABB'],
  [...'AAAB'],
  [...'AA'],
  [...'A'],
  [...'AAABBC'],
];
const ns       = [2, 0, 2, 2, 2, 1, 2, 3, 0, 2];
const expected = [8, 6, 8, 13, 6, 4, 7, 5, 1, 7];

for (let i = 0; i < taskSets.length; i++) {
  const result = leastIntervals(taskSets[i], ns[i]);
  const status = result === expected[i] ? "✓" : `✗ (expected ${expected[i]})`;
  console.log(`tasks="${taskSets[i].join('')}", n=${ns[i]} => ${result} ${status}`);
}
