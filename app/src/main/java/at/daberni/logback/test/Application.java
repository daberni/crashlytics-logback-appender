package at.daberni.logback.test;

import com.crashlytics.android.Crashlytics;

import org.slf4j.LoggerFactory;

import at.daberni.logback.appender.CrashlyticsLogbackAppender;
import at.daberni.logback.NoOpLogger;
import io.fabric.sdk.android.Fabric;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(new Fabric.Builder(this)
                .logger(new NoOpLogger())
                .kits(new Crashlytics())
                .build()
        );
        CrashlyticsLogbackAppender.setup();

        LoggerFactory.getLogger("Application").warn("startup");
    }
}
