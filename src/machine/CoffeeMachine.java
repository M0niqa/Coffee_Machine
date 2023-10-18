package machine;
import java.util.Scanner;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCps = 9;
    private int money = 550;


    public void printState() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, water, milk, coffeeBeans, disposableCps, money);
    }


    public void fill(Scanner scan) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        disposableCps += scan.nextInt();
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (water - waterNeeded < 0) {
            System.out.println("Sorry, not enough water!");
            return;
        } else {
            water -= waterNeeded;
        }
        if (milk - milkNeeded < 0) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else {
            milk -= milkNeeded;
        }
        if (coffeeBeans - beansNeeded < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        } else {
            coffeeBeans -= beansNeeded;
        }
        if (disposableCps - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        } else {
            disposableCps--;
        }
        System.out.println("I have enough resources, making you a coffee!");
        money += price;
    }

    public void buy(Scanner scan) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String choice = scan.next();
        switch (choice) {
            case "1" -> makeCoffee(250, 0, 16, 4);
            case "2" -> makeCoffee(350, 75, 20, 7);
            case "3" -> makeCoffee(200, 100, 12, 6);
        }
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void start(Scanner scan) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = scan.next();
            switch (option) {
                case "buy" -> buy(scan);
                case "fill" -> fill(scan);
                case "take" -> take();
                case "remaining" -> printState();
                case "exit" -> {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();
        cm.start(scan);
    }
}
