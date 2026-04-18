// Network Delay Time - Dijkstra's Algorithm
function networkDelayTime(times, n, k) {
  const graph = {};
  for (const [u, v, w] of times) {
    if (!graph[u]) graph[u] = [];
    graph[u].push([v, w]);
  }
  const minHeap = [[0, k]];
  const dist = {};
  while (minHeap.length) {
    minHeap.sort((a, b) => a[0] - b[0]);
    const [time, node] = minHeap.shift();
    if (dist[node] !== undefined) continue;
    dist[node] = time;
    if (graph[node]) {
      for (const [nei, wt] of graph[node]) {
        if (dist[nei] === undefined) {
          minHeap.push([time + wt, nei]);
        }
      }
    }
  }
  return Object.keys(dist).length === n ? Math.max(...Object.values(dist)) : -1;
}

// Test Cases
console.log(networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2)); // 2
console.log(networkDelayTime([[1,2,1]], 2, 1)); // 1
console.log(networkDelayTime([[1,2,1]], 2, 2)); // -1
console.log(networkDelayTime([[1,2,1],[2,3,2]], 4, 1)); // -1
