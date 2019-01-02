import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> digits = new TreeSet<>();
        Set<Integer> combinations;

        Scanner sc = new Scanner(System.in);
        int input;

        System.out.println("Enter a 4-digit number: ");
        input = sc.nextInt();
        if (input / 1000 < 1) {
            System.out.println("Number isn't 4-digit. Please, try again.");
            return;
        }
        int t = input;
        while(t > 0) {
            digits.add(t % 10);
            t /= 10;
        }

        combinations = Combinations.get2DCombinations(digits);

        for(Integer i : combinations)
            for(Integer j : combinations) {
                if(i*j == input) {
                    System.out.println(input + " is a vampire number!\n" +
                            i + " * " + j + " = " + i * j);
                    return;
                }
            }

    }

}
