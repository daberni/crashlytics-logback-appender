package at.daberni.logback.appender;

import com.crashlytics.android.Crashlytics;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class CrashlyticsLogbackAppender extends AppenderBase<ILoggingEvent> {

    private static final int LOG_LEVEL_NONE = 0;

    private PatternLayoutEncoder encoder;

    @SuppressWarnings("unused")
    public PatternLayoutEncoder getEncoder() {
        return this.encoder;
    }

    @SuppressWarnings("unused")
    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (!isStarted()) {
            return;
        }

        Crashlytics.log(LOG_LEVEL_NONE, null, encoder.getLayout().doLayout(eventObject));
    }

    public static void setup() {
        final Thread.UncaughtExceptionHandler uncaught = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                uncaught.uncaughtException(t, e);
            }
        });
    }
}
