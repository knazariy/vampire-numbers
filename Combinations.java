import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Combinations {
    public static Set<Integer> get2DCombinations(List<Integer> digits) {
        Set<Integer> combinations = new TreeSet<>();

        int t;
        for(Integer i : digits) {
            for (Integer j : digits) {
                if(i.equals(j)) continue;
                t = i * 10 + j;
                if (t / 10 >= 1) {
                    combinations.add(t);
                }
            }
        }

        return combinations;
    }
}
