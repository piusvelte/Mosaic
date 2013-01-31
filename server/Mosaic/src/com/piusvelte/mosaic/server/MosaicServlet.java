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

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.oauth.OAuthService;
import com.google.appengine.api.oauth.OAuthServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class MosaicServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String url = req.getRequestURI();
		UserService userService = UserServiceFactory.getUserService();
		resp.setContentType("text/html");
		if (userService.isUserLoggedIn()) {
			Entity user = Users.store(userService.getCurrentUser());
			resp.getWriter().println("<p>Welcome, " + user.getProperty(Users.Columns.nickname.name()) + "</p>");
		} else {
			User user = null;
			try {
				OAuthService oauth = OAuthServiceFactory.getOAuthService();
				user = oauth.getCurrentUser();
			} catch (OAuthRequestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.getWriter().println("<p>Please <a href=\"" + userService.createLoginURL(url) + "\">sign in</a>.</p>");
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	}

}
