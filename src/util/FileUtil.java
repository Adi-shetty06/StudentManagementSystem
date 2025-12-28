package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    public static void saveToFile(String fileName, List<String> data) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (String line : data) {
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
