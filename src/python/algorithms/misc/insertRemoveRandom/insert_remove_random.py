import random


class InsertRemoveRandom:
    def __init__(self):
        self.num_map = {}  # val -> index
        self.nums = []

    # O(1) average
    def insert(self, val):
        if val in self.num_map:
            return False
        self.num_map[val] = len(self.nums)
        self.nums.append(val)
        return True

    # O(1) average
    def remove(self, val):
        if val not in self.num_map:
            return False
        index = self.num_map[val]
        last = self.nums[-1]
        self.nums[index] = last
        self.num_map[last] = index
        self.nums.pop()
        del self.num_map[val]
        return True

    # O(1)
    def get_random_value(self):
        return random.choice(self.nums)


if __name__ == "__main__":
    obj = InsertRemoveRandom()

    # Test 1: insert new element → True
    r1 = obj.insert(1)
    print(f"Test 1 - insert(1) new element: {'[PASS]' if r1 == True else '[FAIL]'} result={r1} expected=True")

    # Test 2: insert duplicate → False
    r2 = obj.insert(1)
    print(f"Test 2 - insert(1) duplicate: {'[PASS]' if r2 == False else '[FAIL]'} result={r2} expected=False")

    # Test 3 & 4: insert more elements
    r3 = obj.insert(2)
    print(f"Test 3 - insert(2): {'[PASS]' if r3 == True else '[FAIL]'} result={r3} expected=True")
    r4 = obj.insert(3)
    print(f"Test 4 - insert(3): {'[PASS]' if r4 == True else '[FAIL]'} result={r4} expected=True")

    # Test 5: remove existing element → True
    r5 = obj.remove(2)
    print(f"Test 5 - remove(2) exists: {'[PASS]' if r5 == True else '[FAIL]'} result={r5} expected=True")

    # Test 6: remove already-removed element → False
    r6 = obj.remove(2)
    print(f"Test 6 - remove(2) already removed: {'[PASS]' if r6 == False else '[FAIL]'} result={r6} expected=False")

    # Test 7: remove element that never existed → False
    r7 = obj.remove(99)
    print(f"Test 7 - remove(99) never existed: {'[PASS]' if r7 == False else '[FAIL]'} result={r7} expected=False")

    # Test 8: get_random_value() returns element from current set {1, 3}
    valid8 = {1, 3}
    r8 = obj.get_random_value()
    print(f"Test 8 - get_random_value() in {{1,3}}: {'[PASS]' if r8 in valid8 else '[FAIL]'} result={r8} expected=one of {{1,3}}")

    # Test 9: get_random_value() after insert; set becomes {1, 3, 4}
    obj.insert(4)
    valid9 = {1, 3, 4}
    r9 = obj.get_random_value()
    print(f"Test 9 - get_random_value() in {{1,3,4}}: {'[PASS]' if r9 in valid9 else '[FAIL]'} result={r9} expected=one of {{1,3,4}}")
