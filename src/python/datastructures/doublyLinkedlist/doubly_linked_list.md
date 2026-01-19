# Doubly Linked List

A doubly linked list is a linear data structure where each element (node) contains a value and references to both the next and previous nodes in the sequence.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| push      | O(1)           | Add node at end |
| pop       | O(1)           | Remove node from end |
| unshift   | O(1)           | Add node at beginning |
| shift     | O(1)           | Remove node from beginning |
| get       | O(n)           | Get node at index (optimized) |
| set       | O(n)           | Update node at index |
| insert    | O(n)           | Insert node at index |
| remove    | O(n)           | Remove node at index |
| reverse   | O(n)           | Reverse the list |

## Advantages over Singly Linked List

- Can traverse in both directions
- O(1) deletion from end (no need to traverse to find previous node)
- More efficient for certain operations like getting nodes near the end

## Usage

```python
from doubly_linked_list import DoublyLinkedList

dll = DoublyLinkedList()
dll.push(1)
dll.push(2)
dll.push(3)
dll.print_list()  # 1 <-> 2 <-> 3
```
