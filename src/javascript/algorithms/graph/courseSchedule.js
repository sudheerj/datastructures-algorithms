 //BFS:==> TC: O(V+E) SC: O(V)(Use Kahn's algorithm to see if topological order is possible or not)
function canFinish(numCourses, prerequisites) {
    let adjMap = Array(numCourses).fill(0).map(()=> []);
    let inDegree = Array(numCourses).fill(0);

    for(let [to, from] of prerequisites) {
        adjMap[from].push(to);
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
        for(const neighbour of adjMap[currentCourse]) {
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
console.log(canFinish(numCourses1, prerequisites1));
console.log(canFinish(numCourses2, prerequisites2));