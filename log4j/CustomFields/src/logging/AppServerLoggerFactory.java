package logging;

import org.apache.log4j.Category;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class AppServerLoggerFactory implements LoggerFactory
{
   protected String hostname;
   protected String server;
   protected String component;
   protected String version;   
   
   protected  AppServerLoggerFactory(
              String serverName,
                                        String componentName,
                                        String versionName )
   {
      try
      {
         hostname = java.net.InetAddress.getLocalHost().getHostName();
      }
      catch ( java.net.UnknownHostException uhe )
      {
         System.err.println("Could not determine local hostname.");
      }

      server    = serverName;
      component = componentName;
      version   = versionName;      
   }

    public Logger makeNewLoggerInstance(String name) {
       return new AppServerLogger( name,
                                                hostname,
                                                server,
                                                component,
                                                version);
    }
}