package ru.shcheglov.enums;

/**
 * @author Alexey Shcheglov
 * @version dated 27.12.2018
 */

public enum UserRole {

    USER("user"),
    ADMIN("admin"),
    MANAGER("manager");

    private String name;

    UserRole(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
