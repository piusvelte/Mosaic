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
package com.piusvelte.mosaic.server;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.piusvelte.mosaic.client.WebClientService;

@SuppressWarnings("serial")
public class WebClientServiceImpl extends RemoteServiceServlet implements
WebClientService {
	
	final static public UserService userService = UserServiceFactory.getUserService();

	@Override
	public String getUserNickname() throws IllegalArgumentException {
		if (userService.isUserLoggedIn())
			return userService.getCurrentUser().getNickname();
		return "Please sign in";
	}
	
	@Override
	public String getAuthenticationURL() throws IllegalArgumentException {
		if (userService.isUserLoggedIn())
			return userService.createLogoutURL(this.getThreadLocalRequest().getRequestURI());
		return userService.createLoginURL(this.getThreadLocalRequest().getRequestURI());
	}
	
}
