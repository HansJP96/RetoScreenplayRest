package co.com.sofka.util;

public enum JsonPlaceHolderResources {
    UPDATE_COMMENT("/comments/{id}"),
    CREATE_COMMENT("/comments");

    private final String value;

    JsonPlaceHolderResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
