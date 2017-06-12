package se.perfektum.typeaheadfiles;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO: de-couple the daemon from the keylistener!
public class ServiceLauncher implements Daemon {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLauncher.class);

    private static boolean stop = false;

    public static void startService() {
        logger.debug("Starting service");

        try {
            logger.debug("### About to register native hook");
            GlobalScreen.registerNativeHook();
            logger.debug("### native hook registered!");
        } catch (NativeHookException ex) {
            logger.debug("### Something went wrong!");
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        logger.debug("### About to add native key listener");
        GlobalScreen.addNativeKeyListener(new KeyListener());
        logger.debug("### native key listener registered!");
        while (!stop) {
            try {
                logger.debug("waiting for keypress...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopService() {
        logger.debug("Stopping service");
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
