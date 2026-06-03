def minimumEffort(tasks):
    # Sort by (required - cost) descending
    tasks = sorted(tasks, key=lambda x: (x[1] - x[0]), reverse=True)
    energy = 0
    for cost, req in tasks:
        energy = max(energy + cost, req)
    return energy

def run_tests():
    tests = [
        ([[1,2],[2,4],[4,8]], 8),
        ([[1,3],[2,4],[10,11],[10,12],[8,9]], 32),
        ([[1,7],[2,8],[3,9],[4,10]], 19),
        ([[5,9],[2,8],[3,7],[1,5]], 17),
        ([[1,2],[2,2],[3,3]], 6),
    ]
    for i, (tasks, expected) in enumerate(tests, 1):
        result = minimumEffort([list(t) for t in tasks])
        print(f"Test {i}: Output={result}, Expected={expected} [{'PASS' if result==expected else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()
