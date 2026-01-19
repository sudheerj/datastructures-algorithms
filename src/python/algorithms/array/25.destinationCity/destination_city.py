"""
Destination City

You are given an array of paths where paths[i] = [from, to].
Return the destination city, i.e., the city without any path outgoing to another city.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def destination_city(paths):
    """
    Using set to track cities with outgoing paths.
    TC: O(n), SC: O(n)
    """
    from_cities = set()
    
    for from_city, to_city in paths:
        from_cities.add(from_city)
    
    for from_city, to_city in paths:
        if to_city not in from_cities:
            return to_city
    
    return None


# Test cases
if __name__ == "__main__":
    paths1 = [["Hyderabad", "KL"], ["KL", "Singapore"], ["Singapore", "Sydney"]]
    paths2 = [["New Jersey", "Austin"], ["New York", "New Jersey"], ["Austin", "Dallas"]]
    paths3 = [["Dallas", "London"]]
    
    print(f"Destination: {destination_city(paths1)}")  # Sydney
    print(f"Destination: {destination_city(paths2)}")  # Dallas
    print(f"Destination: {destination_city(paths3)}")  # London
