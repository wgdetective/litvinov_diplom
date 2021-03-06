import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class FilesProcessor {
    private static final Logger LOGGER = Logger.getLogger(FilesProcessor.class.getName());

    public static void process(final File file, final BiFunction<String, File, Object>... functions) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            processDir(file, functions);
        } else {
            processFile(file, functions);
        }
    }

    private static void processDir(final File directory, final BiFunction<String, File, Object>... functions) {
        for (File file : directory.listFiles()) {
            process(file, functions);
        }
    }

    private static void processFile(final File file, final BiFunction<String, File, Object>... functions) {
        if (file.length() == 0) {
            file.delete();
            return;
        }
        try {
            final Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                for (BiFunction<String, File, Object> function : functions) {
                    try {
                        function.apply(line, file);
                    } catch (Exception e) {
                        LOGGER.severe("Problem with file: " + file.getPath());
                        LOGGER.severe("Problem with line: " + line);
                        //LOGGER.severe("Exception: " + e.getMessage() + "\n");
                        LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void deleteEmptyFilesAndDirs(final File file) throws FileNotFoundException {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            deleteEmptyFilesAndDirsProcessDir(file);
        } else {
            deleteEmptyFilesAndDirsProcessDirsProcessFile(file);
        }
    }


    private static void deleteEmptyFilesAndDirsProcessDir(final File directory) throws FileNotFoundException {
        for (File file : directory.listFiles()) {
            deleteEmptyFilesAndDirs(file);
        }
        if (directory.listFiles().length == 0){
            directory.delete();
        }
    }

    private static void deleteEmptyFilesAndDirsProcessDirsProcessFile(final File file) throws FileNotFoundException {
        if (file.length() == 0) {
            file.delete();
            return;
        }
        final Scanner scanner = new Scanner(file);
        final boolean empty = !readNextLine(scanner) || !readNextLine(scanner);
        scanner.close();
        if (empty){
            file.delete();
        }
    }

    private static boolean readNextLine(final Scanner scanner) {
        if (scanner.hasNextLine()){
            scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }
}
