import java.util.*;

public class Test {
    public static void main(String[] args) {
        for(int i = 1000; i < 9999; i++) {
            if(Numbers.isVampire(i)) System.out.println(i + " is a vampire number!");
        }
//        Numbers.isVampire(6880);
    }
}