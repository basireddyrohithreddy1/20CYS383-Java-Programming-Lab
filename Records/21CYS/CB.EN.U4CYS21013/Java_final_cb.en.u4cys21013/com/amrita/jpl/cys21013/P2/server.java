package com.amrita.jpl.cys21013.P2;
/**
 * @author Rohith
 * @version 1.0
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Abstract class QuizGame
 * The functions in it will be overridden by its subclasses
 */
abstract class QuizGame {
    public abstract void startGame();
    public abstract void askQuestion();
    public abstract void evaluateAnswer(String answer);
}
/**
 * It is providing interface with the functions onQuestionAsked and onAnswerEvaluated.
 */
interface QuizGameListener {
    void onQuestionAsked(String question);
    void onAnswerEvaluated(boolean isCorrect);
}

/**
 * It is implementing the interface QuizGameListener and overridding its functions
 */
class QuizGameClient implements QuizGameListener {
    private QuizGameServer server;
    private Scanner scanner;

    /**
     *
     * @param server connects client to server
     */
    public QuizGameClient(QuizGameServer server) {
        this.server = server;
        this.scanner = new Scanner(System.in);
    }

    /**
     * sets the listener and starts the game
     */
    public void startGame() {
        server.setListener(this);
        server.startGame();
    }

    /**
     *
     * @param question the question to be asked
     */
    public void onQuestionAsked(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();
        server.evaluateAnswer(answer);
    }

    /**
     *
     * @param isCorrect evaluates whether answer is correct or not
     */
    public void onAnswerEvaluated(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("You answer is correct!!!");
        } else {
            System.out.println("Your answer is wrong!!!");
        }
    }
}

/**
 * This class has all the questions and answers, it asks the question and it also listens to the answer gotten from client.
 */
class QuizGameServer extends QuizGame {

    /**
     * has all questions
     */
    private String[] questions = {
            "1+1=",
            "Which country has the largest population?",
            "In which city is Amrita University main branch located?",
            "Who started WW2?"
    };

    /**
     * has all answers
     */
    private String[] answers = {
            "2",
            "India",
            "Coimbatore",
            "hitler"
    };

    private QuizGameListener listener;

    /**
     *
     * @param listener listens to the client
     */
    public void setListener(QuizGameListener listener) {
        this.listener = listener;
    }

    /**
     * starts the game
     */
    public void startGame() {
        askQuestion();
    }

    /**
     * asks a random question
     */
    public void askQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.length);
        String question = questions[index];
        listener.onQuestionAsked(question);
    }

    /**
     *
     * @param answer the answer to be evaluated
     */
    public void evaluateAnswer(String answer) {
        int index = -1;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equalsIgnoreCase(answer)) {
                index = i;
                break;
            }
        }
        boolean isCorrect = index != -1;
        listener.onAnswerEvaluated(isCorrect);
    }
}

/**
 * The main function
 */
public class server {
    public static void main(String[] args) {
        QuizGameServer server = new QuizGameServer();
    }
}
