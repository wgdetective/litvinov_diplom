package model;

import java.time.LocalDate;

/**
 * Created by Wladimir Litvinov on 13.05.2016.
 */
public class OfferV1 {
    private String allocation;
    private long price;
    private long startDate;
    private int duration;
    private int cityFrom;
    private int hotelDuration;
    private int commonMealType;
    private int commonRoomType;
    private int commonDestinationCode;
    private int commonHotelCode;
    private int commonHotelCategory;

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(final String allocation) {
        this.allocation = allocation;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public int getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(final int cityFrom) {
        this.cityFrom = cityFrom;
    }

    public int getHotelDuration() {
        return hotelDuration;
    }

    public void setHotelDuration(final int hotelDuration) {
        this.hotelDuration = hotelDuration;
    }

    public int getCommonMealType() {
        return commonMealType;
    }

    public void setCommonMealType(final int commonMealType) {
        this.commonMealType = commonMealType;
    }

    public int getCommonRoomType() {
        return commonRoomType;
    }

    public void setCommonRoomType(final int commonRoomType) {
        this.commonRoomType = commonRoomType;
    }

    public int getCommonDestinationCode() {
        return commonDestinationCode;
    }

    public void setCommonDestinationCode(final int commonDestinationCode) {
        this.commonDestinationCode = commonDestinationCode;
    }

    public int getCommonHotelCode() {
        return commonHotelCode;
    }

    public void setCommonHotelCode(final int commonHotelCode) {
        this.commonHotelCode = commonHotelCode;
    }

    public int getCommonHotelCategory() {
        return commonHotelCategory;
    }

    public void setCommonHotelCategory(final int commonHotelCategory) {
        this.commonHotelCategory = commonHotelCategory;
    }
}
