// Time complexity: O(max(L1,L2)), Space complexity: O(L1+L2)
//1. Two pointers solution
function mergeStringsAlternately(word1, word2) {
    let mergedString = '';
    let i = j = 0;
    let m = word1.length;
    let n = word2.length;
    while(i < m || j < n) {
      if(i < m) {
        mergedString += word1[i++];
      }
      if(j < n) {
        mergedString += word2[j++];
      }
    }
    return mergedString;
};

console.log(mergeStringsAlternately('abcd', 'pqrst'));

//2. One pointer solution
function mergeStringsAlternately1(word1, word2) {
    let mergedString = '';
    let m = word1.length;
    let n = word2.length;
    for(let i=0; i< Math.max(m, n);i++) {
        if(i<m) {
            mergedString += word1.charAt(i);
        }
        if(i<n) {
            mergedString += word2.charAt(i);
        }
    }
    return mergedString;
}

console.log(mergeStringsAlternately1('abcd', 'pqrst'));