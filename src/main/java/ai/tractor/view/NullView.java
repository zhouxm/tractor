package ai.tractor.view;

import ai.tractor.model.FriendCards;
import ai.tractor.model.Game;
import ai.tractor.model.Card;
import ai.tractor.model.Play;
import ai.tractor.model.Trick;

public class NullView extends View {
    public NullView(String name) {
        super(name);
    }

    @Override
    public void start() {
    }

    @Override
    public void createRoom() {
    }

    @Override
    public void closeRoom() {
    }

    @Override
    public void joinRoom() {
    }

    @Override
    public void leaveRoom() {
    }

    @Override
    public void requestStartGame() {
    }

    @Override
    public void startGame(Game game) {
    }

    @Override
    public void requestStartRound() {
    }

    @Override
    public void startRound() {
    }

    @Override
    public void requestFriendCards(int numFriends) {
    }

    @Override
    public void notifyCanMakeKitty(int kittySize) {
    }

    @Override
    public void drawCard(Card card, int playerID) {
    }

    @Override
    public void showCards(Play play) {
    }

    @Override
    public void selectFriendCards(FriendCards friendCards) {
    }

    @Override
    public void makeKitty(Play play) {
    }

    @Override
    public void playCards(Play play) {
    }

    @Override
    public void finishTrick(Trick trick, int winnerID) {
    }

    @Override
    public void endRound() {
    }

    @Override
    public void notify(String notification) {
    }

    @Override
    public void repaint() {
    }
}
