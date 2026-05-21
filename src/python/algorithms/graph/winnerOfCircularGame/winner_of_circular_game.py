# Winner of Circular Game (Josephus Problem)
# n friends in a circle; every k-th friend is eliminated. Return the winner.
# Approach 1: Queue Simulation — TC: O(n * k), SC: O(n)
# Approach 2: Iterative Josephus — TC: O(n), SC: O(1)
# Approach 3: Recursive Josephus — TC: O(n), SC: O(n)

from collections import deque


# Approach 1: Queue Simulation — TC: O(n * k), SC: O(n)
def winner_of_circular_game1(n: int, k: int) -> int:
    queue = deque(range(1, n + 1))
    while len(queue) > 1:
        # Move k-1 people from front to back
        for _ in range(k - 1):
            queue.append(queue.popleft())
        # Eliminate the k-th person
        queue.popleft()
    return queue[0]


# Approach 2: Iterative Josephus — TC: O(n), SC: O(1)
def winner_of_circular_game2(n: int, k: int) -> int:
    winner = 0  # base case: 1 person, 0-based index
    for i in range(2, n + 1):
        winner = (winner + k) % i
    return winner + 1  # convert to 1-based


# Approach 3: Recursive Josephus — TC: O(n), SC: O(n)
def winner_of_circular_game3(n: int, k: int) -> int:
    return _josephus(n, k) + 1


def _josephus(n: int, k: int) -> int:
    if n == 1:
        return 0
    return (_josephus(n - 1, k) + k) % n


# Test cases
tests = [(5, 2, 3), (6, 5, 1), (1, 1, 1), (4, 1, 4), (3, 3, 2)]

print('=== Queue Simulation ===')
for i, (n, k, expected) in enumerate(tests, 1):
    print(f'Test {i}: {winner_of_circular_game1(n, k)} (expected {expected})')

print('=== Iterative Josephus ===')
for i, (n, k, expected) in enumerate(tests, 1):
    print(f'Test {i}: {winner_of_circular_game2(n, k)} (expected {expected})')

print('=== Recursive Josephus ===')
for i, (n, k, expected) in enumerate(tests, 1):
    print(f'Test {i}: {winner_of_circular_game3(n, k)} (expected {expected})')
