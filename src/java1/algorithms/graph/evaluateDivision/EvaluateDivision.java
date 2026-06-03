package java1.algorithms.graph.evaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Edge(b, val));
            graph.get(b).add(new Edge(a, 1.0 / val));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, src, dst, 1.0, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, List<Edge>> graph, String curr, String target, double product, Set<String> visited) {
        if (curr.equals(target))
            return product;

        visited.add(curr);

        for (Edge edge : graph.get(curr)) {
            if (!visited.contains(edge.node)) {
                double result = dfs(graph, edge.node, target, product * edge.weight, visited);
                if (result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }

    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        // Test case 1
        System.out.println("Test case 1:");
        List<List<String>> equations1 = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values1 = { 2.0, 3.0 };
        List<List<String>> queries1 = List.of(
                List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        double[] result1 = solution.calcEquation(equations1, values1, queries1);
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [6.0, 0.5, -1.0, 1.0, -1.0]");
        System.out.println("Explanation: a/b = 2.0, b/c = 3.0, so a/c = 6.0");
        System.out.println();

        // Test case 2
        System.out.println("Test case 2:");
        List<List<String>> equations2 = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values2 = { 1.5, 2.5, 5.0 };
        List<List<String>> queries2 = List.of(
                List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
        double[] result2 = solution.calcEquation(equations2, values2, queries2);
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [3.75, 0.4, 5.0, 0.2]");
        System.out.println();

        // Test case 3
        System.out.println("Test case 3:");
        List<List<String>> equations3 = List.of(List.of("a", "b"));
        double[] values3 = { 0.5 };
        List<List<String>> queries3 = List.of(
                List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
        double[] result3 = solution.calcEquation(equations3, values3, queries3);
        System.out.print("Output: [");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i]);
            if (i < result3.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [0.5, 2.0, -1.0, -1.0]");
        System.out.println();

        // Test case 4
        System.out.println("Test case 4:");
        List<List<String>> equations4 = List.of(
                List.of("a", "b"), List.of("b", "c"), List.of("c", "d"));
        double[] values4 = { 2.0, 3.0, 4.0 };
        List<List<String>> queries4 = List.of(
                List.of("a", "d"), List.of("d", "a"));
        double[] result4 = solution.calcEquation(equations4, values4, queries4);
        System.out.print("Output: [");
        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i]);
            if (i < result4.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [24.0, 0.04166...]");
        System.out.println("Explanation: a/d = (a/b) * (b/c) * (c/d) = 2 * 3 * 4 = 24");
        System.out.println();

        // Test case 5
        System.out.println("Test case 5:");
        List<List<String>> equations5 = List.of(
                List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5"));
        double[] values5 = { 3.0, 4.0, 5.0, 6.0 };
        List<List<String>> queries5 = List.of(
                List.of("x1", "x5"), List.of("x5", "x2"), List.of("x2", "x4"), List.of("x2", "x2"),
                List.of("x2", "x9"));
        double[] result5 = solution.calcEquation(equations5, values5, queries5);
        System.out.print("Output: [");
        for (int i = 0; i < result5.length; i++) {
            System.out.print(result5[i]);
            if (i < result5.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [360.0, 0.04166..., 20.0, 1.0, -1.0]");
        System.out.println("Explanation: x1/x5 = 3 * 4 * 5 * 6 = 360");
    }
}
