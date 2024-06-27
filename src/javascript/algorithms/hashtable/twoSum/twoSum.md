**Approach1 algorithmic Steps**
This problem is solved in a one pass with the help of map data structure. The algorithmic approach can be summarized as follows:


1. Add a preliminary check two verify the length of input array and return an empty array if the length is less than 2.

3. Initialize an index map(i.e, `indexMap`) to store the current iteration number as key and index as value.

4. Iterate over the input array using index pointer until the end of the array. 

5. Find the complement by substracting the target and current number. If the complement already exists in the map, return the indices of complement and current number as output.

6. If the complement doesn't exist in our indexMap, just add the current number and its index to the map.

7. Repeat steps 5–6 until there are indices present to meet the target or the index pointer reaches the end of the array.

8. Return an empty array if there are no indices present in an array.

**Time and Space complexity:**
This algorithm has a time complexity of O(n) because we are traversing the array only once. Remember that checking an element existence in a map or adding an element to a map takes a constant time(i.e, O(1)).

Also, it takes requires space complexity of O(n) because we are using map data structure. In the worst case, when there are no indices, you need to insert all the elements of an array into map.

----------------------------------------------------------------------------------------------------------------------------
**Approach2 algorithmic Steps**
This problem is solved in a one pass with the help of object. The algorithmic approach can be summarized as follows:


1. Add a preliminary check two verify the length of input array and return an empty array if the length is less than 2.

3. Initialize an index object(i.e, `indexObj`) to store the current iteration number as name and index as value.

4. Iterate over the input array using index pointer until the end of the array. 

5. Find the complement by substracting the target and current number. If the complement already exists in the object, return the indices of complement and current number as output.

6. If the complement doesn't exist in our indexObj, just add the current number as value and its index as property name to the object.

7. Repeat steps 5–6 until there are indices present to meet the target or the index pointer reaches the end of the array.

8. Return an empty array if there are no indices present in an array.

**Time and Space complexity:**
This algorithm has a time complexity of O(n) because we are traversing the array only once. Remember that checking an element existence in an object or adding an element to an object takes a constant time(i.e, O(1)).

Also, it takes requires space complexity of O(n) because we are using object. In the worst case, when there are no indices, you need to insert all the elements of an array into map.