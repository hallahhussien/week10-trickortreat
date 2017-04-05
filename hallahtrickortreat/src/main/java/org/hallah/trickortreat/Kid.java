package org.hallah.trickortreat;
import org.apache.log4j.Logger;



public class Kid implements Runnable {

    private final Logger log = Logger.getLogger(this.getClass());
    private int id;
    private Halloween halloween;

    public Kid(Halloween halloween) {
        this.halloween = halloween;
      //  this.id = id;
    }


        public void run()
        {
            goTrickOrTreating();
        }


    private synchronized void goTrickOrTreating() {
        //add to the array list - wait to get candy
        halloween.addKid(this);

    }

    public int getId(){

        return id;

    }

}