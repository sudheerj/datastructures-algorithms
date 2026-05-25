"""
Asteroid Collision (LeetCode 735)

Given an array of asteroids (positive = right, negative = left), return the
state after all collisions. Larger destroys smaller; equal size destroys both.

TC: O(n)  SC: O(n)
"""


def asteroid_collision(asteroids):
    stack = []

    for a in asteroids:
        while stack and stack[-1] > 0 and a < 0:
            if stack[-1] < -a:       # top is smaller → destroyed
                stack.pop()
                continue
            if stack[-1] == -a:      # equal size → both destroyed
                stack.pop()
                a = 0
                break
            a = 0                    # current is smaller → destroyed
            break

        if a != 0:
            stack.append(a)

    return stack


if __name__ == "__main__":
    test_cases = [
        ([5, 10, -5],    [5, 10],        "-5 destroyed by 10"),
        ([8, -8],        [],             "equal size, both destroyed"),
        ([10, 2, -5],    [10],           "-5 destroys 2, blocked by 10"),
        ([-2, -1, 1, 2], [-2, -1, 1, 2],"no collisions"),
        ([1, -2],        [-2],           "-2 destroys 1 and survives"),
        ([-1, -2, 1, 2], [-1, -2, 1, 2],"left-movers already past right-movers"),
    ]

    for asteroids, expected, label in test_cases:
        result = asteroid_collision(asteroids[:])  # pass a copy
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result}  (expected {expected})")
