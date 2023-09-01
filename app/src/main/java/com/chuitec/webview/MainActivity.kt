package com.chuitec.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private lateinit var wb_webView: WebView
    private lateinit var swipeToRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeToRefresh = findViewById(R.id.swipeToRefresh)

        refreshApp()

        wb_webView = findViewById<WebView>(R.id.wb_webView)
        webViewSetup()
    }


    //swipe down to refresh the webview
    private fun refreshApp(){
        swipeToRefresh.setOnRefreshListener {
            swipeToRefresh.isRefreshing = false
            wb_webView.reload()
        }
    }


    //webview implementation
    private fun webViewSetup() {
        wb_webView.webViewClient = WebViewClient()
        wb_webView.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
            settings.allowFileAccess = true
        }
    }

    //stopping back button from existing the app. to be used to go back
    override fun onBackPressed() {
        if (wb_webView.canGoBack()) {
            wb_webView.goBack()
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}