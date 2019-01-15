package com.shareholdergame.engine.facade.dto.player;

import com.shareholdergame.engine.facade.dto.Link;

import java.util.Set;

public class PlayerPersonalInfo {

    private String birthday;

    private String about;

    private Set<Link> links;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }
}
