"""
Interval List Intersections

Given two lists of closed intervals, each list pairwise disjoint and sorted,
return the intersection of the two interval lists.

Time Complexity: O(n + m)
Space Complexity: O(1) excluding result
"""

def list_intersection(first_list, second_list):
    result = []
    i, j = 0, 0

    while i < len(first_list) and j < len(second_list):
        first_start, first_end = first_list[i]
        second_start, second_end = second_list[j]

        start = max(first_start, second_start)
        end = min(first_end, second_end)

        # Verify valid intersection
        if start <= end:
            result.append([start, end])

        # Move the pointer with smaller end
        if first_end < second_end:
            i += 1
        else:
            j += 1

    return result


if __name__ == "__main__":
    # Test 1: General case with multiple overlaps
    print(list_intersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]]))
    # [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    # Test 2: Simple partial overlap
    print(list_intersection([[0,2],[5,10]], [[1,5],[8,12]]))
    # [[1,2],[5,5],[8,10]]

    # Test 3: No overlaps
    print(list_intersection([[0,2],[5,7]], [[3,4],[8,10]]))
    # []

    # Test 4: One list is empty
    print(list_intersection([[0,5]], []))
    # []

    # Test 5: Complete containment
    print(list_intersection([[1,10]], [[2,3],[4,6]]))
    # [[2,3],[4,6]]

    # Test 6: Same intervals
    print(list_intersection([[1,5]], [[1,5]]))
    # [[1,5]]
