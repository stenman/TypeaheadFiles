package se.perfektum.typeaheadfiles;

import com.sun.jna.Pointer;
import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class ServiceLauncher implements Daemon {

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

        while (!stop) {
            final Provider provider = Provider.getCurrentProvider(false);

            provider.register(KeyStroke.getKeyStroke("control shift H"), new HotKeyListener() {
                public void onHotKey(HotKey hotKey) {
                    System.out.println(hotKey);
//                    provider.reset();
//                    provider.stop();
                }
            });

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

}
