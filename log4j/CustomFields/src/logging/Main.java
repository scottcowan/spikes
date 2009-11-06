package logging;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

public class Main {
   private static String formatString =
      "----------------using in code appender----------------------%n" +
      "Time:      %d%n" +
      "Host:      %h%n" +
      "Server:    %s%n" +
      "Component: %b%n" +
      "Version:   %v%n" +
      "Priority:  %p%n" +
      "Thread Id: %t%n" +
      "Context:   %x%n" +
      "Message:   %m%n";

    public static void main(String[] args) {
        PropertyConfigurator.configure("customlog.properties");
        AppServerLoggerFactory factory;
        factory = new AppServerLoggerFactory("MyServer", "MyComponent", "1.0");
        AppServerLogger.setFactory(factory);
        //with_appender().info("logging config from code");
        without_appender().info("logging config from customlog.properties");
    }

    public static Logger with_appender(){
        Logger logger = AppServerLogger.getLogger("some.log");
        PatternLayout layout = new AppServerPatternLayout( formatString );
        logger.addAppender( new ConsoleAppender(layout) );
        return logger;
    }

    public static Logger without_appender(){
        return AppServerLogger.getLogger("some.log");
    }
}
