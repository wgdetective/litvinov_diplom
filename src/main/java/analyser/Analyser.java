package analyser;

import java.io.File;
import java.util.function.BiFunction;

/**
 * Created by Wladimir Litvinov on 03.05.2016.
 */
public interface Analyser {
    BiFunction<String, File, Object> initLineProcessor();
}
