# Approach 1: Two Stacks — O(1) all operations, O(n) space
class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val):
        self.stack.append(val)
        if not self.min_stack:
            self.min_stack.append(val)
        else:
            self.min_stack.append(min(val, self.min_stack[-1]))

    def pop(self):
        self.stack.pop()
        self.min_stack.pop()

    def top(self):
        return self.stack[-1]

    def get_min(self):
        return self.min_stack[-1]


# Approach 2: Single Stack with (value, currentMin) pairs — O(1) all operations, O(n) space
class MinStack1:
    def __init__(self):
        self.stack = []  # stores (val, current_min)

    def push(self, val):
        current_min = val if not self.stack else min(val, self.stack[-1][1])
        self.stack.append((val, current_min))

    def pop(self):
        return self.stack.pop()[0]

    def top(self):
        return self.stack[-1][0]

    def get_min(self):
        return self.stack[-1][1]


if __name__ == "__main__":
    print("--- Approach 1: Two Stacks ---")
    ms1 = MinStack()

    ms1.push(5)
    r1 = ms1.get_min()
    print(f"Test 1 - push(5) get_min(): {'[PASS]' if r1 == 5 else '[FAIL]'} result={r1} expected=5")

    ms1.push(3)
    r2 = ms1.get_min()
    print(f"Test 2 - push(3) get_min(): {'[PASS]' if r2 == 3 else '[FAIL]'} result={r2} expected=3")

    ms1.push(7)
    r3 = ms1.get_min()
    print(f"Test 3 - push(7) get_min(): {'[PASS]' if r3 == 3 else '[FAIL]'} result={r3} expected=3")

    ms1.push(2)
    r4 = ms1.get_min()
    print(f"Test 4 - push(2) get_min(): {'[PASS]' if r4 == 2 else '[FAIL]'} result={r4} expected=2")

    r5 = ms1.top()
    print(f"Test 5 - top(): {'[PASS]' if r5 == 2 else '[FAIL]'} result={r5} expected=2")

    ms1.pop()
    r6 = ms1.get_min()
    print(f"Test 6 - pop() 2, get_min(): {'[PASS]' if r6 == 3 else '[FAIL]'} result={r6} expected=3")

    ms1.pop()
    r7 = ms1.get_min()
    print(f"Test 7 - pop() 7, get_min(): {'[PASS]' if r7 == 3 else '[FAIL]'} result={r7} expected=3")

    ms1.pop()
    r8 = ms1.get_min()
    print(f"Test 8 - pop() 3, get_min(): {'[PASS]' if r8 == 5 else '[FAIL]'} result={r8} expected=5")

    print("\n--- Approach 2: Single Stack with (value, min) pairs ---")
    ms2 = MinStack1()

    ms2.push(5)
    r9 = ms2.get_min()
    print(f"Test 1 - push(5) get_min(): {'[PASS]' if r9 == 5 else '[FAIL]'} result={r9} expected=5")

    ms2.push(3)
    r10 = ms2.get_min()
    print(f"Test 2 - push(3) get_min(): {'[PASS]' if r10 == 3 else '[FAIL]'} result={r10} expected=3")

    ms2.push(7)
    r11 = ms2.get_min()
    print(f"Test 3 - push(7) get_min(): {'[PASS]' if r11 == 3 else '[FAIL]'} result={r11} expected=3")

    ms2.push(2)
    r12 = ms2.get_min()
    print(f"Test 4 - push(2) get_min(): {'[PASS]' if r12 == 2 else '[FAIL]'} result={r12} expected=2")

    r13 = ms2.top()
    print(f"Test 5 - top(): {'[PASS]' if r13 == 2 else '[FAIL]'} result={r13} expected=2")

    ms2.pop()
    r14 = ms2.get_min()
    print(f"Test 6 - pop() 2, get_min(): {'[PASS]' if r14 == 3 else '[FAIL]'} result={r14} expected=3")

    ms2.pop()
    r15 = ms2.get_min()
    print(f"Test 7 - pop() 7, get_min(): {'[PASS]' if r15 == 3 else '[FAIL]'} result={r15} expected=3")

    ms2.pop()
    r16 = ms2.get_min()
    print(f"Test 8 - pop() 3, get_min(): {'[PASS]' if r16 == 5 else '[FAIL]'} result={r16} expected=5")
