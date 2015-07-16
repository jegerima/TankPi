package com.works.jegerima.onixvisor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {

    private WebView webFrame;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.webFrame = (WebView) this.findViewById(R.id.webFrame);
        this.webSettings = this.webFrame.getSettings();
        this.webSettings.setJavaScriptEnabled(true);
        this.webFrame.setWebViewClient(new WebViewClient());
        this.webFrame.loadUrl("http://192.168.0.3:5000");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            this.webFrame.loadUrl("https://developer.chrome.com/multidevice/webview/gettingstarted");
        }

        return super.onOptionsItemSelected(item);
    }
}
