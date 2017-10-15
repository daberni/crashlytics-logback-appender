package at.daberni.logback.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainActivity extends AppCompatActivity {

    private Logger LOG = LoggerFactory.getLogger("MainActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LOG.info("Some Test");
        LOG.warn("Winter is here!");

        LOG.warn("1");
        LOG.warn("2");
        LOG.warn("3");
        LOG.warn("4");
        LOG.warn("5");
        LOG.warn("6");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CrashActivity.class));
            }
        });
    }
}
