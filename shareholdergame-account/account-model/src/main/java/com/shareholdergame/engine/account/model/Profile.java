package com.shareholdergame.engine.account.model;

import org.apache.commons.lang3.builder.Builder;

import java.time.LocalDate;

public final class Profile {

    private Long gamerId;

    private Sex sex;

    private String country;

    private String stateProvince;

    private String city;

    private LocalDate birthday;

    private String about;

    private String avatarUrl;

    private String detectedCountry;

    private String detectedStateProvince;

    private String detectedCity;

    private Profile() {
    }

    private Profile(ProfileBuilder builder) {
        this.gamerId = builder.gamerId;
        this.sex = builder.sex;
        this.country = builder.country;
        this.stateProvince = builder.stateProvince;
        this.city = builder.city;
        this.birthday = builder.birthday;
        this.about = builder.about;
        this.avatarUrl = builder.avatarUrl;
        this.detectedCountry = builder.detectedCountry;
        this.detectedStateProvince = builder.detectedStateProvince;
        this.detectedCity = builder.detectedCity;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public Sex getSex() {
        return sex;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getDetectedCountry() {
        return detectedCountry;
    }

    public String getDetectedStateProvince() {
        return detectedStateProvince;
    }

    public String getDetectedCity() {
        return detectedCity;
    }

    public static ProfileBuilder builder() {
        return new ProfileBuilder();
    }

    public static class ProfileBuilder implements Builder<Profile> {

        private Long gamerId;
        private Sex sex;
        private String country;
        private String stateProvince;
        private String city;
        private LocalDate birthday;
        private String about;
        private String avatarUrl;
        private String detectedCountry;
        private String detectedStateProvince;
        private String detectedCity;

        private ProfileBuilder() {
        }

        public ProfileBuilder gamerId(Long gamerId) {
            this.gamerId = gamerId;
            return this;
        }

        public ProfileBuilder sex(Sex sex) {
            this.sex = sex;
            return this;
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

        public ProfileBuilder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public ProfileBuilder detectedCountry(String detectedCountry) {
            this.detectedCountry = detectedCountry;
            return this;
        }

        public ProfileBuilder detectedStateProvince(String detectedStateProvince) {
            this.detectedStateProvince = detectedStateProvince;
            return this;
        }

        public ProfileBuilder detectedCity(String detectedCity) {
            this.detectedCity = detectedCity;
            return this;
        }

        public ProfileBuilder profile(Profile profile) {
            this.gamerId = profile.gamerId;
            this.sex = profile.sex;
            this.country = profile.country;
            this.stateProvince = profile.stateProvince;
            this.city = profile.city;
            this.birthday = profile.birthday;
            this.about = profile.about;
            this.avatarUrl = profile.avatarUrl;
            this.detectedCountry = profile.detectedCountry;
            this.detectedStateProvince = profile.detectedStateProvince;
            this.detectedCity = profile.detectedCity;
            return this;
        }

        @Override
        public Profile build() {
            return new Profile(this);
        }


    }
}
