import java.util.*;
import java.util.stream.Collectors;

public class Gradebook {
    private final HashMap<Student, HashMap<String, Integer>> book = new HashMap<>();


    static void checkNotNull(ArrayList<Object> args) {
        for (Object arg: args) {
            if (arg == null) {
                throw new IllegalArgumentException("Аргумент не может быть null");
            }
        }
    }


    static void checkRangeGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException(String.format("Оценка не может равняться %d", grade));
        }
    }


    static boolean filterFor5(Collection<Integer> collections) {
        if (collections != null) {
            return (! collections.contains(2) && ! collections.contains(3) && ! collections.contains(4));
        }

        return false;
    }

    static boolean filterFor4(Collection<Integer> collections) {
        if (collections != null) {
            return (! collections.contains(2) && ! collections.contains(3) && collections.contains(4));
        }

        return false;
    }

    static boolean filterFor3(Collection<Integer> collections) {
        if (collections != null) {
            return (! collections.contains(2) && collections.contains(3));
        }

        return false;
    }

    static boolean filterFor2(Collection<Integer> collections) {
        if (collections != null) {
            return collections.contains(2);
        }

        return false;
    }

    public Student addStudent(String firstName, String lastName) {
        ArrayList<Object> args = new ArrayList<>(2);
        args.add(firstName);
        args.add(lastName);
        checkNotNull(args);

        Student newStudent = new Student(firstName, lastName);

        if (this.book.containsKey(newStudent)) {
            return newStudent;
        }

        this.book.put(newStudent, new HashMap<>());
        return newStudent;
    }


    public Student addStudent(Student student) {
        ArrayList<Object> args = new ArrayList<>(1);
        args.add(student);
        checkNotNull(args);

        if (this.book.containsKey(student)) {
            return student;
        }

        this.book.put(student, new HashMap<>());
        return null;
    }


    public Student findStudent(String firstName, String lastName) {
        ArrayList<Object> args = new ArrayList<>(2);
        args.add(firstName);
        args.add(lastName);
        checkNotNull(args);

        Student newStudent = new Student(firstName, lastName);

        if (this.book.containsKey(newStudent)) {
            return newStudent;
        }

        return null;
    }


    public Set<Student> listStudents() {
        return this.book.keySet();
    }

    public void addGrade(Student student, String subject, int grade) {
        ArrayList<Object> args = new ArrayList<>(2);
        args.add(student);
        args.add(subject);
        checkNotNull(args);
        checkRangeGrade(grade);

        HashMap<String, Integer> studentsGrade = this.book.get(student);

        if (studentsGrade != null) {
            studentsGrade.put(subject, grade);
        }
    }

    public void removeGrade(Student student, String subject) {
        ArrayList<Object> args = new ArrayList<>(2);
        args.add(student);
        args.add(subject);
        checkNotNull(args);

        HashMap<String, Integer> studentsGrade = this.book.get(student);

        if (studentsGrade != null) {
            studentsGrade.remove(subject);
        }
    }

    public Set<Student> getStudents5() {
        return this.book.keySet().stream().filter(key -> filterFor5(this.book.get(key).values())).collect(Collectors.toSet());
    }

    public Set<Student> getStudents4() {
        return this.book.keySet().stream().filter(key -> filterFor4(this.book.get(key).values())).collect(Collectors.toSet());
    }

    public Set<Student> getStudents3() {
        return this.book.keySet().stream().filter(key -> filterFor3(this.book.get(key).values())).collect(Collectors.toSet());
    }

    public Set<Student> getStudents2() {
        return this.book.keySet().stream().filter(key -> filterFor2(this.book.get(key).values())).collect(Collectors.toSet());
    }

    public Set<Student> getStudents0() {
        return this.book.keySet().stream().filter(key -> this.book.get(key).values() == null).collect(Collectors.toSet());
    }
}
