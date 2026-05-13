# Task Scheduler
# Given a list of tasks and cooldown n, return the minimum CPU intervals
# needed to finish all tasks (same task must wait n intervals between runs).
# TC: O(T log 26) ~= O(T), SC: O(1)

import heapq

def least_intervals(tasks: list[str], n: int) -> int:
    char_frequency = [0] * 26
    for task in tasks:
        char_frequency[ord(task) - ord('A')] += 1

    # Max-heap via negated values
    max_heap = [-f for f in char_frequency if f > 0]
    heapq.heapify(max_heap)

    time = 0

    while max_heap:
        temp = []
        cycle = n + 1

        while cycle > 0 and max_heap:
            curr = -heapq.heappop(max_heap)
            if curr > 1:
                temp.append(-(curr - 1))
            time += 1
            cycle -= 1

        for val in temp:
            heapq.heappush(max_heap, val)

        if max_heap:
            time += cycle  # idle slots

    return time


# Test cases
task_sets = [
    list("AAABBB"),
    list("AAABBB"),
    list("AAABBBCC"),
    list("AAAAA"),
    list("ABCDEF"),
    list("AABB"),
    list("AAAB"),
    list("AA"),
    list("A"),
    list("AAABBC"),
]
ns       = [2, 0, 2, 2, 2, 1, 2, 3, 0, 2]
expected = [8, 6, 8, 13, 6, 4, 7, 5, 1, 7]

for i in range(len(task_sets)):
    result = least_intervals(task_sets[i], ns[i])
    status = "✓" if result == expected[i] else f"✗ (expected {expected[i]})"
    print(f'tasks="{"".join(task_sets[i])}", n={ns[i]} => {result} {status}')
