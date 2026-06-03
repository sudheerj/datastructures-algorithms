class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function convertBSTToDLL(root) {
    let head = null;
    let prev = null;

    function dfs(node) {
        if (!node) return;
        dfs(node.left);
        if (!prev) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        dfs(node.right);
    }

    dfs(root);
    return head;
}

function buildBST(vals) {
    function insert(root, val) {
        if (!root) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    let root = null;
    for (const v of vals) root = insert(root, v);
    return root;
}

function dllToArray(head) {
    const result = [];
    let cur = head;
    while (cur) { result.push(cur.data); cur = cur.right; }
    return result;
}

function runTests() {
    const tests = [
        { vals: [4],             expected: [4] },
        { vals: [4,2,6,1,3,5,7], expected: [1,2,3,4,5,6,7] },
        { vals: [3,2,1],         expected: [1,2,3] },
        { vals: [1,2,3],         expected: [1,2,3] },
        { vals: [5,3,7,2,4],     expected: [2,3,4,5,7] },
    ];

    tests.forEach(({ vals, expected }, i) => {
        const root = buildBST(vals);
        const result = dllToArray(convertBSTToDLL(root));
        const status = JSON.stringify(result) === JSON.stringify(expected) ? 'PASS' : 'FAIL';
        console.log(`${status} test ${i + 1}: result=${JSON.stringify(result)} expected=${JSON.stringify(expected)}`);
    });
}

runTests();
