package threads;

import model.Student;
import service.StudentService;
import util.FileUtil;

import java.util.List;

public class AutoSaveThread extends Thread {

    private StudentService service;

    public AutoSaveThread(StudentService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Student> list = service.getAllStudents();
                FileUtil.saveToFile("students.txt",
                        list.stream().map(Student::toString).toList()
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
