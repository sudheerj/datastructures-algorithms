"""
Open the Lock (LeetCode 752)

Find the minimum number of turns to reach target from "0000",
avoiding deadend combinations. Return -1 if impossible.

Approach: BFS level-by-level
TC: O(10^4 * 4 * 2)  SC: O(10^4)
"""

from collections import deque


def open_the_lock(deadends, target):
    dead = set(deadends)

    # cannot start if starting point itself is blocked
    if "0000" in dead:
        return 0

    queue = deque(["0000"])
    visited = {"0000"}
    steps = 0

    while queue:
        size = len(queue)

        # process one BFS level
        for _ in range(size):
            current = queue.popleft()

            # found target
            if current == target:
                return steps

            arr = list(current)

            # try rotating 4 wheels
            for j in range(4):
                original = arr[j]

                # two directions: +1 or -1
                for move in (1, -1):
                    arr[j] = str((int(original) + move + 10) % 10)
                    nxt = "".join(arr)

                    # next state
                    if nxt not in dead and nxt not in visited:
                        visited.add(nxt)
                        queue.append(nxt)

                arr[j] = original

        steps += 1

    return -1


if __name__ == "__main__":
    test_cases = [
        (["0201","0101","0102","1212","2002"], "0202",  6,  "classic example"),
        (["8888"],                             "0009",  1,  "one-step rotation"),
        (["8887","8889","8878","8898",
          "8788","8988","7888","9888"],        "8888", -1,  "target surrounded by deadends"),
        (["0000"],                             "8888",  0,  "start is a deadend"),
        ([],                                   "0001",  1,  "no deadends — one step"),
        (["1234"],                             "0000",  0,  "target is starting position"),
    ]

    for deadends, target, expected, label in test_cases:
        result = open_the_lock(deadends, target)
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {result} (expected {expected})")
