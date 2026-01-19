# **Destination City**

## **Problem Statement**
You are given an array of paths where `paths[i] = [from, to]`. Return the destination city, i.e., the city without any outgoing path.

---

## **Examples**

### Example 1:
- **Input**: `paths = [["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]`
- **Output**: `"Sao Paulo"`

### Example 2:
- **Input**: `paths = [["B", "C"], ["D", "B"], ["C", "A"]]`
- **Output**: `"A"`

---

## **Algorithmic Approach (Set)**

1. Create a set of all source cities (cities with outgoing paths).
2. Iterate through all paths:
   - For each destination city, check if it's not in the source set.
   - If found, return it as the final destination.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the paths.

- **Space Complexity**: `O(n)`  
  For storing source cities.
