def get_skyline(buildings):
    # Sweep-line + multiset (TreeMap equivalent)
    import heapq
    events = []
    for l, r, h in buildings:
        events.append((l, -h))  # start
        events.append((r, h))   # end
    events.sort(key=lambda x: (x[0], x[1]))
    import collections
    heights = collections.Counter()
    heights[0] = 1
    result = []
    prev_max = 0
    for x, h in events:
        if h < 0:
            heights[-h] += 1
        else:
            heights[h] -= 1
            if heights[h] == 0:
                del heights[h]
        curr_max = max(heights)
        if curr_max != prev_max:
            result.append([x, curr_max])
            prev_max = curr_max
    return result

if __name__ == "__main__":
    tests = [
        ([[1,2,1]], [[1,1],[2,0]]),
        ([[0,2,3],[2,5,3]], [[0,3],[5,0]]),
        ([[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]], [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]),
        ([[1,3,4],[3,4,4],[2,6,2]], [[1,4],[4,2],[6,0]]),
    ]
    for buildings, expected in tests:
        result = get_skyline(buildings)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
