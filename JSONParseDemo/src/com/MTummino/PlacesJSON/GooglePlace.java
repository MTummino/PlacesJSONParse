package com.MTummino.PlacesJSON;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GooglePlace
{
	private String name;
	private String latitude;
	private String longitude;
	private String id;
	public String url;

	public String getName()
	{
		return name;
	}

	GooglePlace(String n, String lat, String lon, String i)
	{
		name = n;
		latitude = lat;
		longitude = lon;
		id = i;

		String query = "";

		try
		{
			query ="&destination="+ URLEncoder.encode(name, "UTF-8") +"&destination_place_id="+id;
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		url = "https://www.google.com/maps/dir/?api=1" + query;
	}

	GooglePlace()
	{

	}
}
