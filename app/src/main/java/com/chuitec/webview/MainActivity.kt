package com.chuitec.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity() {

    private lateinit var wb_webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wb_webView = findViewById<WebView>(R.id.wb_webView)
        webViewSetup()
    }


    private fun webViewSetup() {
        wb_webView.webViewClient = WebViewClient()
        wb_webView.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
        }
    }


    override fun onBackPressed() {
        if (wb_webView.canGoBack()) {
            wb_webView.goBack()
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}