package service;

import model.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student s);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    List<Student> getTopScorers(double minMarks);
}
