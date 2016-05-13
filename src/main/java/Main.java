import analyser.DataInfoAnalyser;
import analyser.LinesCounter;
import analyser.NotChangingFieldsAnalyser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class Main {
    private static final String FILES_PATH_ALL = "E:\\Stud\\dip\\latest";
    private static final String FILES_PATH_PACK1 = "E:\\Stud\\dip\\pack1";

    public static void main(String[] args) throws IOException {
        writeToOneFile();
    }

    private static void checkNotChangingFields() {
        final NotChangingFieldsAnalyser notChangingFieldsAnalyser = new NotChangingFieldsAnalyser();
        FilesProcessor.process(new File(FILES_PATH_ALL),
                notChangingFieldsAnalyser.initLineProcessor());
        final Map<String, Object> onlyOneValue = notChangingFieldsAnalyser.getResult();
        onlyOneValue.forEach((key, value) -> System.out.println(key + " '" + value + "'"));
    }

    private static void writeToOneFile() throws IOException {
        final DataTransformer dataTransformer = new DataTransformer();
        dataTransformer.writeOffersV1ToOneFile(new File(FILES_PATH_PACK1), new File("E:\\Stud\\dip\\test\\pack1.csv"), true);
    }

    private static void getCommonMeta() {
        final LinesCounter linesCounter = new LinesCounter();
        final DataInfoAnalyser dataInfoAnalyser = new DataInfoAnalyser();
        FilesProcessor.process(new File(FILES_PATH_ALL),
                linesCounter.initLineProcessor(),
                dataInfoAnalyser.initLineProcessor());
        System.out.println("linesCounter.getCount() = " + linesCounter.getCount());
        final List<String> allocations = new ArrayList<>(dataInfoAnalyser.getAllocations());
        Collections.sort(allocations);
        System.out.println("dataInfoAnalyser.getAllocations() = " + allocations);
        System.out.println("dataInfoAnalyser.getMinStartDate() = " + dataInfoAnalyser.getMinStartDate());
        System.out.println("dataInfoAnalyser.isDiffStartDate() = " + dataInfoAnalyser.isDiffStartDate());
    }
}
