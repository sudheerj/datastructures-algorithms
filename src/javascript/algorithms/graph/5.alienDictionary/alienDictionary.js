//BFS(Topological sorting through Kahn's algorithm):- TC: O(V+E) SC:O(V+E)

function alienOrder1(words) {
  let adjList = {};
  let inDegree = Array(26).fill(0);
  let uniqueLetters = new Set();

  for (let i = 0; i < words.length - 1; i++) {
    let firstWord = words[i];
    let secondWord = words[i + 1];

    if (firstWord.length > secondWord.length && firstWord.startsWith(secondWord)) {
      return "";
    }
    for (let j = 0; j < Math.min(firstWord.length, secondWord.length); j++) {
      let ch1 = firstWord[j];
      let ch2 = secondWord[j];
      if (ch1 !== ch2) {
        if (!adjList[ch1]) {
          adjList[ch1] = [];
        }
        adjList[ch1].push(ch2);
        inDegree[ch2.charCodeAt(0) - 97]++;
        break;
      }
    }
  }

  for (let word of words) {
    for (let ch of word) {
      uniqueLetters.add(ch);
    }
  }

  let queue = [];
  for (let ch of uniqueLetters) {
    if (inDegree[ch.charCodeAt(0) - 97] === 0) {
      queue.push(ch);
    }
  }

  let topStr = "";
  while (queue.length > 0) {
    let currChar = queue.shift();
    topStr += currChar;
    if (!adjList[currChar]) continue;
    for (let neighbour of adjList[currChar]) {
      if (--inDegree[neighbour.charCodeAt(0) - 97] === 0) {
        queue.push(neighbour);
      }
    }
  }

  return topStr.length === uniqueLetters.size ? topStr : "";
}

//DFS using recursion:- TC: O(V+E) SC:O(V+E)
function alienOrder2(words) {
    let adjList = {};
    let result = [];

    words.forEach((word) => {
        for(const ch of word){
            adjList[ch] = new Set();
        }
    });

    for (let i = 0; i < words.length-1; i++) {
        const firstWord = words[i];
        const secondWord = words[i+1];

        if(firstWord.length > secondWord.length && firstWord.startsWith(secondWord)) {
            return "";
        }

        for(let j=0; j < Math.min(firstWord.length, secondWord.length); j++){
            let ch1 = firstWord[j];
            let ch2 = secondWord[j];

            if(ch1 !== ch2) {
                adjList[ch1].add(ch2);
                break;
            }
        }
    }

    let visitState = {}; // 0 = unvisited, 1 = visited, 2 = processed
    
    for(const ch in adjList) {
        if(!visitState[ch] && dfs(ch, adjList, visitState, result)) return "";
    }

    return result.reverse().join("");

}

function dfs(ch, adjList, visitState, result){
    if(visitState[ch] === 1) {
        return true;
    }

    if(visitState[ch] === 2) {
        return false;
    }

    visitState[ch] = 1;
    for (const neighbour of adjList[ch]) {
        if(dfs(neighbour, adjList, visitState, result)) return true;
    }
    visitState[ch] = 2;
    result.push(ch);
    return false;
}

let words1 = ["grs", "grk", "dr", "dss", "rkss"];
console.log(alienOrder1(words1));
console.log(alienOrder2(words1));

let words2 = ["t", "r"];
console.log(alienOrder1(words2));
console.log(alienOrder2(words2));
