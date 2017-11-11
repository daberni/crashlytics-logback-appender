package at.daberni.logback.appender;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import ch.qos.logback.classic.Level;
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

        Crashlytics.log(getLevelInt(eventObject.getLevel()), "", encoder.getLayout().doLayout(eventObject));
    }

    private int getLevelInt(Level level) {
        switch (level.levelInt) {
            case Level.ALL_INT:
                return Log.ASSERT;
            case Level.ERROR_INT:
                return Log.ERROR;
            case Level.WARN_INT:
                return Log.WARN;
            case Level.INFO_INT:
            default:
                return Log.INFO;
            case Level.DEBUG_INT:
                return Log.DEBUG;
            case Level.TRACE_INT:
                return Log.VERBOSE;

        }
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
