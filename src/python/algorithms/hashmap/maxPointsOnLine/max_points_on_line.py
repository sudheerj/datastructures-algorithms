"""
Max Points on a Line

Given an array of points, return the maximum number of points
that lie on the same straight line.

Time Complexity: O(n^2)
Space Complexity: O(n)
"""

from math import gcd


def max_points_on_line(points: list[list[int]]) -> int:
    n = len(points)
    if n <= 2:
        return n

    result = 0

    for i in range(n):
        slope_map = {}
        duplicates = 0
        local_max = 0

        for j in range(i + 1, n):
            dx = points[j][0] - points[i][0]
            dy = points[j][1] - points[i][1]

            if dx == 0 and dy == 0:
                duplicates += 1
                continue

            g = gcd(abs(dx), abs(dy))
            dx //= g
            dy //= g

            # Normalize sign: keep dx >= 0; if dx == 0 keep dy > 0
            if dx < 0:
                dx, dy = -dx, -dy
            elif dx == 0:
                dy = abs(dy)

            key = (dx, dy)
            slope_map[key] = slope_map.get(key, 0) + 1
            local_max = max(local_max, slope_map[key])

        result = max(result, local_max + duplicates + 1)

    return result


if __name__ == "__main__":
    test_cases = [
        ([[1, 1], [2, 2], [3, 3]], 3, "all collinear"),
        ([[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]], 4, "LeetCode example 2"),
        ([[0, 0]], 1, "single point"),
        ([[0, 0], [1, 0], [2, 0]], 3, "horizontal line"),
        ([[0, 0], [0, 1], [0, 2]], 3, "vertical line"),
        ([[0, 0], [0, 0], [1, 1]], 3, "duplicate points"),
    ]

    for points, expected, label in test_cases:
        result = max_points_on_line(points)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {points} → {result} (expected {expected})")
