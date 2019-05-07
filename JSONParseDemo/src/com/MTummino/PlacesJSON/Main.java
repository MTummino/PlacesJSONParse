package com.MTummino.PlacesJSON;

import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

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

        JFrame f=new JFrame("Search Demo");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JTextField tfLat=new JTextField();
        final JTextField tfLon=new JTextField();
        final JTextField tfType=new JTextField();
        final JLabel lLat=new JLabel();
        final JLabel lLon =new JLabel();
        final JLabel lType=new JLabel();
        JLabel h1 = new JLabel();
        JLabel h2 = new JLabel();
        JLabel h3 = new JLabel();
        JLabel h4 = new JLabel();
        JLabel h5 = new JLabel();
        h1.setBounds(50,150, 400,20);
        h2.setBounds(50,180, 400,20);
        h3.setBounds(50,210, 400,20);
        h4.setBounds(50,240, 400,20);
        h5.setBounds(50,270, 400,20);
        tfLat.setText(lat);
        tfLon.setText(lon);
        tfType.setText(type);
        lLat.setText("Lat:");
        lLon.setText("Lon:");
        lType.setText("Type:");
        tfLat.setBounds(65,20, 150,20);
        tfLon.setBounds(65,50, 150,20);
        tfType.setBounds(65,80, 150,20);
        lLat.setBounds(10,20, 40,20);
        lLon.setBounds(10,50, 40,20);
        lType.setBounds(10,80, 40,20);

        JButton b=new JButton("Get Locations");
        b.setBounds(50,110,120,30);


        b.addActionListener(e ->
        {
            PlacesURL url = new PlacesURL(BASEURL, URLFORMAT, URLRADIUS, tfType.getText(), tfLat.getText(), tfLon.getText(), APIKEY);

            String getData = "";

            try
            {
                getData = DownloadURL.readUrl(url.getUrl());
            } catch (IOException x)
            {
                x.printStackTrace();
            }

            GooglePlace[] placeList = Parser.parse(getData);

            if(0 < placeList.length)
            {
                h1.setText(placeList[0].getName());
                h1.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(placeList[0].url));
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
            else
                h1.setText("");
            if(1 < placeList.length)
            {
                h2.setText(placeList[1].getName());
                h2.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(placeList[1].url));
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
            else
                h2.setText("");
            if(2 < placeList.length)
            {
                h3.setText(placeList[2].getName());
                h3.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(placeList[2].url));
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
            else
                h3.setText("");
            if(3 < placeList.length)
            {
                h4.setText(placeList[3].getName());
                h4.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(placeList[3].url));
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
            else
                h4.setText("");
            if(4 < placeList.length)
            {
                h5.setText(placeList[4].getName());
                h5.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI(placeList[4].url));
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
            else
                h5.setText("");


        });



        f.add(b);
        f.add(tfLat);
        f.add(tfLon);
        f.add(tfType);
        f.add(lLat);
        f.add(lLon);
        f.add(lType);
        f.add(h1);
        f.add(h2);
        f.add(h3);
        f.add(h4);
        f.add(h5);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);


       

    }

}
