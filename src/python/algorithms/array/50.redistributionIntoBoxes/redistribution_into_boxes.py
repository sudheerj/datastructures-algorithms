# TC: O(m log m + n) SC: O(n)
def min_boxes(apples, capacity):
    total = sum(apples)
    capacity.sort(reverse=True)

    min_boxes = 0
    for cap in capacity:
        total -= cap
        min_boxes += 1
        if total <= 0:
            break

    return min_boxes


# Test cases
if __name__ == "__main__":
    # Test 1: General case
    print("Test 1:", min_boxes([1, 3, 2], [4, 3, 1, 5, 2]))  # 2

    # Test 2: Single apple pack, single box
    print("Test 2:", min_boxes([5], [5]))  # 1

    # Test 3: All apples fit in one large box
    print("Test 3:", min_boxes([2, 3, 1], [10, 1, 1]))  # 1

    # Test 4: Each box holds exactly one apple pack
    print("Test 4:", min_boxes([1, 1, 1], [1, 1, 1]))  # 3

    # Test 5: Need all boxes
    print("Test 5:", min_boxes([5, 5, 5], [5, 5, 5]))  # 3

    # Test 6: Boxes much larger than needed
    print("Test 6:", min_boxes([1], [100, 50, 25]))  # 1
