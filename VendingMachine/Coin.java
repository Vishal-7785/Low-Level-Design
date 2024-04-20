enum Coin {
    NICKEL(5),
    BRONZE(20),
    SILVER(30),
    GOLD(50);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
