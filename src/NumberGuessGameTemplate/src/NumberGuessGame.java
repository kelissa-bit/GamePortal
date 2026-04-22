package NumberGuessGameTemplate.src;
import java.util.ArrayList;
import java.util.Scanner;

import Game.GameGeneric;
import Game.GameWriteable;

import java.util.Random;

//if ishighscore print it took you blank guesses! you beat your best score of blank1!
//if not say it took you blank guesses! your best score is blank1!

public class NumberGuessGame extends GameGeneric implements GameWriteable {
    int guesses;
    int numToGuess;
    //= from low to high
    Scanner sc;
    ArrayList<Integer> previousGuesses = new ArrayList<>();
    

    public NumberGuessGame(Scanner sc) {
        this.sc = sc;
        Random rand = new Random();
        guesses = 0;
        previousGuesses = new ArrayList<>();
        numToGuess = rand.nextInt(1, 100);
        // when we create a game, we get a random number between low to high.
        // assign numToGuess to that random number.
        
    }
    @Override
    public void play() {
        System.out.println("I'm thinking of a number from " + 1 + " to " + 100);
        int guess = getGuess();
        while (guess != numToGuess) {
            if (guess >= numToGuess){
                System.out.println("The number's lower!");
            } else if (guess <= numToGuess) {
                System.out.println("The number is higher!");
            }
            guess = getGuess();
        }
        System.out.println("You guessed the number in " + guesses + " guesses!");
    }

    int getGuess() {
    if (sc.hasNextInt()) {
        int guess = sc.nextInt();
        if (previousGuesses.contains(guess)) {
            System.out.println("You already guessed " + guess + "!");
            return getGuess();
        } else if (guess < 1 || guess > 100) {
            System.out.println("It's a number from 1 to 100!");
            return getGuess();
        }
        previousGuesses.add(guess);
        guesses++;
        return guess;
    } else {
        System.out.println("Please guess an integer!");
        sc.next();
        return getGuess();
    }
    }

    @Override
    public String getScore() {
        return String.valueOf(guesses);
    }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;
        return Integer.valueOf(score) < Integer.valueOf(currentHighScore);
    }
}