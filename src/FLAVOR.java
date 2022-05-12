public enum FLAVOR {
    SWEET("Sweet"),
    SOUR("Sour"),
    BITTER("Bitter"),
    SALTY("Salty"),
    SPICY("Spicy"),
    BOOZY("Boozy"),
    UMAMI("Umami"),
    ASTRINGENT("Astringent");

    private String name;

    private FLAVOR(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
