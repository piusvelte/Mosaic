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
package com.piusvelte.mosaic.gwt.server;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MosaicMessage {

	@Id @GeneratedValue
	private String id;
	private String title;
	private String body;
	private long created;
	private int latitude;
	private int minLatitude;
	private int maxLatitude;
	private int longitude;
	private int minLongitude;
	private int maxLongitude;
	private int radius;
	private long expiry;
	private int visits;
	private int reports;
	private boolean flagged;
	// select from MosaicMessage as MosaicMessage where :visitor in visitors
	private List<String> visitors;
	private String mosaicUserId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="mosaicUserId",referencedColumnName="id")
	private MosaicUser mosaicUser;

	public MosaicMessage() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getMinLatitude() {
		return minLatitude;
	}

	public void setMinLatitude(int minLatitude) {
		this.minLatitude = minLatitude;
	}

	public int getMaxLatitude() {
		return maxLatitude;
	}

	public void setMaxLatitude(int maxLatitude) {
		this.maxLatitude = maxLatitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getMinlongitude() {
		return minLongitude;
	}

	public void setMinLongitude(int minLongitude) {
		this.minLongitude = minLongitude;
	}

	public int getMaxLongitude() {
		return maxLongitude;
	}

	public void setMaxLongitude(int maxLongitude) {
		this.maxLongitude = maxLongitude;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public long getExpiry() {
		return expiry;
	}

	public void setExpiry(long expiry) {
		this.expiry = expiry;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getReports() {
		return reports;
	}

	public void setReports(int reports) {
		this.reports = reports;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public MosaicUser getMosaicUser() {
		return mosaicUser;
	}

	public void setMosaicUser(MosaicUser mosaicUser) {
		this.mosaicUser = mosaicUser;
	}

	public String getMosaicUserId() {
		return mosaicUserId;
	}

	public void setMosaicUserId(String mosaicUserId) {
		this.mosaicUserId = mosaicUserId;
	}

	public List<String> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<String> visitors) {
		this.visitors = visitors;
	}
	
}
