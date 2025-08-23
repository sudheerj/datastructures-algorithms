function  gradingStudents(grades) {
    return grades.map(grade => {
        if (grade < 38) return grade;
        const nextMultipleOf5 = Math.ceil(grade / 5) * 5;
        return (nextMultipleOf5 - grade < 3) ? nextMultipleOf5 : grade;
    });
}

// Test cases
console.log(gradingStudents([73, 67, 38, 33])); // Output: [75, 67, 40, 33]
console.log(gradingStudents([84, 29, 57])); // Output: [85, 29, 57]
console.log(gradingStudents([37, 38, 39])); // Output: [37, 40, 40]
console.log(gradingStudents([33, 44, 55, 66])); // Output: [33, 45, 55, 66]