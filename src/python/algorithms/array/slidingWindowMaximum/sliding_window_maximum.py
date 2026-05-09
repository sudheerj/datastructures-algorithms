from collections import deque

def sliding_window_maximum(nums: list[int], k: int) -> list[int]:
    n = len(nums)
    output = []
    q = deque()  # stores indices
    left = 0

    for right in range(n):
        # Remove elements smaller than current from the back
        while q and nums[q[-1]] < nums[right]:
            q.pop()

        q.append(right)

        # Remove front if it's outside the window
        if left > q[0]:
            q.popleft()

        # Start recording once the first full window is reached
        if right + 1 >= k:
            output.append(nums[q[0]])
            left += 1

    return output


print(sliding_window_maximum([1, 3, -1, -3, 5, 3, 6, 7], 3))  # [3,3,5,5,6,7]
print(sliding_window_maximum([1], 1))                          # [1]
print(sliding_window_maximum([1, -1], 1))                      # [1,-1]
print(sliding_window_maximum([9, 11], 2))                      # [11]
print(sliding_window_maximum([4, -2], 2))                      # [4]
print(sliding_window_maximum([1, 3, 1, 2, 0, 5], 3))          # [3,3,2,5]
