package pl.unstabler.jaegi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    public static final String GITHUB_README_URL = "https://github.com/unstabler/Jaegi/blob/master/README.md";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.webView = this.findViewById(R.id.webview);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(GITHUB_README_URL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.suicide();
        this.finish();
    }

    private void suicide() {
        // XXX: listener 트리거 시 MainActivity가 뜨는 것 방지
        // FIXME: 좀 더 깔끔한 방법을 쓰고 싶어
        android.os.Process.killProcess(
            android.os.Process.myPid()
        );
        System.exit(0);
    }
}
