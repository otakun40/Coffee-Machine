package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine coffeeMachine = new Machine(new int[]{400,540,120,9,550});
        coffeeMachine.condition = Condition.MAIN_MENU;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            switch (Machine.condition) {
                case MAIN_MENU:
                    System.out.println(coffeeMachine.condition.MAIN_MENU.getString());
                    break;
                case BUY:
                    System.out.println(coffeeMachine.condition.BUY.getString());
                default:break;
            }
            input = scanner.next();
            if (input.equals("exit")) {
                break;
            } else {
                coffeeMachine.pressButton(input);
            }
        }
    }
}
