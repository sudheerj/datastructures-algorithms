# HashSet + diagonal pair enumeration — TC: O(n²)  SC: O(n)
def max_area_rectangle(points):
    point_set = set()
    for x, y in points:
        point_set.add((x, y))

    max_area = 0
    n = len(points)

    for i in range(n):
        for j in range(i + 1, n):
            x1, y1 = points[i]
            x2, y2 = points[j]

            # skip same row or column (no rectangle possible)
            if x1 == x2 or y1 == y2:
                continue

            # check if the other two corners exist
            if (x1, y2) in point_set and (x2, y1) in point_set:
                area = abs(x1 - x2) * abs(y1 - y2)
                max_area = max(max_area, area)

    return max_area


if __name__ == "__main__":
    points1 = [[1,1],[1,3],[3,1],[3,3],[2,2]]
    r1 = max_area_rectangle(points1)
    print(f"Test 1 - corners at (1,1)(3,3): {'[PASS]' if r1 == 4 else '[FAIL]'} result={r1} expected=4")

    points2 = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
    r2 = max_area_rectangle(points2)
    print(f"Test 2 - max rect is 3x2: {'[PASS]' if r2 == 6 else '[FAIL]'} result={r2} expected=6")

    points3 = [[0,0],[0,1],[1,0],[1,1]]
    r3 = max_area_rectangle(points3)
    print(f"Test 3 - unit square: {'[PASS]' if r3 == 1 else '[FAIL]'} result={r3} expected=1")

    points4 = [[0,0],[0,2],[3,0],[3,2]]
    r4 = max_area_rectangle(points4)
    print(f"Test 4 - 3x2 rectangle: {'[PASS]' if r4 == 6 else '[FAIL]'} result={r4} expected=6")

    points5 = [[1,1],[2,2],[3,1],[1,3]]
    r5 = max_area_rectangle(points5)
    print(f"Test 5 - no valid rectangle: {'[PASS]' if r5 == 0 else '[FAIL]'} result={r5} expected=0")
