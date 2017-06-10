package se.perfektum.typeaheadfiles;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO: de-couple the daemon from the keylistener!
public class ServiceLauncher implements Daemon, NativeKeyListener {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLauncher.class);

    private static boolean stop = false;

    // TODO: This should be made dynamic, so the user can choose their own hot keys
    private static final int VK_LEFT = 0x25;

    public static void main(String args[]) {
        logger.debug("In main function...");
        // TODO: Start GUI here if combo key was pressed!
    }

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
        GlobalScreen.addNativeKeyListener(new ServiceLauncher());
        logger.debug("### native key listener registered!");
        while (!stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            logger.debug("Could not register hot key!");
//            logger.debug("Waiting for hot key to be pressed...");
//            logger.debug("Hot key pressed! Starting GUI...");
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

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        logger.debug("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        logger.debug("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_X) {
            try {
                logger.debug("Hot key pressed! Starting GUI...");
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        logger.debug("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}
