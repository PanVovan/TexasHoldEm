package com.poker.holdem;

import android.app.Application;

import com.poker.holdem.constants.Constants;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class PokerApplicationManager extends Application {

    private Socket socket;
    private static PokerApplicationManager singleton;

    public Socket getSocket(){
        if (socket != null){
            return socket;
        }
        else {
            try {
                socket = IO.socket(Constants.SERVER_ADDR);
                return socket;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static PokerApplicationManager getInstance() {
        return singleton;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
