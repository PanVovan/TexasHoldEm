package com.poker.holdem;

import com.poker.holdem.players.utils.Player;

public class GameLogic implements GameContract.Logic {
    @Override
    public int getCard() {

        return 0;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public void sendMessageOnServerFold() {

    }

    @Override
    public void sendMessageOnServerCheck() {

    }

    @Override
    public void sendMessageOnServerRaise(int rate) {

    }

    @Override
    public void sendMessageOnServerAllIn() {

    }

    @Override
    public void sendMessageOnServerLeave() {

    }

    @Override
    public void sendMessageOnServerStop() {

    }

    @Override
    public void sendMessageOnServerRestore() {

    }

    @Override
    public void sendMessageOnServerRegister() {

    }

    @Override
    public void sendMessageOnServerAuth() {

    }

    @Override
    public void sendMessageOnServerHandPower() {

    }

    @Override
    public void sendMessageOnServerEnterLobby() {

    }

    @Override
    public void sendMessageOnServerGetLobbies() {

    }
}