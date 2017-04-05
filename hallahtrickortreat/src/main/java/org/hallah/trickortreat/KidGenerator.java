package org.hallah.trickortreat;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 4/3/17.
 */
public class KidGenerator implements Runnable{
    private final Logger log = Logger.getLogger(this.getClass());
    Halloween halloween;

    public KidGenerator(Halloween halloween)
    {
        this.halloween = halloween;
    }

    public void run()
    {
        while(true)
        {
            Kid kid = new Kid(halloween);

            Thread thKid = new Thread(kid);
            //kid.setId("Child "+thKid.getId());
            log.info("Child " + kid.getId() + " created");
            thKid.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*3));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}