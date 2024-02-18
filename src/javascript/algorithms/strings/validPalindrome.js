//Two pointer:- TC:O(n) SC: O(n)
function isValidPalindrome(str) {
    if(str.length <=1) return true;

    let left = 0, right = str.length -1;
    while(left <= right) {
        let ch1 = str[left];
        let ch2 = str[right];

        if(!isAlphanumeric(ch1)) left++;
        else if(!isAlphanumeric(ch2)) right--;
        else {
            if(ch1.toLowerCase() != ch2.toLowerCase()) {
                return false;
            }
            left++;
            right--;
        }
    }
    return true;
}

//Two pointer without regex:- TC:O(n) SC: O(n)
function isValidPalindrome1(str) {
    if(str.length <=1) return true;

    let left = 0, right = str.length -1;
    while(left <= right) {
        let ch1 = str[left];
        let ch2 = str[right];

        if(!isAlphanumeric1(ch1)) left++;
        else if(!isAlphanumeric1(ch2)) right--;
        else {
            if(ch1.toLowerCase() != ch2.toLowerCase()) {
                return false;
            }
            left++;
            right--;
        }
    }
    return true;
}

function isAlphanumeric(char) {
    return /[a-zA-Z0-9]/.test(char);
}

function isAlphanumeric1(char) {
    return (char.toLowerCase() >= 'a' && char.toLowerCase() <= 'z') || (char >= '0' && char <= '9');
}

let str1 ="A man, a plan, a canal: Panama";
console.log(isValidPalindrome(str1));
console.log(isValidPalindrome1(str1));
let str2 ="Hello World";
console.log(isValidPalindrome(str2));
console.log(isValidPalindrome1(str2));