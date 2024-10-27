import java.util.Objects;

// This class is already written for you - you don't need to do anything here
public class Person {

    private final String name;
    private final int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String name() {
        return name;
    }

    public int birthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ", birthYear=" + birthYear + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return birthYear == person.birthYear && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear);
    }
}
