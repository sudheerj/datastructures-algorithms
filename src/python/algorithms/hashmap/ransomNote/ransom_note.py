from collections import Counter

//Frequency counter TC: O(m+n) SC: O(1)
def canConstruct1(ransomNote, magzine):
    ransome_counter = Counter(ransomNote)
    magzine_counter = Counter(magzine)

    for char, count in ransome_counter.items():
        if count > magzine_counter[char]:
            return False
    return True

def canConstruct2(ransomNote, magzine):
    counter = [0] * 26

    for c in magzine:
        counter[ord(c)-ord('a')] += 1

    for c in ransomNote:
        idx = ord(c) - ord('a')
        counter[idx] -= 1

        if counter[idx] < 0:
            return False
    return True

def run_tests():
    tests = [
        # (ransomNote, magazine, expected)
        ("a", "b", False),
        ("aa", "ab", False),
        ("aa", "aab", True),
        ("hello", "helloworld", True),
        ("abc", "aabbcc", True),
        ("abc", "ab", False),
        ("", "abc", True),
        ("aabb", "ab", False),
        ("aabb", "aabbcc", True),
    ]

    for i, (ransomNote, magazine, expected) in enumerate(tests, 1):
        result1 = canConstruct1(ransomNote, magazine)
        result2 = canConstruct2(ransomNote, magazine)


        status1 = "PASS" if result1 == expected else "FAIL"
        status2 = "PASS" if result2 == expected else "FAIL"

        print(f"Test1 {i}: {status1}")
        print(f"Test2 {i}: {status2}")
        print(f"  ransomNote = '{ransomNote}'")
        print(f"  magazine   = '{magazine}'")
        print(f"  Expected   = {expected}")
        print(f"  Method1:Got        = {result1}\n")
        print(f"  Method2:Got        = {result2}\n")



if __name__ == "__main__":
    run_tests()