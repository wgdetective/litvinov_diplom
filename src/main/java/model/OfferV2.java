package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Wladimir Litvinov on 17.05.2016.
 */
public class OfferV2 extends OfferV1{
    private static final LocalDate START_DATE = LocalDate.parse("2016-05-03");

    public long getStartDateLong() {
        return ChronoUnit.DAYS.between(START_DATE, super.getStartDate());
    }
}
