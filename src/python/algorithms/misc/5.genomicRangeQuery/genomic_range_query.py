"""
Genomic Range Query

A DNA sequence is represented as a string containing letters A, C, G, T.
Each letter has an impact factor: A=1, C=2, G=3, T=4.
Given ranges, find the minimum impact factor in each range.

Time Complexity: O(n + m) where n is string length, m is number of queries
Space Complexity: O(n)
"""


def genomic_range_query(s, p, q):
    """
    Using prefix sums for each nucleotide.
    TC: O(n + m), SC: O(n)
    """
    n = len(s)
    m = len(p)
    result = []
    
    # Prefix sums for each nucleotide
    a_prefix = [0] * (n + 1)
    c_prefix = [0] * (n + 1)
    g_prefix = [0] * (n + 1)
    
    for i in range(n):
        a_prefix[i + 1] = a_prefix[i]
        c_prefix[i + 1] = c_prefix[i]
        g_prefix[i + 1] = g_prefix[i]
        
        if s[i] == 'A':
            a_prefix[i + 1] += 1
        elif s[i] == 'C':
            c_prefix[i + 1] += 1
        elif s[i] == 'G':
            g_prefix[i + 1] += 1
    
    for i in range(m):
        start = p[i]
        end = q[i] + 1
        
        if a_prefix[end] - a_prefix[start] > 0:
            result.append(1)
        elif c_prefix[end] - c_prefix[start] > 0:
            result.append(2)
        elif g_prefix[end] - g_prefix[start] > 0:
            result.append(3)
        else:
            result.append(4)
    
    return result


# Test cases
if __name__ == "__main__":
    # Test case 1
    S = "CAGCCTA"
    P = [2, 5, 0]
    Q = [4, 5, 6]
    print(f"genomic_range_query('{S}', {P}, {Q}) = {genomic_range_query(S, P, Q)}")
    # Output: [2, 4, 1]
    
    # Test case 2
    s1 = "TTTTT"
    p1 = [0, 1, 2]
    q1 = [0, 2, 4]
    print(f"genomic_range_query('{s1}', {p1}, {q1}) = {genomic_range_query(s1, p1, q1)}")
    # Output: [4, 4, 4]
