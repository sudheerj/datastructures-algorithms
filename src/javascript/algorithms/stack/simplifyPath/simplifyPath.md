## Simplify Path

Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, simplify it.

### Examples

**Example 1**
Input: /home/
Output: /home

**Example 2**
Input: /home/../
Output: /

**Example 3**
Input: /a/./b/../../c/
Output: /c

**Example 4**
Input: /a//b////c/d//././/..
Output: /a/b/c

**Example 5**
Input: /../
Output: /

**Example 6**
Input: (empty string)
Output: /

### Approach
- Use a stack to process path segments.
- Ignore '.' and empty segments, pop for '..', push valid names.
- Time Complexity: O(n)
- Space Complexity: O(n)
