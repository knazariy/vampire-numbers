public class Test {
    public static void main(String[] args) {
        for(int i = 1000; i < 9999; i++)
            if(Numbers.isVampire(i))
                System.out.println(i + " is a vampire number!");

        for(int i = 100000; i < 999999; i++)
            if(Numbers.isVampire(i))
                System.out.println(i + " is a vampire number!");
    }
}