package se.perfektum.typeaheadfiles;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLauncher implements Daemon {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLauncher.class);

    public static void main(String args[]) {
        System.out.println("Hello, World!");
        logger.debug("Testing logger!");
    }

    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {

    }

    public void start() throws Exception {

    }

    public void stop() throws Exception {

    }

    public void destroy() {

    }
}
