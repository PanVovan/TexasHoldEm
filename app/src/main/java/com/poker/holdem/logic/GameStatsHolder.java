package com.poker.holdem.logic;

import com.poker.holdem.GameContract;
import com.poker.holdem.logic.player.Player;
import com.poker.holdem.server.deserialization.gamestarts.GameStartsResp;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameStatsHolder {
    private Player mainPlayer;
    private List<Player> players = new ArrayList<>();
    private List<Integer> deck = new ArrayList<>();
    private Integer bank;
    private Integer rate;
    private String lead;

    public void initPlayers(
            List<Player> allplayers
            ,List<Player> activePlayers
            ,Map<String, List<Integer>> playersCardsMap
            ,String mainName
    ){
        players = allplayers;

        //предопределяем всех неактивными
        for (Player i: players)
            i.setActive(false);
        //делаем активными всех, кто играет
        setActivePlayers(activePlayers);
        //...
        setGamePlayersCards(playersCardsMap);
        //чтобы каждый раз не искать
        mainPlayer = getPlayerByName(mainName);
    }

    private void setGamePlayersCards(Map<String, List<Integer>> cards){
        for(Player i: players)
            if(i.isActive())
                i.setCards(
                        cards.get(i.getName())
                );
    }

    private void setActivePlayers(List<Player> gamePlayers){
        for(Player i: gamePlayers)
            setPlayerActivity(i.getName(), true);
    }

    public void setPlayerActivity(String name, boolean activity){
        for(Player i: players)
            if(i.getName().equals(name))
                i.setActive(activity);
    }

    public void setPlayerCards(String name, List<Integer> cards){
        for(Player i: players)
            if(i.getName().equals(name))
                i.setCards(cards);
    }

    public Player getPlayerByName(String name){
        for(Player i: players)
            if (i.getName().equals(name))
                return i;
        return null;
    }

    public Player getMainPlayer(){ return mainPlayer; }

    public int getPosPlayer(String name){
        return players.indexOf(name);
    }

    public Integer getBank() {
        return bank;
    }

    public void setBank(Integer bank) {
        this.bank = bank;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public List<Integer> getDeck() {
        return deck;
    }

    public void setDeck(List<Integer> deck) {
        this.deck = deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
