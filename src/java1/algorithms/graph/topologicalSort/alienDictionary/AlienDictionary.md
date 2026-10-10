**Problem statement:**
There is a new Alien language which uses the latin alphabet, but the order among letters is not same as English alphabet(i.e, a, b, c ... z).

Given a list of non-empty strings `words` from the dictionary, where the words are sorted lexicographically by the rules of this new language

Calculate the order of letters in this language. If the order is invalid, return an empty string. If there are multiple valid order of letters, return any of them.

**Note:** 
A string `x` is lexicographically smaller than a string `y` if either of the following is true:

1. The first letter where they differ is smaller in `x` than in `y`.
2. There is no index `i `such that `x[i] != y[i]` and `x.length < y.length`.

## Examples:
Example1:

Input: ["grs","grk","dr","dss","rkss"]

Output: "gdrsk"


Example2:

Input: ["t","r"]

Output: "tr"


**Algorithmic Steps**
This problem is solved by Kahn's algorithm for topological sorting. Here, the main intuition behind this problem is build a directed graph by comparing each letter between pair of words which are lexographically sorted. Later we perform the BFS traversal by visit node level by level. The characters are added to the queue when the indree of those characters is zero. The algorithmic approach can be summarized as follows: 

1. Create a function(`alienOrder1`) to determine the order of letters in Alien language. It accepts list of words(`words`) as input parameter.

2. Create an empty adjacency list(`adjList`) which is used to store directed letters for each letter. This list is filled by comparing the consecutive pair of words. Also, create an indgree array(`indegree`) with default values of 0 to count the incoming edges for a node, and uniqueLetters set to store the unique characters of given Alien dictionary words.

3. Build a adjancency list for the graph based on given words in the following step by process.
   1. Iterate over the dictionary words and compare the consequtive words. If the `i`th index word's length is greater than `i+1` word and `i`th word starts with `i+1` word, return an empty string as an output since there is no possible order of characters with the given words.
   2. Run a nested loop to the length of smallest word of `i` and `i+1` indexed words. Compare each character on both words and find a differentiating character to build the adjacency list and create a graph.
   3. Update the indegree(incoming edges count) for the characters adn exit from the nested loop.
   
4. Once the graph is build, perform a topological sort using BFS traversal with following steps.
   1. Fill the unique characters(`unique characters`) by iterating over each word and each character. This set is used to fill the queue whose indgree value is zero.
   2. Iterate over the unique characters and add to the queue if the indgree of character is zero.
   3. Iterate over the queue and pop the character from queue to add it to a topological string.
   4. If there are no outgoing characters in the adjacency list, continue with next value in the queue. Otherwise, iterate over the current character's neighbours and add them to queue if the indegree decreased by one is equals to zero.

5. If the length of topological string(`topoStr`) is equals to unique letters size, return the topological string to deduce the characters ordering of alien language.

**Time and Space complexity:**
This algorithm has a time complexity of `O(V + E)`, where `V` is the number of unique characters in the dictionary,  and `E` is E is the number of edges or relationships between characters. This is because building the graph using adjacency list requires `O(V + E)`, and topological sorting requires `O(V + E)` considering each node is processed once and each edge is added once. Hence, it takes overall time complexity of `O(V + E)`.

The `alienOrder1` function requires `O(V + E)` space complexity, where `V` is the number of unique characters in the dictionary,  and `E` is E is the number of edges or relationships between characters. This is because the graph needs to store adjacency list and indegree of vertices with `O(V + E)` space complexity. Moreover, the queue may needs to store all nodes in worst case scenario with `O(V)` and the topological sorting string requires `O(V)` space complexity. Hence, it takes overall space complexity of `O(V + E)`.
