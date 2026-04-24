def search_matrix(matrix, target):
    if not matrix or not matrix[0]:
        return False
    rows, cols = len(matrix), len(matrix[0])
    left, right = 0, rows * cols - 1
    while left <= right:
        mid = left + (right - left) // 2
        value = matrix[mid // cols][mid % cols]
        if target > value:
            left = mid + 1
        elif target < value:
            right = mid - 1
        else:
            return True
    return False

if __name__ == "__main__":
    matrix1 = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
    print("Input: matrix1, target=3 -> Output:", search_matrix(matrix1, 3)) # True
    print("Input: matrix1, target=13 -> Output:", search_matrix(matrix1, 13)) # False
    matrix2 = [[1,2,3,4,5]]
    print("Input: matrix2, target=4 -> Output:", search_matrix(matrix2, 4)) # True
    matrix3 = [[1],[3],[5]]
    print("Input: matrix3, target=5 -> Output:", search_matrix(matrix3, 5)) # True
    matrix4 = [[7]]
    print("Input: matrix4, target=7 -> Output:", search_matrix(matrix4, 7)) # True
    print("Input: matrix4, target=2 -> Output:", search_matrix(matrix4, 2)) # False
    matrix5 = []
    print("Input: empty matrix, target=1 -> Output:", False)
