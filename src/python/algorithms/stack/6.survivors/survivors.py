"""
Survivors (Fish Problem)

Given arrays A (sizes) and B (directions: 0=upstream, 1=downstream),
determine the number of fish that survive after all encounters.
A downstream fish meeting an upstream fish results in the larger one eating the smaller.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def survivors(a, b):
    """
    Stack-based approach to simulate fish encounters.
    TC: O(n), SC: O(n)
    """
    downstream = []
    survivor_count = 0

    for i in range(len(a)):
        if b[i] == 1:
            # Fish moving downstream - store its size
            downstream.append(a[i])
        else:
            # Fish moving upstream - fight any downstream fish
            while downstream:
                if downstream[-1] > a[i]:
                    # Downstream fish eats upstream fish
                    break
                else:
                    # Upstream fish eats downstream fish
                    downstream.pop()
            else:
                # No downstream fish left, upstream fish survives
                survivor_count += 1

    # Survived upstream fish + all downstream fish left
    return survivor_count + len(downstream)


# Test cases
if __name__ == "__main__":
    test_cases = [
        ([4, 3, 2, 1, 5], [0, 1, 0, 0, 0], 2),
        ([1, 2, 3, 4, 5], [0, 0, 0, 0, 0], 5),
        ([5, 4, 3, 2, 1], [1, 1, 1, 1, 1], 5),
        ([5, 3, 8, 6, 2], [1, 1, 0, 0, 0], 3),
        ([5], [1], 1),
    ]

    for a, b, expected in test_cases:
        result = survivors(a, b)
        status = "Passed" if result == expected else "Failed"
        print(f"{status} | A={a}, B={b} | Output: {result} | Expected: {expected}")
