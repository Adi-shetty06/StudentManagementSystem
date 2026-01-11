import model.Student;
import service.StudentService;
import service.StudentServiceImpl;
import threads.AutoSaveThread;

import java.util.List;

public class App {
    public static void main(String[] args) {

        StudentService service = new StudentServiceImpl();

        // Starting background thread
        AutoSaveThread autoSave  = new AutoSaveThread(service);
        autoSave.start();

        // Adding students
        service.addStudent(new Student(1, "Adithya", 21, 89.5));
        service.addStudent(new Student(2, "Rohit", 22, 76.0));
        service.addStudent(new Student(3, "Meera", 20, 92.3));

        System.out.println("All Students:");
        service.getAllStudents().forEach(System.out::println);

        System.out.println("\nTop Scorers (>80):");
        List<Student> top = service.getTopScorers(80);
        top.forEach(System.out::println);

        // Get student by ID
        System.out.println("\nGet Student By ID (2):");
        System.out.println(service.getStudentById(2));

        // Stop autosave thread after some time
        try {
            Thread.sleep(12000); // allow autosave to run twice
        } catch (InterruptedException ignored) {}

        autoSave.interrupt();
    }
}
