// Sliding window: TC: O(m) + O(n) SC: O(m) + O(n)

function minWindowSubstring(windowStr, subStr) {
    let windowStrCount = new Map();
    let subStrCount = new Map();

    let minLength = Number.MAX_VALUE;
    let subStrboundaries = [-1, -1];

    for(const ch of subStr) {
        subStrCount.set(ch, (subStrCount.get(ch) || 0) + 1);
    }

    let having = 0; required = subStrCount.size;
    let left = 0;

    for(let right = 0; right < windowStr.length; right++) {
        let rightChar = windowStr[right];

        if(subStrCount.has(rightChar)) {
            windowStrCount.set(rightChar, (windowStrCount.get(rightChar) || 0) +1);
            if(subStrCount.get(rightChar) === windowStrCount.get(rightChar)) {
                having++;
            }
        }

        while(required === having) {
            if(minLength > right-left+1) {
                minLength = right-left+1;
                subStrboundaries[0] = left;
                subStrboundaries[1] = right;
            }

            let leftChar = windowStr[left];
            if(subStrCount.has(leftChar)) {
                windowStrCount.set(leftChar, windowStrCount.get(leftChar)-1);
                if(windowStrCount.get(leftChar) < subStrCount.get(leftChar)) {
                    having--;
                }
            }
            left++;
        }
    }

    return minLength === Number.MAX_VALUE ? "" : windowStr.substring(subStrboundaries[0], subStrboundaries[1]+1);
}

let s1 ="ADOBECODEBANC", t1= "ABC";
console.log(minWindowSubstring(s1, t1));

let s2 ="A", t2 = "A";
console.log(minWindowSubstring(s2, t2));

let s3 ="a", t3 = "aa";
console.log(minWindowSubstring(s3, t3));