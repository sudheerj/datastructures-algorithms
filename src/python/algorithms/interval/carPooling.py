def carPooling1(trips, capacity):
    occupancy = [0] * 1001
    for people, start, end in trips:
        occupancy[start] += people
        occupancy[end] -= people
    curr = 0
    for occ in occupancy:
        curr += occ
        if curr > capacity:
            return False
    return True

def carPooling2(trips, capacity):
    trips = sorted(trips, key=lambda x: x[1])
    import heapq
    pq = []
    curr = 0
    for people, start, end in trips:
        while pq and pq[0][0] <= start:
            curr -= heapq.heappop(pq)[1]
        curr += people
        if curr > capacity:
            return False
        heapq.heappush(pq, (end, people))
    return True

def carPooling3(trips, capacity):
    events = []
    for people, start, end in trips:
        events.append((start, people))
        events.append((end, -people))
    events.sort()
    curr = 0
    for _, change in events:
        curr += change
        if curr > capacity:
            return False
    return True

def carPooling4(trips, capacity):
    occupancy = [0] * 1001
    for people, start, end in trips:
        for i in range(start, end):
            occupancy[i] += people
            if occupancy[i] > capacity:
                return False
    return True

def deep_copy(arr):
    return [x[:] for x in arr]

def run_tests():
    tests = [
        ([[2,1,5],[3,3,7]], 4, False),
        ([[2,1,5],[3,3,7]], 5, True),
        ([[3,2,7],[3,7,9],[8,3,9]], 11, True),
        ([[3,2,7],[3,7,9],[8,3,9]], 10, False),
        ([[2,1,5],[3,5,7]], 3, True),
        ([[2,1,5],[3,5,7]], 2, False),
        ([[9,0,1],[3,3,7]], 10, True),
    ]
    print("Testing carPooling1 (difference array):")
    for i, (trips, cap, exp) in enumerate(tests):
        result = carPooling1(deep_copy(trips), cap)
        print(f"Test {i+1}: Output={result}, Expected={exp} [{'PASS' if result == exp else 'FAIL'}]")
    print("\nTesting carPooling2 (min heap):")
    for i, (trips, cap, exp) in enumerate(tests):
        result = carPooling2(deep_copy(trips), cap)
        print(f"Test {i+1}: Output={result}, Expected={exp} [{'PASS' if result == exp else 'FAIL'}]")
    print("\nTesting carPooling3 (event sweep):")
    for i, (trips, cap, exp) in enumerate(tests):
        result = carPooling3(deep_copy(trips), cap)
        print(f"Test {i+1}: Output={result}, Expected={exp} [{'PASS' if result == exp else 'FAIL'}]")
    print("\nTesting carPooling4 (bruteforce):")
    for i, (trips, cap, exp) in enumerate(tests):
        result = carPooling4(deep_copy(trips), cap)
        print(f"Test {i+1}: Output={result}, Expected={exp} [{'PASS' if result == exp else 'FAIL'}]")

if __name__ == "__main__":
    run_tests()
