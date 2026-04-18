# Network Delay Time - Dijkstra's Algorithm

def network_delay_time(times, n, k):
    import heapq
    from collections import defaultdict
    graph = defaultdict(list)
    for u, v, w in times:
        graph[u].append((v, w))
    min_heap = [(0, k)]
    dist = {}
    while min_heap:
        time, node = heapq.heappop(min_heap)
        if node in dist:
            continue
        dist[node] = time
        for nei, wt in graph[node]:
            if nei not in dist:
                heapq.heappush(min_heap, (time + wt, nei))
    return max(dist.values()) if len(dist) == n else -1

if __name__ == "__main__":
    # Test Case 1
    print(network_delay_time([[2,1,1],[2,3,1],[3,4,1]], 4, 2)) # 2
    # Test Case 2
    print(network_delay_time([[1,2,1]], 2, 1)) # 1
    # Test Case 3
    print(network_delay_time([[1,2,1]], 2, 2)) # -1
    # Test Case 4
    print(network_delay_time([[1,2,1],[2,3,2]], 4, 1)) # -1
