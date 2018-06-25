[![Build Status](https://travis-ci.org/daberni/crashlytics-logback-appender.svg?branch=master)](https://travis-ci.org/daberni/crashlytics-logback-appender)
[![JCenter](https://api.bintray.com/packages/daberni/oss/crashlytics-logback-appender/images/download.svg)](https://bintray.com/daberni/oss/crashlytics-logback-appender)

# Crashlytics Logback Appender

Simple logback appender to log to Crashlytics for enhanced crash reports.

## Usage

Add as dependency in your `build.gradle` file:

```
implementation 'com.github.daberni:crashlytics-logback-appender:0.2.3'
```

After setting up Fabric/Crashlytics you have to setup the appender for correct logging.

```java
public class AppApplication extends Application {
    
    @Override
    public void onCreate() {
          super.onCreate();

          Fabric.with(this, new Crashlytics());          
          CrashlyticsLogbackAppender.setup();
    }
}
```

## License

This project is licensed under the [Apache License Version 2.0](LICENSE).
