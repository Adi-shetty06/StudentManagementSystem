package threads;

import model.Student;
import service.StudentService;
import util.FileUtil;

import java.util.List;

public class AutoSaveThread extends Thread {

    private final StudentService service;

    public AutoSaveThread(StudentService service) {
        this.service = service;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                FileUtil.writeToFile("students.txt",
                        service.getAllStudents()
                                .stream()
                                .map(Student::toString)
                                .toList()
                );

                System.out.println("[AutoSave] Students saved!");
                Thread.sleep(5000); // save every 5 sec

            } catch (InterruptedException e) {
                System.out.println("AutoSave stopped");
                break;
            }
        }
    }
}
