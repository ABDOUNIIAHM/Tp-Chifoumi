package com.example.tpchifoumipoe.entities;

public class Game {
    private int gameId;
    private int round;
    private String Winner;
    private Boolean isDraw=false;
    private String winner;
    private String serverChoice;
    private String userChoice;

    public Game(String serverChoice,String userChoice, String winner, int round){

        this.round = round;
        this.winner = winner;
        this.serverChoice=serverChoice;
        this.userChoice=userChoice;
    }

    public Game() {
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getServerChoice() {
        return serverChoice;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    public void setServerChoice(String serverChoice) {
        this.serverChoice = serverChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void setDraw(Boolean draw) {
        isDraw = draw;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public int getRound() {
        return round;
    }

    public String getWinner() {
        return Winner;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Boolean getIsDraw() {
        return isDraw;
    }}
