package logging;

import org.apache.log4j.Priority;
import org.apache.log4j.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

public class AppServerLogger extends Logger
{
   protected String component;
   protected String hostname;
   protected String server;
   protected String version;   
   private static LoggerFactory factory = new AppServerLoggerFactory(null, null, null);

   protected  AppServerLogger(
                                 String categoryName,
                                 String hostname,
                                 String server,
                                 String component,
                                 String version )
   {
      super( categoryName );
      this.hostname  = hostname;
      this.server    = server;
      this.component = component;
      this.version   = version;
   }
   
   public String getComponent()
   { return (component == null ) ? "" : component; }

   public String getHostname()
   {  return ( hostname == null ) ? "" : hostname; }

   public String getServer()
   {  return ( server == null ) ? "" : server; }

   public String getVersion()
   {  return ( version == null ) ? "" : version; }

   protected void forcedLog( String    fqn,
                             Priority  priority,
                             Object    message,
                             Throwable t)
   {
      LoggingEvent event = new AppServerLoggingEvent(fqn, this, priority, message, t);
      callAppenders( event );
   }

   public static Logger getLogger(String name){
       return LogManager.getLogger(name, factory);
   }

   public void setComponent(String componentName)
   { component = componentName; }

   public static void setFactory(LoggerFactory factory)
   { AppServerLogger.factory = factory; }

   public void setHostname(String hostname)
   { this.hostname = hostname; }

   public void setServer(String serverName)
   { server = serverName; }

   public void setVersion(String versionName)
   { version = versionName; }
}