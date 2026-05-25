"""
Balanced Parentheses (Valid Parentheses - LeetCode 20)

Given a string containing brackets, determine if it is valid.
Approach 1 handles {}()[], Approach 2 also handles <>.

Approach 1: Stack              TC: O(n)  SC: O(n)
Approach 2: HashMap + Stack    TC: O(n)  SC: O(n)
"""


# Approach 1: Stack
def valid_parenthesis1(s):
    if len(s) % 2 != 0:
        return False
    stack = []
    for ch in s:
        if ch in '{([':
            stack.append(ch)
        else:
            if not stack: return False
            top = stack[-1]
            if ch == '}' and top != '{': return False
            if ch == ')' and top != '(': return False
            if ch == ']' and top != '[': return False
            stack.pop()
    return len(stack) == 0


# Approach 2: HashMap + Stack (also handles <>)
def valid_parenthesis2(s):
    if len(s) % 2 != 0:
        return False
    mapping = {')': '(', '}': '{', ']': '[', '>': '<'}
    stack = []
    for ch in s:
        if ch in mapping:
            if not stack or stack.pop() != mapping[ch]:
                return False
        else:
            stack.append(ch)
    return len(stack) == 0


if __name__ == "__main__":
    common_cases = [
        ("{([])}", True,  "{([])}"),
        ("{(][)}", False, "{(][)}"),
        ("()",     True,  "()"),
        ("()[]{}", True,  "()[]{}"),
        ("(]",     False, "(]"),
        ("([)]",   False, "([)]"),
        ("{[]}",   True,  "{[]}"),
        ("(())",   True,  "(())"),
        ("(((", False,  "((("),
    ]
    hm_extras = [
        ("<>",    True,  "<>"),
        ("<(>)",  False, "<(>)"),
    ]

    print("=== Approach 1: Stack ===")
    for s, expected, label in common_cases:
        result = valid_parenthesis1(s)
        status = "PASS" if result == expected else "FAIL"
        print(f'  [{status}] "{label}": {result}  (expected {expected})')

    print("=== Approach 2: HashMap ===")
    for s, expected, label in common_cases + hm_extras:
        result = valid_parenthesis2(s)
        status = "PASS" if result == expected else "FAIL"
        print(f'  [{status}] "{label}": {result}  (expected {expected})')
