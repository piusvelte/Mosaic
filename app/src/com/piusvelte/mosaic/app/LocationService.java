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
package com.piusvelte.mosaic.app;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class LocationService extends Service implements LocationListener {

	private static final String preferenceToken = "oauth_token";
	private static final String preferenceSecret = "oauth_secret";

	protected OAuthManager oAuthManager;
	private LocationManager locationManager;
	protected int latitude = 0;
	protected int longitude = 0;
	protected List<Message> messages = new ArrayList<Message>();
	private MessageLoader messageLoader;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		start(intent);
		return START_STICKY;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}

	@Override
	public void onStart(Intent intent, int startId) {
		start(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private void start(Intent intent) {
		//TODO
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 10, this);
		} else {
			//TODO notify about no GPS
		}
	}

	private boolean hasSignedIn() {
		SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
		if (sharedPreferences.contains(preferenceToken) && sharedPreferences.contains(preferenceSecret)) {
			String token = sharedPreferences.getString(preferenceToken, null);
			String secret = sharedPreferences.getString(preferenceSecret, null);
			if ((token != null) && (secret != null)) {
				oAuthManager = OAuthManager.getInstance(getString(R.string.consumer_key), getString(R.string.consumer_secret), token, secret);
				return true;
			}
		}
		oAuthManager = OAuthManager.getInstance(getString(R.string.consumer_key), getString(R.string.consumer_secret));
		return false;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return iLocationService;
	}
	
	private void setCoordinates(Location location) {
		if (location != null) {
			latitude = (int) (location.getLatitude() * 1E6);
			longitude = (int) (location.getLongitude() * 1E6);
			if (iMain != null) {
				try {
					iMain.setCoordinates(latitude, longitude);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	protected void clearMessages() {
		messages.clear();
		if (iMain != null) {
			try {
				iMain.clearMessages();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void addMessage(String json) {
		try {
			messages.add(Message.messageFromJSONString(json));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (iMain != null) {
			try {
				iMain.addMessage(json);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void startMessageLoading() {
		messageLoader = new MessageLoader(this);
		messageLoader.execute();
	}
	
	protected void finishedMessageLoading() {
		if (iMain != null) {
			try {
				iMain.reloadListAdapter();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void doAuth(String url) {
		try {
			iMain.doAuth(url);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getAuthURL() {
		try {
			oAuthManager.loadAuthURL(this);
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
	}

	private IMain iMain;

	private ILocationService.Stub iLocationService = new ILocationService.Stub() {

		@Override
		public void getCoordinates() throws RemoteException {
			// TODO Auto-generated method stub
			setCoordinates(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
		}

		@Override
		public void checkGPS() throws RemoteException {
			// TODO Auto-generated method stub
			iMain.setGPSEnabled(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
		}

		@Override
		public void setCallback(IBinder mainBinder)
				throws RemoteException {
			// TODO Auto-generated method stub
			iMain = IMain.Stub.asInterface(mainBinder);
		}

		@Override
		public void checkSignIn() throws RemoteException {
			// TODO Auto-generated method stub
			if (!hasSignedIn())
				iMain.promptSignIn();
		}

		@Override
		public void loadAuthURL() throws RemoteException {
			// TODO Auto-generated method stub
			getAuthURL();
		}

		@Override
		public void loadMessages() throws RemoteException {
			// TODO Auto-generated method stub
			startMessageLoading();
		}

		@Override
		public void cancelMessages() throws RemoteException {
			// TODO Auto-generated method stub
			if (!messageLoader.isCancelled())
				messageLoader.cancel(true);
		}
	};

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		setCoordinates(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		if (LocationManager.GPS_PROVIDER.equals(provider) && (iMain != null)) {
			try {
				iMain.setGPSEnabled(false);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}
