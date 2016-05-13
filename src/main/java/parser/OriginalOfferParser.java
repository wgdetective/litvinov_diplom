package parser;

import model.OriginalOffer;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * Created by Wladimir Litvinov on 13.05.2016.
 */
public class OriginalOfferParser {

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
        joiner.add(String.valueOf(originalOffer.getStartDate()));               //5
        joiner.add(String.valueOf(originalOffer.getDuration()));                //6
        joiner.add(String.valueOf(originalOffer.getCityFrom()));                //7
        joiner.add(String.valueOf(originalOffer.getTransfer()));                //8
        joiner.add(String.valueOf(originalOffer.getInsurance()));               //9
        joiner.add(String.valueOf(originalOffer.getHotelStartDate()));          //10
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
}
