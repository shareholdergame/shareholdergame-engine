package com.shareholdergame.engine.account.model;

public class UserLocation {

    private String country;

    private String province;

    private String city;

    private UserLocation() {
    }

    private UserLocation(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public static UserLocation of(String country, String province, String city) {
        return new UserLocation(country, province, city);
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}
