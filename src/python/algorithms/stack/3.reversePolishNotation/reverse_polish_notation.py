"""
Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def eval_rpn(tokens):
    """
    Using stack.
    TC: O(n), SC: O(n)
    """
    stack = []
    operators = {'+', '-', '*', '/'}
    
    for token in tokens:
        if token in operators:
            b = stack.pop()
            a = stack.pop()
            
            if token == '+':
                stack.append(a + b)
            elif token == '-':
                stack.append(a - b)
            elif token == '*':
                stack.append(a * b)
            elif token == '/':
                stack.append(int(a / b))  # Truncate toward zero
        else:
            stack.append(int(token))
    
    return stack[0]


# Test cases
if __name__ == "__main__":
    test_cases = [
        ["2", "1", "+", "3", "*"],           # ((2 + 1) * 3) = 9
        ["4", "13", "5", "/", "+"],          # (4 + (13 / 5)) = 6
        ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"],  # 22
    ]
    
    for tokens in test_cases:
        print(f"Tokens: {tokens}")
        print(f"Result: {eval_rpn(tokens)}")
        print()
