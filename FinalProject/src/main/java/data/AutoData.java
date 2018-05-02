package data;

public enum AutoData {

    All("Все материалы"),
    Video("Видеотесты"),
    Comprative("Сравнительные тесты");

    private final String name;

    AutoData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
