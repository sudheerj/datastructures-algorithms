function isIsomorphic(s, t) {
    if(s.length !== t.length){
        return false;
    }
    let sMap = new Map();
    let tMap = new Map();

    for (let i = 0; i < s.length; i++) {
        if(sMap.has(s[i])) {
            if(t[i] !== sMap.get(s[i])) {
                return false;
            }
        } else {
            sMap.set(s[i], t[i]);
        }
        if(tMap.has(t[i])) {
            if(s[i] !== tMap.get(t[i])) {
                return false;
            }
        } else {
        tMap.set(t[i], s[i]);
        }
    }
    return true;
}

const s1 = "dad", t1 = "mom";
const s2 = "zoo", t2 = "cat";
console.log(isIsomorphic(s1, t1));
console.log(isIsomorphic(s2, t2));