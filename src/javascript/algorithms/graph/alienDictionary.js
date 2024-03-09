//BFS(Topological sorting through Kahn's alogirthm):- TC: O(m*n) SC:O(m*n)

function alienOrder(words) {
    let adjList = {};
    let inDegree = Array(26).fill(0);
    let uniqueLetters = new Set();

    for(let i=0; i< words.length-1; i++) {
        let currWord = words[i];
        let nextWord = words[i+1];

        if(currWord.length > nextWord.length && currWord.startsWith(nextWord)) {
            return "";
        }
        for(let j=0; j< Math.min(currWord.length, nextWord.length); j++) {
            let ch1 = currWord[j];
            let ch2 = nextWord[j];
            if(ch1 !== ch2) {
                if(!adjList[ch1]) {
                    adjList[ch1] = [];
                }
                adjList[ch1].push(ch2);
                inDegree[ch2.charCodeAt(0)-97]++;
                break;
            }
        }

    }

    for(let word of words) {
        for(let ch of word) {
            uniqueLetters.add(ch);
        }
    }

    let queue = [];
    for(let ch of uniqueLetters) {
        if(inDegree[ch.charCodeAt(0)-97] === 0) {
            queue.push(ch);
        }
    }

    let topStr = "";
    while(queue.length >0) {
        let currChar = queue.shift();
        topStr += currChar;
        if(!adjList[currChar]) continue;
        for(let neighbour of adjList[currChar]) {
            if(--inDegree[neighbour.charCodeAt(0)-97] === 0) {
                queue.push(neighbour);
            }
        }
    }

    return topStr.length === uniqueLetters.size ? topStr : "";
    
}

let words =  ["wrt", "wrf", "er", "ett", "rftt"];
console.log(alienOrder(words));

