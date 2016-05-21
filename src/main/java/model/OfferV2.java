package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Wladimir Litvinov on 17.05.2016.
 */
public class OfferV2 extends OfferV1 {
    private static final LocalDate START_DATE = LocalDate.parse("2016-05-03");

    private String domainId;

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(final String domainId) {
        this.domainId = domainId;
    }

    public long getStartDateLong() {
        return ChronoUnit.DAYS.between(START_DATE, super.getStartDate());
    }

    public Integer getAllocationInt() {
        return Integer.parseInt(getAllocation().substring(0, 1));
    }
}
