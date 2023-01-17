// Playing card class

public class Card
{
    // Attributes
    private String type;   // Type of card (eg. king, queen, jack)
    private int cardValue; // Value of card (eg. king = 10, nine = 9)

    public Card(){};

    // Mutator methods
    public void setType(String type) {
        this.type = type;

        switch (type) {
            case "jack":
            case "king":
            case "queen":
            case "ten":
                this.cardValue = 10;
                break;
            case "ace":
                this.cardValue = 1;
                break;
            case "two":
                this.cardValue = 2;
                break;
            case "three":
                this.cardValue = 3;
                break;
            case "four":
                this.cardValue = 4;
                break;
            case "five":
                this.cardValue = 5;
                break;
            case "six":
                this.cardValue = 6;
                break;
            case "seven":
                this.cardValue = 7;
                break;
            case "eight":
                this.cardValue = 8;
                break;
            case "nine":
                this.cardValue = 9;
                break;

        }
    }

    // Accessor methods
    public int getCardValue() {
        return cardValue;
    } // Gets the value of the card

    public String getType() {
        return type;
    }        // Gets the type of card
}
