package ai.tractor.view;

import ai.tractor.model.FriendCards;
import ai.tractor.model.Game;
import ai.tractor.model.Card;
import ai.tractor.model.Play;
import ai.tractor.model.Trick;
import ai.tractor.server.Server;
import ai.tractor.client.Client;

public abstract class View {
    public final String name;
    public final Server server;
    public final Client client;

    private int myPlayerID;

    public View(String name) {
        this.name = name;
        this.server = new Server(this);
        this.client = new Client(this);
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
