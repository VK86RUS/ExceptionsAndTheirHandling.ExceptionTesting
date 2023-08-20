package ru.qamid66;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товар с id = " + id + " не найден");
    }
    public NotFoundException(String title) {
        super("Товар с title = " + title + "не найден");
    }

}
