[![Build Status](https://travis-ci.org/daberni/crashlytics-logback-appender.svg?branch=master)](https://travis-ci.org/daberni/crashlytics-logback-appender)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.daberni/crashlytics-logback-appender.svg)](https://search.maven.org/#search%7Cga%7C1%7Ca%3A%22crashlytics-logback-appender%22)

# Crashlytics Logback Appender

Simple logback appender to log to Crashlytics for enhanced crash reports.

## Usage

Add as dependency in your `build.gradle` file:
```
compile 'com.github.daberni:crashlytics-logback-appender:0.1.0'
```

After setting up Fabric/Crashlytics you have to setup the appender for correct logging.

```java
class AppApplication extends Application {
    
    void onCreate() {
          Fabric.with(this, new Crashlytics());
          
          CrashlyticsLogbackAppender.setup();
    }
}
```

## License

This project is licensed under the [Apache License Version 2.0](LICENSE).
