package java1.algorithms.tree.twoSum4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import java1.algorithms.tree.TreeNode;

public class TwoSum4 {
    //BST iterators for space optimized solution: TC: O(n) SC: O(h)
    private boolean findTarget1(TreeNode root, int k) {
        if(root == null) return false;

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();

        pushLeft(root, left);
        pushRight(root, right);

        int i = getNext(left, false);
        int j = getNext(right, true);

        while(i < j) {
            int sum = i + j;

            if(sum == k) return true;

            if(sum < k) {
                i = getNext(left, false);
            } else {
                j = getNext(right, true);
            }
        }

        return false;
    }

    private void pushLeft(TreeNode node, Stack<TreeNode> left) {
        if(node == null) return;

        while(node != null) {
            left.push(node.left);
            node = node.left;
        }
    }

    private void pushRight(TreeNode node, Stack<TreeNode> right) {
        if(node == null) return;

        while(node != null) {
            right.push(node.right);
            node = node.right;
        }
    }

    private int getNext(Stack<TreeNode> st, boolean reverse) {
        TreeNode node = st.pop();

        if(!reverse) {
            pushLeft(node.right, st);
        } else {
            pushRight(node.left, st);
        }

        return node.value;
    }

    //BST inorder + Two pointers TC: O(n) SC: O(n)
    private boolean findTarget2(TreeNode root, int k) {
        if(root == null) return false;

        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);

        int i = 0, j = sortedList.size()-1;

        while(i < j) {
            int sum = sortedList.get(i) + sortedList.get(j);

            if(sum == k) return true;
            if(sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;

        inorder(node.left, list);
        list.add(node.value);
        inorder(node.right, list);
    }

    //BST with DFS and hashset TC: O(n) SC: O(n)
    private boolean findTarget3(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if(node == null) return false;

        if(set.contains(node.value-k)) {
            return true;
        }

        set.add(node.value);

        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}
