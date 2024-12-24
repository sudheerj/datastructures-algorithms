package java1.algorithms.array.destinationCity;

import java.util.HashSet;
import java.util.Set;

public class DestinationCity {
    private static String destinationCity(String[][] paths){
        Set<String> fromCities = new HashSet<>();

        for (String[] city : paths) {
            fromCities.add(city[0]);
        }

        for (String[] city : paths) {
            if(!fromCities.contains(city[1])){
                return city[1];
            }
        }

        return "";
        
    }

    public static void main(String[] args) {
        String[][] paths1 = new String[][]{{"Hyderabad","KL"},{"KL","Singapore"},{"Singapore","Sydney"}};
        String[][] paths2 = new String[][]{{"New Jersey","Austin"},{"New York","New Jersey"},{"Austin","Dallas"}};
        String[][] paths3 = new String[][]{{"Dallas", "London"}};

        System.out.println(destinationCity(paths1));
        System.out.println(destinationCity(paths2));
        System.out.println(destinationCity(paths3));    
    }
}
