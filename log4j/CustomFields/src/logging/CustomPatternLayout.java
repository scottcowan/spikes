package logging;

import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class CustomPatternLayout extends Layout{
    AppServerPatternLayout patternLayout;    

    public CustomPatternLayout() {
        this(PatternLayout.DEFAULT_CONVERSION_PATTERN);
    }

    CustomPatternLayout(String formatString) {
        patternLayout = new AppServerPatternLayout(formatString);
    }

    public String format(LoggingEvent event) {
        return patternLayout.format(event);
    }

    public boolean ignoresThrowable() {
        return true;
    }

    public void activateOptions() {        
    }

    public String getConversionPattern() {
        return patternLayout.getConversionPattern();
    }

    public void setConversionPattern(String conversionPattern) {
        patternLayout.setConversionPattern(conversionPattern);
    }

    

}
