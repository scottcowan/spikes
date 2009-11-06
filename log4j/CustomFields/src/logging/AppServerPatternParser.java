package logging;

import org.apache.log4j.*;
import org.apache.log4j.helpers.FormattingInfo;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

public class AppServerPatternParser extends PatternParser
{
   static final char HOSTNAME_CHAR  = 'h';
   static final char SERVER_CHAR    = 's';
   static final char COMPONENT_CHAR = 'b';
   static final char VERSION_CHAR   = 'v';

   public AppServerPatternParser(String pattern)
   {
      super(pattern);
   }

   public void finalizeConverter(char formatChar)
   {
      PatternConverter pc = null;
      switch( formatChar )
      {
         case HOSTNAME_CHAR:
            pc = new HostnamePatternConverter( formattingInfo );
            currentLiteral.setLength(0);
            addConverter( pc );
            break;
         case SERVER_CHAR:
            pc = new ServerPatternConverter( formattingInfo );
            currentLiteral.setLength(0);
            addConverter( pc );
            break;
         case COMPONENT_CHAR:
            pc = new ComponentPatternConverter( formattingInfo );
            currentLiteral.setLength(0);
            addConverter( pc );
            break;
         case VERSION_CHAR:
            pc = new VersionPatternConverter( formattingInfo );
            currentLiteral.setLength(0);
            addConverter( pc );
            break;
         default:
            super.finalizeConverter( formatChar );
      }
   }

   private static abstract class AppServerPatternConverter extends PatternConverter
   {
      AppServerPatternConverter(FormattingInfo formattingInfo)
      {
         super(formattingInfo);
      }

      public String convert(LoggingEvent event)
      {
         String result = null;
         AppServerLoggingEvent appEvent = null;
         if(event instanceof AppServerLoggingEvent){
            appEvent = (AppServerLoggingEvent) event;
            result = convert( appEvent );
         }
         return result;
      }

      public abstract String convert( AppServerLoggingEvent event );
   }

   private static class HostnamePatternConverter extends AppServerPatternConverter
   {
      HostnamePatternConverter( FormattingInfo formatInfo )
      {  super( formatInfo );  }

      public String convert( AppServerLoggingEvent event )
      {  return event.hostname;  }
   }

   private static class ServerPatternConverter extends AppServerPatternConverter
   {
      ServerPatternConverter( FormattingInfo formatInfo )
      {  super( formatInfo );  }

      public String convert( AppServerLoggingEvent event )
      {  return event.server;  }
   }

   private static class ComponentPatternConverter extends AppServerPatternConverter
   {
      ComponentPatternConverter( FormattingInfo formatInfo )
      {  super( formatInfo );  }

      public String convert( AppServerLoggingEvent event )
      {  return event.component;  }
   }

   private static class VersionPatternConverter extends AppServerPatternConverter
   {
      VersionPatternConverter( FormattingInfo formatInfo )
      {  super( formatInfo );  }

      public String convert( AppServerLoggingEvent event )
      {  return event.version;  }
   }
}