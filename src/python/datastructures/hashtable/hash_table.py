"""
Hash Table implementation in Python.
"""


class HashTable:
    """Hash Table implementation using separate chaining."""
    
    def __init__(self, size=7):
        self.map = [None] * size

    def _hash(self, key):
        """Generates a hash value for the given key."""
        hash_value = 0
        for char in str(key):
            hash_value = (hash_value + ord(char) * 23) % len(self.map)
        return hash_value

    def print_table(self):
        """Prints the hash table."""
        for i, bucket in enumerate(self.map):
            print(f"index {i}: {bucket}")

    def set(self, key, value):
        """Sets a key-value pair in the hash table."""
        index = self._hash(key)
        if self.map[index] is None:
            self.map[index] = []
        
        # Check if key already exists and update
        for i, pair in enumerate(self.map[index]):
            if pair[0] == key:
                self.map[index][i] = [key, value]
                return self
        
        self.map[index].append([key, value])
        return self

    def get(self, key):
        """Gets the value for the given key."""
        index = self._hash(key)
        if self.map[index]:
            for pair in self.map[index]:
                if pair[0] == key:
                    return pair[1]
        return None

    def keys(self):
        """Returns all keys in the hash table."""
        all_keys = []
        for bucket in self.map:
            if bucket:
                for pair in bucket:
                    all_keys.append(pair[0])
        return all_keys

    def values(self):
        """Returns all values in the hash table."""
        all_values = []
        for bucket in self.map:
            if bucket:
                for pair in bucket:
                    all_values.append(pair[1])
        return all_values

    def remove(self, key):
        """Removes a key-value pair from the hash table."""
        index = self._hash(key)
        if self.map[index]:
            for i, pair in enumerate(self.map[index]):
                if pair[0] == key:
                    return self.map[index].pop(i)
        return None


# Usage example
if __name__ == "__main__":
    my_hash_table = HashTable()

    my_hash_table.set("bolts", 70)
    my_hash_table.set("nails", 120)
    my_hash_table.set("paint", 40)
    my_hash_table.set("tile", 60)
    my_hash_table.set("lumber", 90)

    print(f"Get 'nails': {my_hash_table.get('nails')}")
    print(f"All keys: {my_hash_table.keys()}")
    print("\nHash Table contents:")
    my_hash_table.print_table()
