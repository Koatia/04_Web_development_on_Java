public enum Celebrations {
    NO_CELEBRATION("Нет праздника"),
    NEW_YEAR("Новый Год"),
    WOMENS_DAY("8 марта"),
    DEFENDERS_DAY("23 февраля");

    private final String displayName;

    Celebrations(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
        // access the Russian name: Celebrations.NEW_YEAR.getDisplayName()
    }
}
