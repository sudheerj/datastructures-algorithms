function caesarCipher(str, shift) {
  // Ensure the shift is within the range of 0-25
  shift = shift % 26;
  let result = '';

  for (const char of str) {

    // Process uppercase letters
    if (char >= 'A' && char <= 'Z') {
      let code = ((char.charCodeAt(0) - 65 + shift + 26) % 26) + 65;
      result += String.fromCharCode(code);
    }
    // Process lowercase letters
    else if (char >= 'a' && char <= 'z') {
      let code = ((char.charCodeAt(0) - 97 + shift + 26) % 26) + 97;
      result += String.fromCharCode(code);
    }
    // Non-alphabetic characters remain unchanged
    else {
      result += char;
    }
  }

  return result;
}

// Test cases
console.log(caesarCipher("Hello, World!", 3)); // Output: "Khoor, Zruog!"
console.log(caesarCipher("abcXYZ", 2)); // Output: "cdeZAB"
console.log(caesarCipher("abcXYZ", -2)); // Output: "yzaVWX"
console.log(caesarCipher("Caesar Cipher 123!", 4)); // Output: "Geiwev Gmtliv 123!"