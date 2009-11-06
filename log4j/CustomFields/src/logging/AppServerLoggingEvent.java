package logging;

import org.apache.log4j.Category;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

public class AppServerLoggingEvent extends LoggingEvent
                                   implements java.io.Serializable
{
   public String hostname;
   public String component;
   public String server;
   public String version;

   public AppServerLoggingEvent( String    fqnOfCategoryClass,
                                 AppServerLogger  category,
                                 Priority  priority,
                                 Object    message,
                                 Throwable throwable)
   {
      super( fqnOfCategoryClass,
             category,
             priority,
             message,
             throwable );

      hostname  = category.getHostname();
      component = category.getComponent();
      server    = category.getServer();
      version   = category.getVersion();
   }
}