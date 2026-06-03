class BrowserHistory {
    constructor(homepage) {
        this.current = { url: homepage, prev: null, next: null };
    }
    visitPage(url) {
        const node = { url, prev: this.current, next: null };
        this.current.next = null;
        this.current.next = node;
        this.current = node;
    }
    forward(steps) {
        while (steps > 0 && this.current.next) {
            this.current = this.current.next;
            steps--;
        }
        return this.current.url;
    }
    back(steps) {
        while (steps > 0 && this.current.prev) {
            this.current = this.current.prev;
            steps--;
        }
        return this.current.url;
    }
}

function runTests() {
    console.log("Testing BrowserHistory (DoublyLinkedList):");
    const bh = new BrowserHistory("leetcode.com");
    bh.visitPage("google.com");
    bh.visitPage("facebook.com");
    bh.visitPage("youtube.com");
    const out1 = bh.back(1); // facebook.com
    const out2 = bh.back(1); // google.com
    const out3 = bh.forward(1); // facebook.com
    bh.visitPage("linkedin.com");
    const out4 = bh.forward(2); // linkedin.com
    const out5 = bh.back(2); // google.com
    const out6 = bh.back(7); // leetcode.com
    console.log("Test 1:", out1 === "facebook.com" ? "PASS" : "FAIL");
    console.log("Test 2:", out2 === "google.com" ? "PASS" : "FAIL");
    console.log("Test 3:", out3 === "facebook.com" ? "PASS" : "FAIL");
    console.log("Test 4:", out4 === "linkedin.com" ? "PASS" : "FAIL");
    console.log("Test 5:", out5 === "google.com" ? "PASS" : "FAIL");
    console.log("Test 6:", out6 === "leetcode.com" ? "PASS" : "FAIL");
}

runTests();
