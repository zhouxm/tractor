package cn.jj.ai.tractor.view;

import cn.jj.ai.tractor.model.Card;
import cn.jj.ai.tractor.model.FriendCards;
import cn.jj.ai.tractor.model.Game;
import cn.jj.ai.tractor.model.Play;
import cn.jj.ai.tractor.model.Trick;

public abstract class View {
    public final String name;

    private int myPlayerID;

    public View(String name) {
        this.name = name;
    }

    public boolean joinedGame() {
        return myPlayerID != 0;
    }

    public int getPlayerID() {
        return myPlayerID;
    }

    public void setPlayerID(int ID) {
        myPlayerID = ID;
    }

    public abstract void start();

    public abstract void createRoom();

    public abstract void closeRoom();

    public abstract void joinRoom();

    public abstract void leaveRoom();

    public abstract void requestStartGame();

    public abstract void startGame(Game game);

    public abstract void requestStartRound();

    public abstract void startRound();

    public abstract void requestFriendCards(int numFriends);

    public abstract void notifyCanMakeKitty(int kittySize);

    public abstract void drawCard(Card card, int playerID);

    public abstract void showCards(Play play);

    public abstract void selectFriendCards(FriendCards friendCards);

    public abstract void makeKitty(Play play);

    public abstract void playCards(Play play);

    public abstract void finishTrick(Trick trick, int winnerID);

    public abstract void endRound();

    public abstract void notify(String notification);

    public abstract void repaint();
}
