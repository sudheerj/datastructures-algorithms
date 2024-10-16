 //DFS:==> TC: O(V+E) SC: O(V+E)
 function canFinish1(numCourses, prerequisites) {
     let prerequisiteMap = Array(numCourses).fill(0).map(()=> []);
     for(const pre of prerequisites){
        prerequisiteMap[pre[0]]=[pre[1]];
     }

     let visitSet = new Set();

     for (let i=0; i< numCourses; i++) {
        if(!dfs(i, prerequisiteMap, visitSet)) return false;
     }

     return true;
 }

 function dfs(course, prerequisiteMap, visitSet) {
    if(visitSet.has(course)) return false;

    if(prerequisiteMap[course].length === 0) {
        return true;
    }

    visitSet.add(course);
    for (const pre of prerequisiteMap[course]) {
        if(!dfs(pre, prerequisiteMap, visitSet)) return false;
    }
    visitSet.delete(course);
    prerequisiteMap[course] = [];
    return true;
 }


//BFS:==> TC: O(V+E) SC: O(V+E)(Use Kahn's algorithm to see if topological order is possible or not)
 function canFinish2(numCourses, prerequisites) {
    let adjacencyMap = Array(numCourses).fill(0).map(()=> []);
    let inDegree = Array(numCourses).fill(0);

    for(let [to, from] of prerequisites) {
        adjacencyMap[from].push(to);
        inDegree[to]++;
    }

    let queue = [];
    let enrolled = 0;
    for(let i=0; i<numCourses;i++) {
        if(inDegree[i] === 0) {
            queue.push(i);
            enrolled++;
        }
    }
    
    while(queue.length >0) {
        let currentCourse = queue.pop();
        for(const neighbour of adjacencyMap[currentCourse]) {
            inDegree[neighbour]--;
            if(inDegree[neighbour] === 0) {
                queue.push(neighbour);
                enrolled++;
            }
        }
    }
    return enrolled === numCourses;
}

const numCourses1 =6;
const prerequisites1 = [[0, 4], [0, 5], [1, 3], [1, 4], [2, 5], [3, 2]];
const numCourses2 =2;
const prerequisites2 = [[0, 1], [1, 0]];
console.log(canFinish1(numCourses1, prerequisites1));
console.log(canFinish1(numCourses2, prerequisites2));
console.log(canFinish2(numCourses1, prerequisites1));
console.log(canFinish2(numCourses2, prerequisites2));