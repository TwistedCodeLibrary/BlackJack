// Main class

import java.util.Random;
import java.util.Scanner;

public class Main
{ // Begin Main

    public static void main(String[] args)
    { // Begin main()
        Card[] deck = new Card[312]; // Array of cards
        Card[] playerDeck = new Card[5];
        Card[] dealerDeck = new Card[5];

        Scanner in = new Scanner(System.in);

        int totalPValue = 0; // Sum of player's card values
        int totalDValue = 0; // Sum of dealer's card values

        // For loop to add number cards to deck
        for(int i = 0; i < 216; i++)
        {
            String cardValue = "two";
            if (i > 24)
            {
                cardValue = "three";
            }
            if (i > 48)
            {
                cardValue = "four";
            }
            if (i > 72)
            {
                cardValue = "five";
            }
            if (i > 96)

            {
                cardValue = "six";
            }
            if (i > 120)
            {
                cardValue = "seven";
            }
            if (i > 144)
            {
                cardValue = "eight";
            }
            if (i > 168)
            {
                cardValue = "nine";
            }
            if (i > 192)
            {
                cardValue = "ten";
            }

            Card tempCard = new Card();
            deck[i] = tempCard;
            deck[i].setType(cardValue);
        }

        // For loop to add face cards to deck
        for(int i = 0;i < 72; i++)
        {
            String faceType = "jack";

            if (i > 24)
            {
                faceType = "king";
            }

            if (i > 48)
            {
                faceType = "queen";
            }

            Card tempCard = new Card();
            deck[i + 216] = tempCard;
            deck[i + 216].setType(faceType);
        }

        // For loop to add ace cards to deck
        for(int i = 0; i < 24; i++)
        {
            Card tempCard = new Card();
            deck[i + 288] = new Card();
            deck [i + 288].setType("ace");
        }

        System.out.println("My face-up card:");
        for(int i = 0;i < 2; i++)
        {
            dealerDeck[i] = hit(deck);

            totalDValue = dealerDeck[i].getCardValue() + totalDValue;
        }
        System.out.println(dealerDeck[0].getType());
        System.out.println(dealerDeck[0].getCardValue());

        System.out.println(""); // Spacing

        boolean ace = false; // Ace value set to false by default

        System.out.println("Your cards:");
        for(int i = 0;i < 2; i++)
        {
            playerDeck[i] = hit(deck);
            System.out.println(playerDeck[i].getType());
            if (playerDeck[i].getType().equals("ace")) // If player has an ace in their deck
            {
                ace = true;
            }

            totalPValue = playerDeck[i].getCardValue() + totalPValue;
        }

        int playerDeckPointer = 2;
        int dealerDeckPointer = 2;

        if (!ace)
        {
            System.out.println(totalPValue);
        }

        if (ace && (totalPValue + 10) < 21)
        {
            System.out.println(totalPValue + " or " + (totalPValue + 10));
        }

        if (ace && (totalPValue + 10) == 21)
        {
            totalPValue = 21;
            System.out.print(totalPValue);
        }

        boolean stand = false;

        while (!stand)
        {
            if (totalPValue >= 21)
            {
                stand = true;
            }

            System.out.println(""); // Spacing
            System.out.println("Do you want to hit or stand:");
            String response = in.next();

            if (response.toUpperCase().equals("STAND"))
            {
                stand = true;
            }

            if (response.toUpperCase().equals("STAND") && ace && (totalPValue + 10) < 21)
            {
                stand = true;
                totalPValue = totalPValue + 10;
            }

            if (response.toUpperCase().equals("HIT"))
            {
                playerDeck[playerDeckPointer] = hit(deck);
                totalPValue = playerDeck[playerDeckPointer].getCardValue() + totalPValue;
                System.out.println(playerDeck[playerDeckPointer].getType());
                playerDeckPointer++;

                System.out.println(totalPValue);
            }

            if (playerDeck[4] != null)
            {
                stand = true;
            }

            if (playerDeck[4] != null && totalPValue <= 21)
            {
                System.out.println("5 Card!!!");
            }

            if (totalPValue == 21)
            {
                System.out.println("Blackjack!!!");
            }

            if (totalPValue > 21)
            {
                System.out.println(""); // Spacing
                System.out.println("You've gone and busted my good man.");
                System.out.println("You lost...");
                stand = true;
            }
        }

        System.out.println("Cards up!");
        System.out.println(totalDValue);

        while (totalDValue < totalPValue && totalPValue <= 21)
        {
            System.out.println("Hit me.");
            dealerDeck[dealerDeckPointer] = hit(deck);
            totalDValue = dealerDeck[dealerDeckPointer].getCardValue() + totalDValue;
            System.out.println(totalDValue);

        }

        if (totalDValue > totalPValue && totalDValue <= 21)
        {
            System.out.println(""); // Spacing
            System.out.println("You lost...");
        }

        if (totalDValue == totalPValue && totalPValue <= 21)
        {
            System.out.println("Draw.");
        }

        if (totalDValue <  totalPValue && totalPValue <= 21)
        {
            System.out.println("You win!!!");
        }

        if (totalDValue > 21 && totalPValue <= 21)
        {
            System.out.println("You win!!!");
        }

    } // End main()

    // Method to hit a random cart in the deck
    public static Card hit(Card[] exampleDeck)
    { // Begin take()
        Random rand = new Random();
        Card randomCard = null;


        while (randomCard == null)
        {
            int randomInt = rand.nextInt(312);
            randomCard = exampleDeck[randomInt];

            exampleDeck[randomInt] = null;
        }

        return randomCard;

    } // End take()

} // End Main
