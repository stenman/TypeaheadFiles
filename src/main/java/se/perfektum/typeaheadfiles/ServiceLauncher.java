package se.perfektum.typeaheadfiles;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLauncher implements Daemon {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLauncher.class);
    private static boolean stop = false;

    public static void main(String args[]) {
        logger.debug("Testing logger!");
        System.out.println("Start GUI here if combo key was pressed!");
    }
    public static void startService() {
        System.out.println("Starting service");
        System.out.println("Waiting for combo key!");
        while (!stop) {
            try {
                // TODO Implement combo key listener here!
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("running");
        }
    }

    public static void stopService() {
        System.out.println("Stopping service");
        stop = true;
    }

    public static void windowsService(String args[]) {
        if ("start".equals(args[0])) {
            startService();
        } else if ("stop".equals(args[0])) {
            stopService();
        }
    }

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {

    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void destroy() {

    }

}
