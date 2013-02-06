/*
 * Mosaic - Location Based Messaging
 * Copyright (C) 2013 Bryan Emmanuel
 * 
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Bryan Emmanuel piusvelte@gmail.com
 */
package com.piusvelte.mosaic.android;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SignIn extends Activity {

	private static final String TAG = "SignIn";
	private ProgressDialog loadingDialog;
	protected OAuthManager oAuthManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadingDialog = new ProgressDialog(this);
		loadingDialog.setMessage("loading");
		loadingDialog.setCancelable(true);
		loadingDialog.show();
		oAuthManager = OAuthManager.getInstance(getString(R.string.consumer_key), getString(R.string.consumer_secret));
		try {
			oAuthManager.loadAuthURL(this);
			return;
		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthNotAuthorizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
		if (loadingDialog.isShowing())
			loadingDialog.dismiss();
	}

	protected void loadWebView(String url) {
		Log.d(TAG, "loadWebView, url: " + url);
		if (loadingDialog.isShowing())
			loadingDialog.dismiss();
		if (url != null) {
			WebView webView = new WebView(this);
			WebSettings webSettings = webView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			webSettings.setDefaultTextEncodingName("UTF-8");
			setContentView(webView);
			webView.setWebViewClient(new SignInWebViewClient(this));
			webView.loadUrl(url);
		} else
			finish();
	}
	
	protected void setVerifier(String verifier) {
		Log.d(TAG, "setVerifier");
		loadingDialog.show();
		oAuthManager.retrieveAccessToken(this, verifier);
	}
	
	protected void setTokenSecret(String token, String secret) {
		Log.d(TAG, "setTokenSecret");
		if (loadingDialog.isShowing())
			loadingDialog.dismiss();
		getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
		.edit()
		.putString(getString(R.string.preference_token), token)
		.putString(getString(R.string.preference_secret), secret)
		.commit();
		finish();
	}
}
