package com.MTummino.PlacesJSON;

public class GooglePlace
{
	private String name;
	private String latitude;
	private String longitude;
	private String id;

	GooglePlace(String n, String lat, String lon, String i)
	{
		name = n;
		latitude = lat;
		longitude = lon;
		id = i;
	}

	GooglePlace()
	{

	}
}
