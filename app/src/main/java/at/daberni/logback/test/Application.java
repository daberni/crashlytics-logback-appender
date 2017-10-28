package at.daberni.logback.test;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.slf4j.LoggerFactory;

import at.daberni.logback.appender.CrashlyticsLogbackAppender;
import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Fabric;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(new Fabric.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .kits(new Crashlytics())
                //.debuggable(true)
                .build()
        );

        CrashlyticsLogbackAppender.setup();

        LoggerFactory.getLogger("Application").warn("startup");
    }
}
