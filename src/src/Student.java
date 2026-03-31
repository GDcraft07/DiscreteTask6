public record Student(String firstName, String secondName) {
    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.secondName);
    }
}