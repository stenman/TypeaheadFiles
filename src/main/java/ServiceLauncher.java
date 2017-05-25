import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

public class ServiceLauncher implements Daemon {

    public static void main(String args[]) {
        System.out.println("Hello, World!");
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
