package com.ferdilan.tesferdilan;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        WebView mywebView = (WebView) findViewById(R.id.webview);
//        ProgressBar load = (ProgressBar) findViewById(R.id.load);

        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tiktok.com");
        mywebView.getSettings().setLoadsImagesAutomatically(true);
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.getSettings().setDomStorageEnabled(true);

    }

    @Override
    public boolean onKeyDown ( int keyCode, KeyEvent event){
        WebView mywebView = (WebView) findViewById(R.id.webview);
        //Memreiksa apakah ada tombol kembali atau tidak dan memeriksa riwayat
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebView.canGoBack()) {
                mywebView.goBack();
                return true;
            }
            //Jika bukan tombol kembali atau tidak ada riawayat halaman web maka naikkan ke default
            //atau mungkin keluar dari aktivitas
            return super.onKeyDown(keyCode, event);
        }

//        class MyWebViewClient extends WebViewClient {
//            @Override
//            public boolean souldOverrideUrlLoading(WebView view, String url){
//                if("https://www.google.com".equals(Uri.parse(url).getHost())){
//                    return false;
//                }
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);
//                return true;
//            }
//        }

}