package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student s) {

        if (s.getId() <= 0)
            throw new IllegalArgumentException("ID must be positive");

        if (s.getName() == null || s.getName().isBlank())
            throw new IllegalArgumentException("Name cannot be empty");

        if (s.getAge() <= 0 || s.getAge() > 120)
            throw new IllegalArgumentException("Invalid age");

        if (s.getMarks() < 0 || s.getMarks() > 100)
            throw new IllegalArgumentException("Invalid marks");

        students.add(s);
    }

    @Override
    public List<Student> getAllStudents() {

        return students;
    }

    @Override
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> getTopScorers(double minMarks) {
        return students.stream()
                .filter(s -> s.getMarks() >= minMarks)
                .collect(Collectors.toList());
    }
}
