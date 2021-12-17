package rest;

public enum DataType {
    FILE ("application/octet-stream"), JSON ("application/json");

    private final String type;

    DataType(String type) {
        this.type = type;
    }

    public String asString() {
        return type;
    }
}
