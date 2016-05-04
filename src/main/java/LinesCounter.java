import java.io.File;
import java.util.function.Consumer;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class LinesCounter implements IAnalyser {
    private long count;

    public Consumer<String> initConsumer() {
        count = 0;
        return (line) -> count++;
    }

    public long getCount() {
        return count;
    }
}
