package pl.unstabler.jaegi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class JDDumbListenerActivity extends Activity {
    static final String LOG_TAG = "JDDumbListenerActivity";
    static final String JACKD_PACKAGE = "mobi.jackd.android";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        if (intent != null) {
            this.processIntent();
        }

        this.finish();
    }

    private void processIntent() {
        Intent referrerIntent = this.getIntent();
        String referrer = this.getReferrer().getHost();


        Log.d(LOG_TAG, String.format("received intent from %s", referrer));

        if (!JACKD_PACKAGE.equals(referrer)) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setPackage("com.android.vending");
            intent.setData(referrerIntent.getData());
            this.startActivity(intent);
            return;
        }

        Log.d(LOG_TAG, String.format("uri [%s] has blocked;", referrerIntent.getData().toString()));
        Toast.makeText(this.getApplicationContext(), R.string.toast_blocked, Toast.LENGTH_SHORT).show();
    }
}
