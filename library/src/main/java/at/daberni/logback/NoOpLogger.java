package at.daberni.logback;

public class NoOpLogger implements io.fabric.sdk.android.Logger {

    @Override
    public boolean isLoggable(String tag, int level) {
        return false;
    }

    @Override
    public int getLogLevel() {
        return 0;
    }

    @Override
    public void setLogLevel(int logLevel) {
    }

    @Override
    public void d(String tag, String text, Throwable throwable) {
    }

    @Override
    public void v(String tag, String text, Throwable throwable) {
    }

    @Override
    public void i(String tag, String text, Throwable throwable) {
    }

    @Override
    public void w(String tag, String text, Throwable throwable) {
    }

    @Override
    public void e(String tag, String text, Throwable throwable) {
    }

    @Override
    public void d(String tag, String text) {
    }

    @Override
    public void v(String tag, String text) {
    }

    @Override
    public void i(String tag, String text) {
    }

    @Override
    public void w(String tag, String text) {
    }

    @Override
    public void e(String tag, String text) {
    }

    @Override
    public void log(int i, String tag, String text) {
    }

    @Override
    public void log(int i, String tag, String text, boolean forceLog) {
    }
}
