package machine;

class Machine {
    int[] machineHas;
    final static int[] ESPRESSO = {250, 0, 16, 1, 4};
    final static int[] LATTE = {350, 75, 20, 1, 7};
    final static int[] CAPPUCCINO = {200, 100, 12, 1, 6};
    int resourceToFill = 0;
    static Condition condition;

    public Machine(int[] ingredients) {
        this.machineHas = ingredients;
    }

    public void pressButton(String input) {
        switch (condition) {
            case MAIN_MENU:
                if (input.equals("remaining")) {
                    System.out.println();
                    Status();
                } else if (input.equals("take")) {
                    take();
                } else if (input.equals("fill")) {
                    System.out.println();
                    condition = Condition.FILL;
                    System.out.println("Write how many ml of water do you want to add:");
                } else if (input.equals("buy")) {
                    condition = Condition.BUY;
                } else break;
                break;
            case FILL:
                fill(input, resourceToFill);
                break;
            case BUY:
                buy(input);
        }
    }

    public void Status() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", machineHas[0]);
        System.out.printf("%d of milk\n", machineHas[1]);
        System.out.printf("%d of coffee beans\n", machineHas[2]);
        System.out.printf("%d of disposable cups\n", machineHas[3]);
        System.out.printf("%d of money\n\n", machineHas[4]);
    }

    public void fill(String inputFill, int resource) {
        switch (resource) {
            case 0:
                machineHas[0] += Integer.parseInt(inputFill);
                resourceToFill++;
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case 1:
                resourceToFill++;
                machineHas[1] += Integer.parseInt(inputFill);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                break;
            case 2:
                resourceToFill++;
                machineHas[2] += Integer.parseInt(inputFill);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                break;
            case 3:
                machineHas[3] += Integer.parseInt(inputFill);
                System.out.println();
                condition = Condition.MAIN_MENU;
                resourceToFill = 0;
            default:
                break;
        }
    }

    public void take() {
        System.out.printf("I gave you $%d\n\n", machineHas[4]);
        machineHas[4] = 0;
    }

    public void buy(String inputBuy) {
        String notEnough = "Sorry, not enough %s!\n\n";
        switch (inputBuy) {
            case "1":
                String n = isIngredientsEnough(ESPRESSO);
                if (n.equals("enough")) {
                    for (int i = 0; i < machineHas.length - 1; i++) {
                        machineHas[i] -= ESPRESSO[i];
                    }
                    machineHas[4] += ESPRESSO[4];
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.printf(notEnough, n);
                }
                condition = Condition.MAIN_MENU;
                break;
            case "2":
                String m = isIngredientsEnough(LATTE);
                if (m.equals("enough")) {
                    for (int i = 0; i < machineHas.length - 1; i++) {
                        machineHas[i] -= LATTE[i];
                    }
                    machineHas[4] += LATTE[4];
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.printf(notEnough, m);
                }
                condition = Condition.MAIN_MENU;
                break;
            case "3":
                String o = isIngredientsEnough(CAPPUCCINO);
                if (o.equals("enough")) {
                    for (int i = 0; i < machineHas.length - 1; i++) {
                        machineHas[i] -= CAPPUCCINO[i];
                    }
                    machineHas[4] += CAPPUCCINO[4];
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.printf(notEnough, o);
                }
                condition = Condition.MAIN_MENU;
                break;
            case "back":
                System.out.println();
                condition = Condition.MAIN_MENU;
                break;

            default:
                break;
        }
    }

    public String isIngredientsEnough(int[] coffee) {
        if (coffee[0] > machineHas[0]) {
            return "water";
        } else if (coffee[1] > machineHas[1]) {
            return "milk";
        } else if (coffee[2] > machineHas[2]) {
            return "coffeeBeans";
        } else if (coffee[3] > machineHas[3]) {
            return "Cups";
        } else return "enough";
    }
}