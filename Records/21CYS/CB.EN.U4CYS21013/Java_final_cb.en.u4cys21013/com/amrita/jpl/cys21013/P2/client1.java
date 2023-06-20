package com.amrita.jpl.cys21013.P2;
/**
 * @author Rohith
 * @version 1.0
 */

/**
 * starts the server and then calls it.
 */
public class client1 {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
        QuizGameClient client1 = new QuizGameClient(server);

        client1.startGame();

    }
}
