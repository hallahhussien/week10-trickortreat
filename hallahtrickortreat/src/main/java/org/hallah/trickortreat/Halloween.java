package org.hallah.trickortreat;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 4/3/17.
 */
public class Halloween {
    int maxKids;
    List<Kid> kidsAtDoor;
    private final Logger log = Logger.getLogger(this.getClass());

    public Halloween() {
        maxKids = 10;
        kidsAtDoor = new ArrayList<Kid>();
    }

    public void distributeCandy() {

        Kid kid;

        synchronized (kidsAtDoor) {

            if (kidsAtDoor.size() == 0) {
                try {
                    log.info("Riley watches TV");
                    kidsAtDoor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            log.info("Riley answers the door");
            kid = kidsAtDoor.get(0);
            kidsAtDoor.remove(0);
        }

        long duration=0;
        try
        {
            //log.info("Riley distributing the candy for child " + "'" + child.getName() + "'" );
            duration = (long)(Math.random()*3);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        log.info("Riley gives candy to " + kid.getId());


    }

    public void addKid(Kid kid) {

       log.info(kid.getId() + " rang doorbell");

        if (kidsAtDoor.size() == maxKids) {
            log.info(kid.getId() + " ran away");
            return;
        }

        synchronized (kidsAtDoor) {
            kidsAtDoor.add(kid);
            log.info(kid.getId() + " rings door bell");
            if (kidsAtDoor.size() == 1) {
                kidsAtDoor.notify();
            }

        }
    }

}