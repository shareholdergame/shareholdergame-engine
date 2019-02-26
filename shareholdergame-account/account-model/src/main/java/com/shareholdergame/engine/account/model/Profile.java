package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDate;

public final class Profile {

    private String country;

    private String stateProvince;

    private String city;

    private LocalDate birthday;

    private String about;

    private Profile() {
    }

    private Profile(ProfileBuilder builder) {
        this.country = builder.country;
        this.stateProvince = builder.stateProvince;
        this.city = builder.city;
        this.birthday = builder.birthday;
        this.about = builder.about;
    }

    public String getCountry() {
        return country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAbout() {
        return about;
    }

    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }

    public static class ProfileBuilder implements Builder<Profile> {

        private String country;
        private String stateProvince;
        private String city;
        private LocalDate birthday;
        private String about;

        private ProfileBuilder() {
        }

        public ProfileBuilder country(String country) {
            this.country = country;
            return this;
        }

        public ProfileBuilder stateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
            return this;
        }

        public ProfileBuilder city(String city) {
            this.city = city;
            return this;
        }

        public ProfileBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public ProfileBuilder about(String about) {
            this.about = about;
            return this;
        }

        @Override
        public Profile build() {
            return new Profile(this);
        }
    }
}
