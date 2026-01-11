package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    public static void writeToFile(String fileName, List<String> data) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (String line : data) {
                fw.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}
