package machine;

public enum Condition {
    MAIN_MENU("Write action (buy, fill, take, remaining, exit):"),
    BUY("\"What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
    FILL("");
    private String string;

    Condition(String s) {
        this.string = s;
    }

    public String getString() {
        return string;
    }
}
