package org.hallah.trickortreat;
import org.apache.log4j.Logger;

class Riley implements Runnable
{
    private final Logger log = Logger.getLogger(this.getClass());
    Halloween halloween;


    public Riley(Halloween halloween)
    {
        this.halloween = halloween;
    }

    public void run() {

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley Started");
        while(true)
        {
            halloween.distributeCandy();
        }
    }
}