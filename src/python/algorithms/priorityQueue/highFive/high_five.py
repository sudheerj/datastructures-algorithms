# High Five
# Given [student_id, score] pairs, return [[id, floor(top5_avg)], ...] sorted by id.
# TC: O(n log 5) = O(n), SC: O(k) where k = number of distinct students

import heapq
from collections import defaultdict


def high_five(items: list[list[int]]) -> list[list[int]]:
    scores: dict[int, list[int]] = defaultdict(list)

    for student_id, score in items:
        heapq.heappush(scores[student_id], score)
        if len(scores[student_id]) > 5:
            heapq.heappop(scores[student_id])  # evict lowest

    return [
        [student_id, sum(scores[student_id]) // 5]
        for student_id in sorted(scores)
    ]


# Test cases
tests = [
    (
        [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[2,100],[1,87],[1,100],[2,76]],
        [[1, 87], [2, 88]],
    ),
    (
        [[1,90],[1,80],[1,70],[1,60],[1,50]],
        [[1, 70]],
    ),
    (
        [[1,100],[1,100],[1,100],[1,100],[1,100],[1,1]],
        [[1, 100]],
    ),
    (
        [[1,100],[2,100],[3,100],[1,80],[2,80],[3,80],
         [1,60],[2,60],[3,60],[1,40],[2,40],[3,40],[1,20],[2,20],[3,20]],
        [[1, 60], [2, 60], [3, 60]],
    ),
    (
        [[1,88],[1,89],[1,90],[1,91],[1,92]],
        [[1, 90]],
    ),
    (
        [[3,80],[3,80],[3,80],[3,80],[3,80],[1,60],[1,60],[1,60],[1,60],[1,60]],
        [[1, 60], [3, 80]],
    ),
]

for items, expected in tests:
    result = high_five(items)
    status = "✓" if result == expected else f"✗ (expected {expected})"
    print(f"high_five({items}) => {result} {status}")
