"""
Sort Stack

Sort a stack using only stack operations (push, pop, peek, isEmpty).

Time Complexity: O(n^2)
Space Complexity: O(n)
"""


def sort_stack(stack):
    """
    Sort stack using an auxiliary stack.
    TC: O(n^2), SC: O(n)
    """
    aux_stack = []
    
    while stack:
        temp = stack.pop()
        
        while aux_stack and aux_stack[-1] > temp:
            stack.append(aux_stack.pop())
        
        aux_stack.append(temp)
    
    # Transfer back to original stack
    while aux_stack:
        stack.append(aux_stack.pop())
    
    return stack


# Test case
if __name__ == "__main__":
    stack = [34, 3, 31, 98, 92, 23]
    
    print(f"Original stack: {stack}")
    sort_stack(stack)
    print(f"Sorted stack: {stack}")  # [3, 23, 31, 34, 92, 98] (top on right)
