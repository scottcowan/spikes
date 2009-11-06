package logging;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;

public class AppServerPatternLayout extends PatternLayout
{
   public AppServerPatternLayout()
   {
      this(DEFAULT_CONVERSION_PATTERN);
   }

   public AppServerPatternLayout(String pattern)
   {
      super(pattern);
   }

   public PatternParser createPatternParser(String pattern)
   {
      PatternParser result;
      if ( pattern == null )
         result = new AppServerPatternParser( DEFAULT_CONVERSION_PATTERN );
      else
         result = new AppServerPatternParser ( pattern );

      return result;
  }
}