package java1.algorithms.hashing.displayTableFoodOrders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTableFoodOrders {
    //Using TreeMap and TreeSet traversal which provides ordering TC: O() SC: O()
    private static List<List<String>> displayTable(List<List<String>> orders) {
        // {table -> {food -> count}}
        Map<Integer, Map<String, Integer>> tableMap = new TreeMap<>();

        //All unique foods in sorted order
        Set<String> foods = new TreeSet<>();

        for(List<String> order: orders) {
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);

            foods.add(food);
            tableMap.putIfAbsent(table, new HashMap<>());
            Map<String, Integer> foodCountMap = tableMap.get(table);
            foodCountMap.put(food, foodCountMap.getOrDefault(food, 0) + 1);
        }

        List<List<String>> result = new ArrayList<>();

        //header row
        List<String> headerRow = new ArrayList<>();
        headerRow.add("Table");
        headerRow.addAll(foods);
        result.add(headerRow);

        //TableRows
        for(Map.Entry<Integer, Map<String, Integer>> entry: tableMap.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));

            Map<String, Integer> foodCounts = entry.getValue();
            
            for(String food: foods) {
                row.add(String.valueOf(foodCounts.getOrDefault(food, 0)));
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<String>> orders = Arrays.asList(
                Arrays.asList("David", "3", "Ceviche"),
                Arrays.asList("Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"),
                Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"),
                Arrays.asList("Rous", "3", "Ceviche")
        );

        List<List<String>> result = displayTable(orders);

        System.out.println("Display Table:");
        for (List<String> row : result) {
            System.out.println(row);
        }
    }
}
