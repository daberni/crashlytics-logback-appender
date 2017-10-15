package at.daberni.logback.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CrashActivity extends AppCompatActivity {

    private Logger LOG = LoggerFactory.getLogger("CrashActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        LOG.info("Some Test");
        LOG.warn("Winter is here!");

        LOG.warn("1");
        LOG.warn("2");
        LOG.warn("3");
        LOG.info("4");
        LOG.warn("5");
        LOG.warn("6");

        Crashlytics.getInstance().crash();
    }
}
