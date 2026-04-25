def simplify_path(path):
    stack = []
    for curr in path.split('/'):
        if curr == '..':
            if stack:
                stack.pop()
        elif curr and curr != '.':
            stack.append(curr)
    return '/' + '/'.join(stack)

if __name__ == "__main__":
    print("Input: /home/ -> Output:", simplify_path("/home/")) # /home
    print("Input: /home/../ -> Output:", simplify_path("/home/../")) # /
    print("Input: /a/./b/../../c/ -> Output:", simplify_path("/a/./b/../../c/")) # /c
    print("Input: /a//b////c/d//././/.. -> Output:", simplify_path("/a//b////c/d//././/..")) # /a/b/c
    print("Input: /../ -> Output:", simplify_path("/../")) # /
    print("Input:  -> Output:", simplify_path("")) # /
