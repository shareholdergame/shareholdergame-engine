package com.shareholdergame.engine.game.core;

public class CardOption {

    private int major;

    private int minor;

    private CardOption(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public static CardOption of(int major, int minor) {
        return new CardOption(major, minor);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }
}
