package com.example.tpchifoumipoe.service;

import com.example.tpchifoumipoe.entities.Game;
import com.example.tpchifoumipoe.repository.GameDao;
import com.example.tpchifoumipoe.repository.IntGameDao;

public class GameService {
    private IntGameDao gameDao;
    private Game game;

    public GameService(IntGameDao gameDao) {
        this.gameDao=new GameDao();
        this.game = new Game();
    }

    public String serverChoice(){
        int num = (int)(Math.random()*3);
            if(num == 0){
                game.setServerChoice("PIERRE");
            return game.getServerChoice();
        }else if(num==1){
                game.setServerChoice("FEUILLE");
            return game.getServerChoice();
        }else if(num == 2){
                game.setServerChoice("CISEAUX");
            return game.getServerChoice();
        }
            return null;
    }
    public String checkWin(String userChoice, String serverChoice){
        this.game.setRound(this.game.getRound()+1);

        if ((userChoice.equals("PIERRE") && serverChoice.equals("FEUILLE")) || (userChoice.equals("CISEAUX") && serverChoice.equals("PIERRE")) || (userChoice.equals("FEUILLE") && serverChoice.equals("CISEAUX"))){
            this.game.setWinner("Server");
            return game.getWinner();
        } else if (userChoice.equals(serverChoice)) {
            this.game.setWinner("");
            this.game.setDraw(true);
            return game.getWinner();
        } else{
            this.game.setWinner("Player");
            return game.getWinner();
        }
    }
    public Game getGame() {
        return game;
    }
}
