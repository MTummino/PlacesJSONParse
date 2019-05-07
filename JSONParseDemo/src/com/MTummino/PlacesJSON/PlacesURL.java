package com.MTummino.PlacesJSON;

public class PlacesURL
{

	private String url;

	public PlacesURL(String base, String format, String radius, String type, String latitude, String longitude, String key)
	{
		url = base
			+ format +"?"
			+ "&radius=" +radius
			+ "&type=" +type
			+ "&location=" +latitude +"," +longitude
			+ "&key=" +key;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
