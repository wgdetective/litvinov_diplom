import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class Main {
    private static final String FILES_PATH = "E:\\Stud\\dip\\latest";

    public static void main(String[] args) {
        final LinesCounter linesCounter = new LinesCounter();
        final DataInfoAnalyser dataInfoAnalyser = new DataInfoAnalyser();
        FilesProcessor.process(new File(FILES_PATH), linesCounter.initConsumer(), dataInfoAnalyser.initConsumer());
        System.out.println("linesCounter.getCount() = " + linesCounter.getCount());
        final List<String> allocations = new ArrayList<>(dataInfoAnalyser.getAllocations());
        Collections.sort(allocations);
        System.out.println("dataInfoAnalyser.getAllocations() = " + allocations);
        System.out.println("dataInfoAnalyser.getMinStartDate() = " + dataInfoAnalyser.getMinStartDate());
        System.out.println("dataInfoAnalyser.getFlights() = " + dataInfoAnalyser.getFlights());
    }
}
