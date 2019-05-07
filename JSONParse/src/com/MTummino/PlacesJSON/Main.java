package com.MTummino.PlacesJSON;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        final String BASEURL =  Common.BASEURL;
        final String URLFORMAT = Common.URLFORMAT;
        final String URLRADIUS = Common.URLRADIUS;
        final String APIKEY = Common.APIKEY;
        String lat = "40.1767143";
        String lon = "-75.279443";
        String type = "park";

        PlacesURL url = new PlacesURL(BASEURL, URLFORMAT, URLRADIUS, type, lat, lon, APIKEY);
        String getData = "";

        try
        {
            getData = DownloadURL.readUrl(url.getUrl());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        //System.out.println(getData);
        Parser.parse(getData);
    }
}
