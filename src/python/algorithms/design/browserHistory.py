class BrowserHistory:
    class Node:
        def __init__(self, url):
            self.url = url
            self.prev = None
            self.next = None

    def __init__(self, homepage: str):
        self.current = self.Node(homepage)

    def visitPage(self, url: str) -> None:
        node = self.Node(url)
        self.current.next = None
        node.prev = self.current
        self.current.next = node
        self.current = node

    def forward(self, steps: int) -> str:
        while steps > 0 and self.current.next:
            self.current = self.current.next
            steps -= 1
        return self.current.url

    def back(self, steps: int) -> str:
        while steps > 0 and self.current.prev:
            self.current = self.current.prev
            steps -= 1
        return self.current.url

def run_tests():
    print("Testing BrowserHistory (DoublyLinkedList):")
    bh = BrowserHistory("leetcode.com")
    bh.visitPage("google.com")
    bh.visitPage("facebook.com")
    bh.visitPage("youtube.com")
    out1 = bh.back(1) # facebook.com
    out2 = bh.back(1) # google.com
    out3 = bh.forward(1) # facebook.com
    bh.visitPage("linkedin.com")
    out4 = bh.forward(2) # linkedin.com
    out5 = bh.back(2) # google.com
    out6 = bh.back(7) # leetcode.com
    print("Test 1:", "PASS" if out1 == "facebook.com" else "FAIL")
    print("Test 2:", "PASS" if out2 == "google.com" else "FAIL")
    print("Test 3:", "PASS" if out3 == "facebook.com" else "FAIL")
    print("Test 4:", "PASS" if out4 == "linkedin.com" else "FAIL")
    print("Test 5:", "PASS" if out5 == "google.com" else "FAIL")
    print("Test 6:", "PASS" if out6 == "leetcode.com" else "FAIL")

if __name__ == "__main__":
    run_tests()
