def get_slope(p1, p2):
    dx = p2[0] - p1[0]
    dy = p2[1] - p1[1]
    if dx == 0:
        return float('inf')
    slope = dy / dx
    return 0.0 if slope == 0.0 else slope


def max_points_on_line(points):
    max_pts = 1
    n = len(points)
    for i in range(n):
        count = {}
        for j in range(i + 1, n):
            slope = get_slope(points[i], points[j])
            count[slope] = count.get(slope, 0) + 1
            max_pts = max(max_pts, count[slope] + 1)
    return max_pts


if __name__ == "__main__":
    points1 = [[1, 1], [2, 2], [3, 3]]
    r1 = max_points_on_line(points1)
    print(f"Test 1 - 3 collinear diagonal: {'[PASS]' if r1 == 3 else '[FAIL]'} result={r1} expected=3")

    points2 = [[1, 1], [2, 2], [3, 3], [4, 5]]
    r2 = max_points_on_line(points2)
    print(f"Test 2 - 3 collinear one outlier: {'[PASS]' if r2 == 3 else '[FAIL]'} result={r2} expected=3")

    points3 = [[0, 0], [1, 0], [2, 0], [3, 0]]
    r3 = max_points_on_line(points3)
    print(f"Test 3 - 4 collinear horizontal: {'[PASS]' if r3 == 4 else '[FAIL]'} result={r3} expected=4")

    points4 = [[0, 0], [2, 1], [4, 3]]
    r4 = max_points_on_line(points4)
    print(f"Test 4 - no 3 collinear fractional slopes: {'[PASS]' if r4 == 2 else '[FAIL]'} result={r4} expected=2")

    points5 = [[0, 0]]
    r5 = max_points_on_line(points5)
    print(f"Test 5 - single point: {'[PASS]' if r5 == 1 else '[FAIL]'} result={r5} expected=1")
