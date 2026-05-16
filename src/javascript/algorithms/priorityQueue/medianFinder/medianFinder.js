// Median Finder (Find Median from Data Stream)
// Design a data structure supporting addNum and findMedian on a live integer stream.
// TC: addNum -> O(log n), findMedian -> O(1), SC: O(n)

class MaxHeap {
  constructor() { this.heap = []; }
  push(val) {
    this.heap.push(val);
    this._bubbleUp(this.heap.length - 1);
  }
  pop() {
    const top = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) { this.heap[0] = last; this._siftDown(0); }
    return top;
  }
  peek() { return this.heap[0]; }
  size() { return this.heap.length; }
  _bubbleUp(i) {
    while (i > 0) {
      const p = Math.floor((i - 1) / 2);
      if (this.heap[p] >= this.heap[i]) break;
      [this.heap[p], this.heap[i]] = [this.heap[i], this.heap[p]];
      i = p;
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

class MinHeap {
  constructor() { this.heap = []; }
  push(val) {
    this.heap.push(val);
    this._bubbleUp(this.heap.length - 1);
  }
  pop() {
    const top = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) { this.heap[0] = last; this._siftDown(0); }
    return top;
  }
  peek() { return this.heap[0]; }
  size() { return this.heap.length; }
  _bubbleUp(i) {
    while (i > 0) {
      const p = Math.floor((i - 1) / 2);
      if (this.heap[p] <= this.heap[i]) break;
      [this.heap[p], this.heap[i]] = [this.heap[i], this.heap[p]];
      i = p;
    }
  }
  _siftDown(i) {
    const n = this.heap.length;
    while (true) {
      let smallest = i;
      const l = 2 * i + 1, r = 2 * i + 2;
      if (l < n && this.heap[l] < this.heap[smallest]) smallest = l;
      if (r < n && this.heap[r] < this.heap[smallest]) smallest = r;
      if (smallest === i) break;
      [this.heap[smallest], this.heap[i]] = [this.heap[i], this.heap[smallest]];
      i = smallest;
    }
  }
}

class MedianFinder {
  constructor() {
    this.maxHeap = new MaxHeap(); // lower half
    this.minHeap = new MinHeap(); // upper half
  }

  addNum(num) {
    this.maxHeap.push(num);
    this.minHeap.push(this.maxHeap.pop());
    if (this.maxHeap.size() < this.minHeap.size()) {
      this.maxHeap.push(this.minHeap.pop());
    }
  }

  findMedian() {
    if (this.maxHeap.size() === this.minHeap.size()) {
      return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
    }
    return this.maxHeap.peek();
  }
}

// Test cases
const tests = [
  { nums: [1, 2, 3],             expected: 2.0  },
  { nums: [1, 2],                expected: 1.5  },
  { nums: [5],                   expected: 5.0  },
  { nums: [40, 30, 50, 10, 20],  expected: 30.0 },
  { nums: [1, 7, 3, 9, 2, 8],    expected: 5.0  },
];

for (const { nums, expected } of tests) {
  const mf = new MedianFinder();
  for (const n of nums) mf.addNum(n);
  const result = mf.findMedian();
  const status = result === expected ? '✓' : `✗ (expected ${expected})`;
  console.log(`addNum(${JSON.stringify(nums)}) => findMedian() = ${result} ${status}`);
}
