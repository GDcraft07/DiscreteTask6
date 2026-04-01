package ru.unecon.students;

public record Student(String firstName, String lastName) {
    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}