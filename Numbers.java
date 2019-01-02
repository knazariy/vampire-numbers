import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Numbers {
    public static boolean isVampire(int n) {
        List<Integer> digits = new LinkedList<>();  //List because digits can repeat
        Set<Integer> combinations;                  //Set because we don't need repeated combs
        int input = n;
        int t = input;

        if (input / 1000 < 1 || input / 1000 >= 10) //Only for 4-digit numbers
            return false;

        while (t > 0) {                             //Getting every digit
            digits.add(t % 10);
            t /= 10;
        }

        combinations = Combinations.get2DCombinations(digits);

        //This is where magic happens (Checking for vampire numbers)
        for (Integer i : combinations) {
            for (Integer j : combinations) {
                if (i * j == input) {
                    if(isValidPair(new int[] {i, j}, digits)) {
                        System.out.println(i + " * " + j + " = " + input);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //DO NOT CHANGE
    private static boolean isValidPair(int[] combination, List<Integer> digits) {
        HashMap<Integer, Integer> usedDigits = new HashMap<>();
        for(Integer i : digits) {
            if(usedDigits.containsKey(i)) usedDigits.put(i, usedDigits.get(i)+1);
            else usedDigits.put(i, 1);
        }
        int[] combDigits = new int[digits.size()];

        int x = 0;
        for(int i = 0, t; i < 2; i++) {
            t = combination[i];
            while (t > 0) {
                combDigits[x] = t % 10;
                t /= 10;
                ++x;
            }
        }

        for(int i = 0; i < combDigits.length; i++) {
            if (usedDigits.containsKey(combDigits[i])) {
                usedDigits.put(combDigits[i], usedDigits.get(combDigits[i])-1);
            }
        }

        for(int i = 0; i < 10; i++)
            if (usedDigits.containsKey(i))
                if (usedDigits.get(i) != 0) return false;

        return true;
    }
}