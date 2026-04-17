package Game.NumberGuessGameTemplate.src;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
    int guesses;
    int numToGuess;
    //= from low to high
    static Scanner sc = new Scanner(System.in);
    ArrayList<Integer> previousGuesses = new ArrayList<>();
    

    Game(int low, int high) {
        Random rand = new Random();
        guesses = 0;
        previousGuesses = new ArrayList<>();
        numToGuess = rand.nextInt(low, high);
        System.out.println("I'm thinking of a number from " + low + " to " + high);
        // when we create a game, we get a random number between low to high.
        // assign numToGuess to that random number.
        
    }

    void play() {
        int guess = getGuess();
        while (guess != numToGuess) {
            guesses++;
            if (guess >= numToGuess){
                System.out.println("The number's lower!");
            } else if (guess <= numToGuess) {
                System.out.println("The number is higher!");
            }
            guess = getGuess();
        }
        System.out.println("You guessed the number! Thanks for playing!");
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

}
