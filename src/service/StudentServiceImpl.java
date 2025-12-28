package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student s) {
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
