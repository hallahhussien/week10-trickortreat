package org.hallah.trickortreat;

/**
 * Created by student on 4/3/17.
 */
public class TrickOrTreat {

    public static void main(String a[]) {
        Halloween halloween = new Halloween();
        Riley riley = new Riley(halloween);
        KidGenerator kidGenerator = new KidGenerator(halloween);

        Thread thRiley = new Thread(riley);
        Thread thChild = new Thread(kidGenerator);

        System.out.println("Trick-Or-Treating begins");
        thChild.start();
        thRiley.start();
    }



}