package JDRProject.fight;

import java.util.Random;

/**
 * Created by Maxime on 31-10-16.
 */
public class Damage {

    private int numberOfDice;
    private int diceType;
    private int offset;

    public Damage(int numberOfDice, int diceType, int offset) {
        this.numberOfDice = numberOfDice;
        this.diceType = diceType;
        this.offset = offset;
    }

    public int rollDices(){
        Random dice = new Random();
        int damages = 0;
        for(int i=0; i<numberOfDice; i++)
            damages += dice.nextInt(diceType-1)+1;
        return damages + offset;
    }

    public String toString(){
        return numberOfDice+"D"+diceType+"+"+offset;
    }
}
