# Largest Rectangle in Histogram
# Monotonic increasing stack, TC: O(n), SC: O(n)

def largest_rectangle(heights):
    stack = []
    max_area = 0
    for i in range(len(heights) + 1):
        curr_height = 0 if i == len(heights) else heights[i]
        while stack and curr_height < heights[stack[-1]]:
            height = heights[stack.pop()]
            width = i if not stack else i - stack[-1] - 1
            max_area = max(max_area, width * height)
        stack.append(i)
    return max_area

if __name__ == "__main__":
    test_cases = [
        ([2,1,5,6,2,3], 10),
        ([2,4], 4),
        ([1,1,1,1], 4),
        ([6,2,5,4,5,1,6], 12),
        ([2,1,2], 3),
        ([], 0),
        ([1], 1),
        ([2,1,2,3,1], 4)
    ]
    for heights, expected in test_cases:
        result = largest_rectangle(heights)
        status = "✓" if result == expected else f"✗ (expected {expected})"
        print(f'{heights} => {result} {status}')
