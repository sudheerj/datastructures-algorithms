// Cousins in Binary Tree (LC 993)
// BFS: TC O(n) SC O(n) | DFS: TC O(n) SC O(h)

class TreeNode {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

// Approach 1: BFS
function isCousins(root, x, y) {
    const queue = [root];
    while (queue.length > 0) {
        let foundX = false, foundY = false;
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const node = queue.shift();
            if (node.value === x) foundX = true;
            if (node.value === y) foundY = true;
            if (node.left && node.right) {
                const lv = node.left.value, rv = node.right.value;
                if ((lv === x && rv === y) || (lv === y && rv === x)) return false;
            }
            if (node.left)  queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        if (foundX && foundY) return true;
        if (foundX || foundY) return false;
    }
    return false;
}

// Approach 2: DFS
function isCousins2(root, x, y) {
    const info = {};

    function dfs(node, parent, depth) {
        if (!node) return;
        if (node.value === x || node.value === y) {
            info[node.value] = { depth, parent };
        }
        dfs(node.left,  node, depth + 1);
        dfs(node.right, node, depth + 1);
    }

    dfs(root, null, 0);
    if (!(x in info) || !(y in info)) return false;
    return info[x].depth === info[y].depth && info[x].parent !== info[y].parent;
}

function runTests() {
    const t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
    const t2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)),
                               new TreeNode(3, null, new TreeNode(5)));
    const t3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    const t4 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                               new TreeNode(3, new TreeNode(6), new TreeNode(7)));

    const tests = [
        { root: t1, x: 4, y: 3, expected: false },
        { root: t2, x: 4, y: 5, expected: true  },
        { root: t3, x: 2, y: 3, expected: false },
        { root: t4, x: 4, y: 7, expected: true  },
        { root: t4, x: 4, y: 5, expected: false },
        { root: t4, x: 4, y: 6, expected: true  },
    ];

    for (const [label, fn] of [["BFS", isCousins], ["DFS", isCousins2]]) {
        console.log(`--- ${label} ---`);
        for (const { root, x, y, expected } of tests) {
            const result = fn(root, x, y);
            const pass = result === expected;
            console.log(`[${pass ? "PASS" : "FAIL"}] x=${x} y=${y} result=${result} expected=${expected}`);
        }
    }
}

runTests();
