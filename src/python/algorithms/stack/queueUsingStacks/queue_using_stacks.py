# Approach 1: push O(1), pop/peek O(n)
class QueueUsingStacks1:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    # O(1)
    def push(self, x):
        self.stack1.append(x)

    # O(n)
    def pop(self):
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        res = self.stack1.pop()
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return res

    # O(n)
    def peek(self):
        while len(self.stack1) > 1:
            self.stack2.append(self.stack1.pop())
        res = self.stack1[-1]
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        return res

    # O(1)
    def is_empty(self):
        return len(self.stack1) == 0


# Approach 2: push O(1), pop/peek amortized O(1)
class QueueUsingStacks2:
    def __init__(self):
        self.stack1 = []  # input
        self.stack2 = []  # output

    # O(1)
    def push(self, x):
        self.stack1.append(x)

    # O(1) amortized
    def pop(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    # O(1) amortized
    def peek(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    # O(1)
    def is_empty(self):
        return not self.stack1 and not self.stack2


if __name__ == "__main__":
    print("--- Approach 1: push O(1), pop/peek O(n) ---")

    # Test 1 & 2: pop() returns elements in FIFO order
    q1a = QueueUsingStacks1()
    q1a.push(1); q1a.push(2); q1a.push(3)
    r1 = q1a.pop()
    print(f"Test 1 - pop() first (FIFO): {'[PASS]' if r1 == 1 else '[FAIL]'} result={r1} expected=1")
    r2 = q1a.pop()
    print(f"Test 2 - pop() second (FIFO): {'[PASS]' if r2 == 2 else '[FAIL]'} result={r2} expected=2")

    # Test 3 & 4: peek() returns front without removing
    q1b = QueueUsingStacks1()
    q1b.push(10); q1b.push(20)
    r3 = q1b.peek()
    print(f"Test 3 - peek() returns front: {'[PASS]' if r3 == 10 else '[FAIL]'} result={r3} expected=10")
    r4 = q1b.pop()
    print(f"Test 4 - pop() after peek() still returns front: {'[PASS]' if r4 == 10 else '[FAIL]'} result={r4} expected=10")

    # Test 5: is_empty() on new queue
    q1c = QueueUsingStacks1()
    r5 = q1c.is_empty()
    print(f"Test 5 - is_empty() on new queue: {'[PASS]' if r5 == True else '[FAIL]'} result={r5} expected=True")

    # Test 6: is_empty() after push returns False
    q1c.push(5)
    r6 = q1c.is_empty()
    print(f"Test 6 - is_empty() after push: {'[PASS]' if r6 == False else '[FAIL]'} result={r6} expected=False")

    # Test 7: interleaved push/pop/peek
    q1d = QueueUsingStacks1()
    q1d.push(1); q1d.push(2); q1d.pop(); q1d.push(3)
    r7 = q1d.peek()
    print(f"Test 7 - interleaved push/pop/peek: {'[PASS]' if r7 == 2 else '[FAIL]'} result={r7} expected=2")

    print("\n--- Approach 2: push O(1), pop/peek amortized O(1) ---")

    # Test 1 & 2: pop() returns elements in FIFO order
    q2a = QueueUsingStacks2()
    q2a.push(1); q2a.push(2); q2a.push(3)
    r8 = q2a.pop()
    print(f"Test 1 - pop() first (FIFO): {'[PASS]' if r8 == 1 else '[FAIL]'} result={r8} expected=1")
    r9 = q2a.pop()
    print(f"Test 2 - pop() second (FIFO): {'[PASS]' if r9 == 2 else '[FAIL]'} result={r9} expected=2")

    # Test 3 & 4: peek() returns front without removing
    q2b = QueueUsingStacks2()
    q2b.push(10); q2b.push(20)
    r10 = q2b.peek()
    print(f"Test 3 - peek() returns front: {'[PASS]' if r10 == 10 else '[FAIL]'} result={r10} expected=10")
    r11 = q2b.pop()
    print(f"Test 4 - pop() after peek() still returns front: {'[PASS]' if r11 == 10 else '[FAIL]'} result={r11} expected=10")

    # Test 5: is_empty() on new queue
    q2c = QueueUsingStacks2()
    r12 = q2c.is_empty()
    print(f"Test 5 - is_empty() on new queue: {'[PASS]' if r12 == True else '[FAIL]'} result={r12} expected=True")

    # Test 6: is_empty() after push returns False
    q2c.push(5)
    r13 = q2c.is_empty()
    print(f"Test 6 - is_empty() after push: {'[PASS]' if r13 == False else '[FAIL]'} result={r13} expected=False")

    # Test 7: interleaved push/pop/peek
    q2d = QueueUsingStacks2()
    q2d.push(1); q2d.push(2); q2d.pop(); q2d.push(3)
    r14 = q2d.peek()
    print(f"Test 7 - interleaved push/pop/peek: {'[PASS]' if r14 == 2 else '[FAIL]'} result={r14} expected=2")
