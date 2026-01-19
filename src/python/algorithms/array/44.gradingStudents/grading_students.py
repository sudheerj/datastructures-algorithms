"""
Grading Students

Round grades to the nearest multiple of 5 if the difference is less than 3.
Grades below 38 are failing and don't get rounded.

Time Complexity: O(n)
Space Complexity: O(n)
"""

import math


def grading_students(grades):
    """
    Round grades according to rules.
    TC: O(n), SC: O(n)
    """
    result = []
    
    for grade in grades:
        if grade < 38:
            result.append(grade)
        else:
            next_multiple_of_5 = math.ceil(grade / 5) * 5
            if next_multiple_of_5 - grade < 3:
                result.append(next_multiple_of_5)
            else:
                result.append(grade)
    
    return result


def grading_students_list_comp(grades):
    """
    Using list comprehension.
    TC: O(n), SC: O(n)
    """
    def round_grade(grade):
        if grade < 38:
            return grade
        next_mult = math.ceil(grade / 5) * 5
        return next_mult if next_mult - grade < 3 else grade
    
    return [round_grade(g) for g in grades]


# Test cases
if __name__ == "__main__":
    test_cases = [
        [73, 67, 38, 33],   # Output: [75, 67, 40, 33]
        [84, 29, 57],       # Output: [85, 29, 57]
        [37, 38, 39],       # Output: [37, 40, 40]
        [33, 44, 55, 66],   # Output: [33, 45, 55, 66]
    ]
    
    for grades in test_cases:
        result = grading_students(grades)
        print(f"Input: {grades}")
        print(f"Output: {result}")
