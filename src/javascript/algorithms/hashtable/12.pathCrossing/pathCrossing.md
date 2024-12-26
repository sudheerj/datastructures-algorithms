**Problem statement:**
Given a string `path`, where `path[i] = 'N', 'S', 'E' or 'W'`, each letter representing moving one unit towards north, south, east, or west, respectively. Assume that you started at the origin (0, 0) and walk on the specified path(`path`).

Return `true` if the path crosses same point at any point. otherwise, return `false`.

## Examples:
Example 1:

Input: path = "NESE"

Output: false


Example 2: 

Input: path = "NESW"

Output: true


**Algorithmic Steps**
This problem is solved with the help of a set, which is used to store the visited co-ordinates and determine if the current point is crossed or not. 

1. Define a set variable(`visited`) to keep track of visited co-oridnates.
    
2. Initialize current co-ordinates to (0,0).
   
3. Declare a `directions` object to map the direction with the respective unit points
   
4. Iterate over each character of given path,
   1. Update the current co-ordinates based on each character.
   2. If the updated location is already visited, return true indicating that path is already crossed. 
   3. Add the newly visited co-ordinate/point to the visited set. 
   
5. Return `false` indicating that path didn't cross the same point.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, Where `n` is the length of the path. This is because we traverse the string once and perform constant time operations for lookup in a set.

Here, it takes time complexity of `O(n)`. This is because of the space required by `visited` hash set.
