import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TheLogger {

    private static Logger logger = Logger.getLogger(TheLogger.class.getName());

    public static String[] contentFolder(String dirname) {
        File folder = new File(dirname);

        return folder.list();
    }

    public static void writeToFile(String[] str, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            for (int i = 0; i < str.length; i++) {
                fileWriter.write(str[i]);
                fileWriter.write(System.lineSeparator());
            }
            logger.info("Запись успешна!");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка записи в файл!");
        }

    }

    private static void setLogger() {
        try {
            FileHandler handler = new FileHandler("log.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();

            logger.addHandler(handler);
            handler.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setLogger();

        String[] nameFolder = contentFolder(".");
        writeToFile(nameFolder, "index.txt");

    }

}