import java.util.*;

public class Combinations {
    public static Set<Integer> getCombinations(int in) {
        String input = in+"";
        Set<Integer> result = new TreeSet<>();
        for(String s : backtracking("", input, input.length() / 2))
            result.add(Integer.parseInt(s));
        return result;
    }

    private static Set<String> backtracking(String actual, String remaining, int length) {
        if (actual.length() == length)
            return new HashSet<>(Arrays.asList(actual));

        Set<String> result = new HashSet<>();
        for(int i = 0; i < remaining.length(); i++)
            result.addAll(backtracking(actual + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), length));
        return result;
    }
}