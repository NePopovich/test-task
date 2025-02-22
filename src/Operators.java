public enum Operators {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

    private final String title;

    Operators(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\\" + title;
    }
}
