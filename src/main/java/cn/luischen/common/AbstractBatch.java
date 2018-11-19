package cn.luischen.common;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mason on 2017/1/19.
 */
public class AbstractBatch {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    int sleepTimeOut=1000;

    public void run()  {
        logger.debug("*********************************************");
        logger.debug("        "+this.getClass().getName()+"       ");
        logger.debug("*********************************************");


        Stopwatch stopwatch=Stopwatch.createStarted();

        preRunLoop(stopwatch);
        while (true) {
            stopwatch.reset();
            stopwatch.start();
            try {
                doRun(stopwatch);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopwatch.stop();
            logger.debug("------------------------------------------------------");
            logger.debug("用时:"+stopwatch.toString());
            logger.debug("------------------------------------------------------");
            try {
                Thread.sleep(sleepTimeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void preRunLoop(Stopwatch stopwatch){
        logger.debug("------------------------------------------------------");
        logger.debug("pre run loop");
        logger.debug("------------------------------------------------------");
    }

    protected void doRun(Stopwatch stopwatch){
        logger.debug("dorun...");
    }

    public int getSleepTimeOut() {
        return sleepTimeOut;
    }

    public void setSleepTimeOut(int sleepTimeOut) {
        this.sleepTimeOut = sleepTimeOut;
    }
}
