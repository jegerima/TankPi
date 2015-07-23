package com.works.jegerima.onixvisor;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class MainActivity extends ActionBarActivity {

    private WebView webFrame;
    private WebSettings webSettings;

    private String uri;

    private Button btn_left;
    private Button btn_right;
    private Button btn_up;
    private Button btn_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.uri = "http://192.168.65.164:5000";

        this.webFrame = (WebView) this.findViewById(R.id.webFrame);
        this.webSettings = this.webFrame.getSettings();
        this.webSettings.setJavaScriptEnabled(true);
        this.webSettings.setBuiltInZoomControls(true);
        this.webSettings.setSupportZoom(true);
        this.webFrame.setWebViewClient(new WebViewClient());
        this.webFrame.loadUrl(uri);

        /*
        this.btn_left = (Button) this.findViewById(R.id.btn_left);
        this.btn_right = (Button) this.findViewById(R.id.btn_right);
        this.btn_up = (Button) this.findViewById(R.id.btn_up);
        this.btn_down = (Button) this.findViewById(R.id.btn_down);



        /*
        this.btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest("/motor/l");

            }
        });
        this.btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest("/motor/r");
            }
        });
        this.btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest("/motor/u");
            }
        });
        this.btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest("/motor/d");
            }
        });*/
    }

    private void getRequest(String dir){
        new getRestRequest().execute(this.uri + dir);
        /*
        HttpResponse response = null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(this.uri + dir));
            System.out.println(this.uri + dir);
            response = client.execute(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
        */
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
            this.webFrame.loadUrl(this.uri);
        }

        return super.onOptionsItemSelected(item);
    }

    class getRestRequest extends AsyncTask <String,Void,String>{

        private Exception exception;

        @Override
        protected String doInBackground(String... urls){
            HttpResponse response = null;
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(urls[0]));
                System.out.println(urls[0]);
                response = client.execute(request);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return response.toString();
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            System.out.println(result);
        }
    }
}
