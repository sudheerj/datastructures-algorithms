function simplifyPath(path) {
    const stack = [];
    for (const curr of path.split('/')) {
        if (curr === '..') {
            if (stack.length) stack.pop();
        } else if (curr && curr !== '.') {
            stack.push(curr);
        }
    }
    return '/' + stack.join('/');
}

console.log("Input: /home/ -> Output:", simplifyPath("/home/")); // /home
console.log("Input: /home/../ -> Output:", simplifyPath("/home/../")); // /
console.log("Input: /a/./b/../../c/ -> Output:", simplifyPath("/a/./b/../../c/")); // /c
console.log("Input: /a//b////c/d//././/.. -> Output:", simplifyPath("/a//b////c/d//././/..")); // /a/b/c
console.log("Input: /../ -> Output:", simplifyPath("/../")); // /
console.log("Input:  -> Output:", simplifyPath("")); // /
