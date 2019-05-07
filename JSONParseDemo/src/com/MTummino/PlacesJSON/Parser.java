package com.MTummino.PlacesJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


class Parser
{
	private static GooglePlace getPlace(JSONObject googlePlaceJson)
	{
		GooglePlace place = new GooglePlace();
		String placeName = "----";
		String latitude= "";
		String longitude="";
		String id="";

		try {
			if (!googlePlaceJson.isNull("name")) {
				placeName = googlePlaceJson.getString("name");
			}
			
			double lat = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
			double lng = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
			
			latitude = Double.toString(lat);
			longitude = Double.toString(lng);
			
			id = googlePlaceJson.getString("id");

			place = new GooglePlace(placeName, latitude, longitude, id);


		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return place;

	}

	private static GooglePlace[] placesArray(JSONArray jsonArray)
	{
		int count = jsonArray.length();
		if(count > 5)
			count = 5;
		GooglePlace places[] = new GooglePlace[count];

		for(int i = 0; i<count;i++)
		{
			try {
				places[i] = getPlace((JSONObject) jsonArray.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return places;
	}

	static GooglePlace[] parse(String jsonData)
	{
		JSONArray jsonArray = null;
		JSONObject jsonObject;


		try {
			jsonObject = new JSONObject(jsonData);
			jsonArray = jsonObject.getJSONArray("results");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return placesArray(jsonArray);
	}
}
