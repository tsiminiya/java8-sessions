package com.enjoy.sessions.java8.interfaces.game;

import com.enjoy.sessions.java8.interfaces.utils.DeviceTypeUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameLoader {

    private GamePresenter gamePresenter;

    public void loadGame(Game game, String deviceType) {
        // this can be improved
        gamePresenter.present(game, DeviceTypeUtils.getScreenSize(DeviceType.valueOf(deviceType)));
    }

}
