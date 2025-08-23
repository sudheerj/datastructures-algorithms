function minimumNumber(n, password) {
    const hasDigit = /[0-9]/.test(password);
    const hasLower = /[a-z]/.test(password);
    const hasUpper = /[A-Z]/.test(password);
    const hasSpecial = /[!@#$%^&*()\-+]/.test(password);

    let missingTypes = 0;
    if(!hasDigit) missingTypes++;
    if(!hasLower) missingTypes++;
    if(!hasUpper) missingTypes++;
    if(!hasSpecial) missingTypes++;

    return Math.max(missingTypes, 6 - n);
}

// Test cases
console.log(minimumNumber(3, "Ab1")); // Output: 3
console.log(minimumNumber(4, "4700")); // Output: 3
console.log(minimumNumber(5, "aB1@")); // Output: 1
console.log(minimumNumber(6, "aB1@xyz")); // Output: 0