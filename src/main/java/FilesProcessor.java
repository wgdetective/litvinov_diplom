import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class FilesProcessor {
    private static final Logger LOGGER = Logger.getLogger(FilesProcessor.class.getName());

    public static void process(final File file, final Consumer<String>... functions) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            processDir(file, functions);
        } else {
            processFile(file, functions);
        }
    }

    private static void processDir(final File directory, final Consumer<String>... functions) {
        for (File file : directory.listFiles()) {
            process(file, functions);
        }
    }

    private static void processFile(final File file, final Consumer<String>... functions) {
        if (file.length() == 0) {
            return;
        }
        try {
            final Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                for (Consumer<String> function : functions) {
                    try {
                        function.accept(line);
                    } catch (Exception e) {
                        LOGGER.severe("Problem with line: " + line);
                        LOGGER.severe("Problem with file: " + file.getPath());
                        //LOGGER.log(Level.SEVERE, "", e);
                        return;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
