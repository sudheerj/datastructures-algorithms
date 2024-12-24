**Description:**
Given an array of `paths`, where `paths[i] = [cityAi, cityBi]` indicates that a direct path exists from cityAi to cityBi. Considering the destination city as a city without any path outgoing to another city, return the destination city.

**Note:** Assume that the graph of paths form a line without any loop.

### Examples
Example 1:

Input: paths = [["Hyderabad","KL"],["KL","Singapore"],["Singapore","Sydney"]]
Output: Sydney

Example 2:

Input: paths = [["New Jersey","Austin"],["New York","New Jersey"],["Austin","Dallas"]]
Output: Dallas

Example 3:

Input: paths = [["Dallas", "London"]],
Output: London

**Algorithmic Steps**
This problem is solved with the help of array traversal and hash set for storing for finding the destination city. The algorithmic approach can be summarized as follows:

1. Create a function named `destinationCity`, which accepts input array(`paths`) to find the destination city.
   
2. Initialize a `fromCities` set variale to store the list of from cities in paths. The given paths array is traversed and `fromCities` is populated with all from city values. 
   
3. Iterate over given array(`path`) agin, return the toCity value as destination city if that city doesn't exist inside `fromCities`. This is because only destination city cannot have a outgoing path.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of path elements in an array. This is because we need to iterate over all the elements at most twice for finding the destination city.
 
It takes constant time complexity of `O(n)` due to a set additional datastructure for storing the from cities.