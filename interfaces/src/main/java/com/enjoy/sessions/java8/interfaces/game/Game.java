package com.enjoy.sessions.java8.interfaces.game;

public interface Game {

    void connect();

    default boolean isMobileReady() {
        return false;
    }

    default boolean isFeatured() {
        return false;
    }

    default boolean hasFreeTrial() {
        return false;
    }

    static ScreenSize getScreenSize(DeviceType deviceType) {
        switch (deviceType) {
            case PHONE:
                return ScreenSize.builder().height(500).width(378).build();
            case TABLET:
                return ScreenSize.builder().height(800).width(600).build();
            case DESKTOP:
            default:
                return ScreenSize.builder().height(1000).width(1500).build();
        }
    }

}
