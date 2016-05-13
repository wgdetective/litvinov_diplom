package analyser;

import java.io.File;
import java.util.function.BiFunction;

/**
 * Created by Wladimir Litvinov on 02.05.2016.
 */
public class LinesCounter implements Analyser {
    private long count;

    public BiFunction<String, File, Object> initLineProcessor() {
        count = 0;
        return (line, file) -> {
            count++;
            return null;
        };
    }

    public long getCount() {
        return count;
    }
}
