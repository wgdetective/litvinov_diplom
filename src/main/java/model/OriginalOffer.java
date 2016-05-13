package model;

import java.time.LocalDate;

/**
 * Created by Wladimir Litvinov on 13.05.2016.
 */
public class OriginalOffer {
    private String allocation;
    private long price;
    private int currencyCode;
    private int availability;
    private LocalDate startDate;
    private int duration;
    private int cityFrom;
    private int transfer;
    private int insurance;
    private LocalDate hotelStartDate;
    private int hotelDuration;
    private String quotaHotelCodes;
    private String quotaRoomCodes;
    private String quotaRoomCategories;
    private String flightCode;
    private String tariffKey;
    private String formattedDate;
    private String flightPaxes;
    private int commonMealType;
    private String mealTypes;
    private int commonRoomType;
    private String roomTypes;
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

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(final int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(final int availability) {
        this.availability = availability;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDate startDate) {
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

    public int getTransfer() {
        return transfer;
    }

    public void setTransfer(final int transfer) {
        this.transfer = transfer;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(final int insurance) {
        this.insurance = insurance;
    }

    public LocalDate getHotelStartDate() {
        return hotelStartDate;
    }

    public void setHotelStartDate(final LocalDate hotelStartDate) {
        this.hotelStartDate = hotelStartDate;
    }

    public int getHotelDuration() {
        return hotelDuration;
    }

    public void setHotelDuration(final int hotelDuration) {
        this.hotelDuration = hotelDuration;
    }

    public String getQuotaHotelCodes() {
        return quotaHotelCodes;
    }

    public void setQuotaHotelCodes(final String quotaHotelCodes) {
        this.quotaHotelCodes = quotaHotelCodes;
    }

    public String getQuotaRoomCodes() {
        return quotaRoomCodes;
    }

    public void setQuotaRoomCodes(final String quotaRoomCodes) {
        this.quotaRoomCodes = quotaRoomCodes;
    }

    public String getQuotaRoomCategories() {
        return quotaRoomCategories;
    }

    public void setQuotaRoomCategories(final String quotaRoomCategories) {
        this.quotaRoomCategories = quotaRoomCategories;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(final String flightCode) {
        this.flightCode = flightCode;
    }

    public String getTariffKey() {
        return tariffKey;
    }

    public void setTariffKey(final String tariffKey) {
        this.tariffKey = tariffKey;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(final String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getFlightPaxes() {
        return flightPaxes;
    }

    public void setFlightPaxes(final String flightPaxes) {
        this.flightPaxes = flightPaxes;
    }

    public int getCommonMealType() {
        return commonMealType;
    }

    public void setCommonMealType(final int commonMealType) {
        this.commonMealType = commonMealType;
    }

    public String getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(final String mealTypes) {
        this.mealTypes = mealTypes;
    }

    public int getCommonRoomType() {
        return commonRoomType;
    }

    public void setCommonRoomType(final int commonRoomType) {
        this.commonRoomType = commonRoomType;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(final String roomTypes) {
        this.roomTypes = roomTypes;
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
