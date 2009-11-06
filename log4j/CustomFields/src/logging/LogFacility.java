package logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.Logger;

public class LogFacility {

    private static Logger instance = null;
    static String name = "sportsintellect";

    public static void init(String name) {
        LogFacility.name = name;
    }

    private static Logger getInstance() {
        if (instance == null) {
            instance = Logger.getLogger(name);
        }
        return instance;
    }

    public static void debug(Object message) {
        getInstance().debug(message);
    }

    public static void debug(Object message, Throwable t) {
        getInstance().debug(message, t);
    }

    public static void error(String message) {
        getInstance().error(message);
    }

    public static void error(Exception ex){
        getInstance().error(exception2string(ex));
    }

    public static void error(Object message, Throwable t) {
        getInstance().error(message, t);
    }

    public static void fatal(Object message) {
        getInstance().fatal(message);
    }

    public static void fatal(Object message, Throwable t) {
        getInstance().fatal(message, t);
    }

    public static void info(Object message) {
        getInstance().info(message);
    }

    public static void info(Object message, Throwable t) {
        getInstance().info(message, t);
    }

    public static void warn(Object message) {
        getInstance().warn(message);
    }

    public static void warn(Object message, Throwable t) {
        getInstance().warn(message, t);
    }

    public static String exception2string(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString() + "——\r\n";
        } catch (Exception ex) {
            return "error converting exception to string";
        }
    }
}
