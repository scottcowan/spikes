package logging;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
        PropertyConfigurator.configure("customlog.properties");
        setLogContext("MyServer", "MyComponent", "1.0");
        Logger log = LogManager.getLogger("some.log");        
        log.info("Hello");
    }

    public static void setLogContext(String serverName,String componentName, String versionName){
     try
      {
         MDC.put("Host", java.net.InetAddress.getLocalHost().getHostName());
      }
      catch ( java.net.UnknownHostException uhe )
      {
         System.err.println("Could not determine local hostname.");
      }

      MDC.put("Server", serverName);
      MDC.put("Component", componentName);
      MDC.put("Version", versionName);
    }
}
