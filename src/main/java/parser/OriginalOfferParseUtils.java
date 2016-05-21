package parser;

import model.OfferV1;
import model.OfferV2;
import model.OriginalOffer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.StringJoiner;

/**
 * Created by Wladimir Litvinov on 13.05.2016.
 */
public class OriginalOfferParseUtils {

    public static final String DELIMITER = ",";

    public static OriginalOffer parseOriginalFileLine(final String line) {
        final String[] split = line.split(";");
        final OriginalOffer originalOffer = new OriginalOffer();
        originalOffer.setAllocation(split[0]);
        originalOffer.setPrice(Long.parseLong(split[1]));
        originalOffer.setCurrencyCode(Integer.parseInt(split[2]));
        originalOffer.setAvailability(Integer.parseInt(split[3]));
        originalOffer.setStartDate(LocalDate.parse(split[4]));
        originalOffer.setDuration(Integer.parseInt(split[5]));
        originalOffer.setCityFrom(Integer.parseInt(split[6]));
        originalOffer.setTransfer(Integer.parseInt(split[7]));
        originalOffer.setInsurance(Integer.parseInt(split[8]));
        originalOffer.setHotelStartDate(LocalDate.parse(split[11]));
        originalOffer.setHotelDuration(Integer.parseInt(split[12]));
        originalOffer.setQuotaHotelCodes(split[13]);
        originalOffer.setQuotaRoomCodes(split[14]);
        originalOffer.setQuotaRoomCategories(split[15]);
        originalOffer.setFlightCode(split[16]);
        originalOffer.setTariffKey(split[17]);
        originalOffer.setFormattedDate(split[18]);
        originalOffer.setFlightPaxes(split[19]);
        originalOffer.setCommonMealType(Integer.parseInt(split[20]));
        originalOffer.setMealTypes(split[21]);
        originalOffer.setCommonRoomType(Integer.parseInt(split[22]));
        originalOffer.setRoomTypes(split[23]);
        originalOffer.setCommonDestinationCode(Integer.parseInt(split[24]));
        originalOffer.setCommonHotelCode(Integer.parseInt(split[25]));
        originalOffer.setCommonHotelCategory(Integer.parseInt(split[26]));
        return originalOffer;
    }

    public static String originalOfferToLine(final OriginalOffer originalOffer) {
        final StringJoiner joiner = new StringJoiner(";");
        joiner.add(originalOffer.getAllocation());                              //1
        joiner.add(String.valueOf(originalOffer.getPrice()));                   //2
        joiner.add(String.valueOf(originalOffer.getCurrencyCode()));            //3
        joiner.add(String.valueOf(originalOffer.getAvailability()));            //4
        joiner.add(originalOffer.getStartDate().format(DateTimeFormatter.ISO_DATE));                    //5
        joiner.add(String.valueOf(originalOffer.getDuration()));                //6
        joiner.add(String.valueOf(originalOffer.getCityFrom()));                //7
        joiner.add(String.valueOf(originalOffer.getTransfer()));                //8
        joiner.add(String.valueOf(originalOffer.getInsurance()));               //9
        joiner.add(originalOffer.getHotelStartDate().format(DateTimeFormatter.ISO_DATE));               //10
        joiner.add(String.valueOf(originalOffer.getHotelDuration()));           //11
        joiner.add(originalOffer.getQuotaHotelCodes());                         //12
        joiner.add(originalOffer.getQuotaRoomCodes());                          //13
        joiner.add(originalOffer.getQuotaRoomCategories());                     //14
        joiner.add(originalOffer.getFlightCode());                              //15
        joiner.add(originalOffer.getTariffKey());                               //16
        joiner.add(originalOffer.getFormattedDate());                           //17
        joiner.add(originalOffer.getFlightPaxes());                             //18
        joiner.add(String.valueOf(originalOffer.getCommonMealType()));          //19
        joiner.add(originalOffer.getMealTypes());                               //20
        joiner.add(String.valueOf(originalOffer.getCommonRoomType()));          //21
        joiner.add(originalOffer.getRoomTypes());                               //22
        joiner.add(String.valueOf(originalOffer.getCommonDestinationCode()));   //23
        joiner.add(String.valueOf(originalOffer.getCommonHotelCode()));         //24
        joiner.add(String.valueOf(originalOffer.getCommonHotelCategory()));     //25
        return joiner.toString();
    }



    public static OfferV1 originalOfferToOfferV1(final OriginalOffer originalOffer) {
        final OfferV1 offer = new OfferV1();
        offer.setAllocation(originalOffer.getAllocation());
        offer.setPrice(originalOffer.getPrice());
        //offer.setStartDate(ChronoUnit.DAYS.between(START_DATE, originalOffer.getStartDate()));
        offer.setStartDate(originalOffer.getStartDate());
        offer.setDuration(originalOffer.getDuration());
        offer.setCityFrom(originalOffer.getCityFrom());
        offer.setCommonMealType(originalOffer.getCommonMealType());
        offer.setCommonRoomType(originalOffer.getCommonRoomType());
        offer.setCommonDestinationCode(originalOffer.getCommonDestinationCode());
        offer.setCommonHotelCode(originalOffer.getCommonHotelCode());
        offer.setCommonHotelCategory(originalOffer.getCommonHotelCategory());
        offer.setDayOfWeek(originalOffer.getStartDate().getDayOfWeek().getValue());
        return offer;
    }

    public static String offerV1ToLine(final OfferV1 offer) {
        final StringJoiner joiner = new StringJoiner(DELIMITER);
        joiner.add(offer.getAllocation());
        joiner.add(String.valueOf(offer.getPrice()));
        joiner.add(String.valueOf(offer.getStartDate()));
        joiner.add(String.valueOf(offer.getDuration()));
        joiner.add(String.valueOf(offer.getCityFrom()));
        joiner.add(String.valueOf(offer.getCommonMealType()));
        joiner.add(String.valueOf(offer.getCommonRoomType()));
        joiner.add(String.valueOf(offer.getCommonDestinationCode()));
        joiner.add(String.valueOf(offer.getCommonHotelCode()));
        joiner.add(String.valueOf(offer.getCommonHotelCategory()));
        joiner.add(String.valueOf(offer.getDayOfWeek()));
        return joiner.toString();
    }

    public static OfferV2 parseOfferV2(final String line) {
        final OfferV2 offer = new OfferV2();
        final String[] split = line.split(DELIMITER);
        offer.setAllocation(split[0]);
        offer.setPrice(Long.parseLong(split[1]));
        offer.setStartDate(LocalDate.parse(split[2]));
        offer.setDuration(Integer.parseInt(split[3]));
        offer.setCityFrom(Integer.parseInt(split[4]));
        offer.setCommonMealType(Integer.parseInt(split[5]));
        offer.setCommonRoomType(Integer.parseInt(split[6]));
        offer.setCommonDestinationCode(Integer.parseInt(split[7]));
        offer.setCommonHotelCode(Integer.parseInt(split[8]));
        offer.setCommonHotelCategory(Integer.parseInt(split[9]));
        offer.setDayOfWeek(Integer.parseInt(split[10]));
        return offer;
    }

    public static String offerV2ToLine(final OfferV2 offer, final String delimiter) {
        final StringJoiner joiner = new StringJoiner(delimiter);
        joiner.add(String.valueOf(offer.getAllocationInt()));
        joiner.add(String.valueOf(offer.getPrice()));
        joiner.add(String.valueOf(offer.getStartDate()));
        joiner.add(String.valueOf(offer.getStartDateLong()));
        joiner.add(String.valueOf(offer.getDuration()));
        joiner.add(String.valueOf(offer.getCityFrom()));
        joiner.add(String.valueOf(offer.getCommonMealType()));
        joiner.add(String.valueOf(offer.getCommonRoomType()));
        joiner.add(String.valueOf(offer.getCommonDestinationCode()));
        joiner.add(String.valueOf(offer.getCommonHotelCode()));
        joiner.add(String.valueOf(offer.getCommonHotelCategory()));
        joiner.add(String.valueOf(offer.getDayOfWeek()));
        //joiner.add(offer.getDomainId());
        return joiner.toString();
    }
}
