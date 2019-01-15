package com.shareholdergame.engine.facade.dto;

/**
 * Date: 10/11/2018
 *
 * @author Aliaksandr Savin
 */
public class Location {

    private String country;

    private String stateProvince;

    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
