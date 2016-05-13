package analyser;

import model.OriginalOffer;
import parser.OriginalOfferParseUtils;

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
    private boolean diffStartDate;

    @Override
    public BiFunction<String, File, Object> initLineProcessor() {
        allocations.clear();
        minStartDate = LocalDate.now();
        diffStartDate = false;
        return (line, file) -> {
            final OriginalOffer originalOffer = OriginalOfferParseUtils.parseOriginalFileLine(line);
            allocations.add(originalOffer.getAllocation());
            final LocalDate startDate = originalOffer.getStartDate();
            if (startDate.isBefore(minStartDate)) {
                minStartDate = startDate;
            }
            if (!diffStartDate && !startDate.equals(originalOffer.getHotelStartDate())){
                System.out.println(startDate + " " + originalOffer.getHotelStartDate());
                diffStartDate = true;
            }
            return null;
        };
    }

    public Set<String> getAllocations() {
        return allocations;
    }

    public LocalDate getMinStartDate() {
        return minStartDate;
    }

    public boolean isDiffStartDate() {
        return diffStartDate;
    }
}
