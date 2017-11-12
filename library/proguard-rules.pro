
-keep class at.daberni.logback.appender.CrashlyticsLogbackAppender
-keepclassmembers class at.daberni.logback.appender.CrashlyticsLogbackAppender {
	public *** *Encoder(...);
}
