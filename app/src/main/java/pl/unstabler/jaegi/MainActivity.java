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
}
