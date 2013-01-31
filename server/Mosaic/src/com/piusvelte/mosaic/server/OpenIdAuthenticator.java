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
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.expressme.openid.Association;
import org.expressme.openid.Authentication;
import org.expressme.openid.Endpoint;
import org.expressme.openid.OpenIdManager;

public class OpenIdAuthenticator {
	
    static final String ATTR_MAC = "openid_mac";
    static final String ATTR_ALIAS = "openid_alias";

    private DatabaseManager databaseManager;
    
    private OpenIdManager manager;
    
    public OpenIdAuthenticator(DatabaseManager databaseManager, String realm, String returnto) {
    	this.databaseManager = databaseManager;
        manager = new OpenIdManager();
        manager.setRealm(realm);
        manager.setReturnTo(returnto);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op == null) {
            request.setCharacterEncoding("UTF-8");
        	Nonce.storeNonce(request.getParameter("openid.response_nonce"), databaseManager);
            // get authentication:
            byte[] mac_key = (byte[]) request.getSession().getAttribute(ATTR_MAC);
            String alias = (String) request.getSession().getAttribute(ATTR_ALIAS);
            Authentication authentication = manager.getAuthentication(request, mac_key, alias);
            response.setContentType("text/html; charset=UTF-8");
            Account.storeAccount(databaseManager, authentication.getIdentity(), authentication.getFirstname(), authentication.getLastname(), authentication.getEmail(), authentication.getGender(), authentication.getLanguage());
			PrintWriter pw = response.getWriter();
			pw.print("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>Mosaic</title></head><body>");
			pw.print("<h1>Welcome, " + authentication.getFullname() + "</h1>");
			pw.print("<p><a href=\"openid?op=Google\">Google</a></p>");
			pw.print("<p><a href=\"openid?op=Yahoo\">Yahoo</a></p>");
			pw.print("</body></html>");
			pw.flush();
            return;
        }
        if (op.equals("Google") || op.equals("Yahoo")) {
            // redirect to Google or Yahoo sign on page:
            Endpoint endpoint = manager.lookupEndpoint(op);
            Association association = manager.lookupAssociation(endpoint);
            request.getSession().setAttribute(ATTR_MAC, association.getRawMacKey());
            request.getSession().setAttribute(ATTR_ALIAS, endpoint.getAlias());
            String url = manager.getAuthenticationUrl(endpoint, association);
            response.sendRedirect(url);
        }
        else
            throw new ServletException("Unsupported OP: " + op);
    }
}