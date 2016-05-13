package analyser;

import java.io.File;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Created by Wladimir Litvinov on 03.05.2016.
 */
public class DataInfoAnalyser implements Analyser {
    private final Set<String> allocations = new HashSet<>();
    private LocalDate minStartDate;
    private final Set<String> flights = new HashSet<>();

    @Override
    public BiFunction<String, File, Object> initLineProcessor() {
        allocations.clear();
        minStartDate = LocalDate.now();
        flights.clear();
        return (line, file) -> {
            final String[] split = line.split(";");
            allocations.add(split[0]);
            final LocalDate startDate = LocalDate.parse(split[4]);
            if (startDate.isBefore(minStartDate)) {
                minStartDate = startDate;
            }
            flights.add(split[16]);
            return null;
        };
    }

    public Set<String> getAllocations() {
        return allocations;
    }

    public LocalDate getMinStartDate() {
        return minStartDate;
    }

    public Set<String> getFlights() {
        return flights;
    }
}
