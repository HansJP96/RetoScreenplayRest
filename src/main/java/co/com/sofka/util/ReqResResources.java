package co.com.sofka.util;

public enum ReqResResources {
    DELETE_USER("/api/users/{id}");

    private final String value;

    ReqResResources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
