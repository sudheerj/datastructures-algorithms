package java1.algorithms.simulation.reconstructItenary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItenary {
    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static List<String> result = new LinkedList<>();

    // Using DFS + Priority queue TC: O(E logE) SC: O(E)
    public static List<String> reconstructItenary(List<List<String>> tickets) {
        graph.clear();
        result = new LinkedList<>();

        // 1. Build the graph
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        // 2. Start DFS from JFK
        dfs("JFK");

        return result;
    }

    private static void dfs(String airport) {
        PriorityQueue<String> pq = graph.get(airport);

        // 3. Visit all outgoing edges
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        // 4. Add to front(Heirholzer's trick)
        result.addFirst(airport);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Object[][] tests = {
                // {tickets, expected}
                {
                        Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
                                Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")),
                        Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC")
                },
                {
                        Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
                                Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"),
                                Arrays.asList("ATL", "SFO")),
                        Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")
                },
                {
                        Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"),
                                Arrays.asList("NRT", "JFK")),
                        Arrays.asList("JFK", "NRT", "JFK", "KUL")
                },
                {
                        Arrays.asList(Arrays.asList("JFK", "A"), Arrays.asList("A", "JFK")),
                        Arrays.asList("JFK", "A", "JFK")
                },
        };

        for (Object[] test : tests) {
            List<List<String>> tickets = (List<List<String>>) test[0];
            List<String> expected = (List<String>) test[1];
            List<String> result = reconstructItenary(tickets);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
