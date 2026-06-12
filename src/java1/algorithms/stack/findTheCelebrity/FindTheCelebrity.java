package java1.algorithms.stack.findTheCelebrity;

import java.util.Stack;

//If A knows B -> A is out
//If A cannot be known by someone -> A is out
public class FindTheCelebrity {
    //Elimination candidate pattern TC: O(n) SC: O(1)
    private int findCelebrity1(int n) {
        //Step1: Find the celebrity candidate
        int candidate = 0;
        for(int i=1; i<n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }

        //Step2: Verify the candidate
        for(int i=0; i<n; i++) {
            if(i == candidate) continue;

            if(knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    //Stack elimination approach TC: O(n) SC: O(n)
    private int findCelebrity2(int n) {
        Stack<Integer> stack = new Stack<>();

        //Push all candidates
        for(int i=0; i<n; i++) {
            stack.push(i);
        }

        //Eliminate non-candidates
        while(stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if(knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        //Verify the candidate
        for(int i=0; i<n; i++) {
            if(i == candidate) continue;

            if(knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    private int[][] graph;
    FindTheCelebrity(int[][] graph) {
        this.graph = graph;
    }

    boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }
}
