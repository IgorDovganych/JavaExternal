package com.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Test_HTTP_XML {

    // URL WITH API KEY = http://api.openweathermap.org/data/2.5/weather?q=Kyiv&appid=53dd5d3eff5f9bcf16c761d39b22b296&mode=xml&units=metric
    public static void main(String[] args) {
        Test_HTTP_XML oobj_Test_HTTP_XML = new Test_HTTP_XML();
        oobj_Test_HTTP_XML.get_response("Kyiv");
    }

    public void get_response(String inputCity) {
        try {

            String api_key = "53dd5d3eff5f9bcf16c761d39b22b296";
            String format = "xml";
            String city = inputCity;

            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key + "&mode=" + format + "&units=metric";
            System.out.println(url);
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
             System.out.println(response.toString());

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(response.toString())));

            Node root = document.getDocumentElement();
            NodeList temperatureElements = ((Element) root).getElementsByTagName("temperature");

            NamedNodeMap temperatureAttributes;

            for(int i = 0; i<temperatureElements.getLength();i++){
                temperatureAttributes = temperatureElements.item(i).getAttributes();
                for( int j =0;j < temperatureAttributes.getLength(); j++ ){
                    //System.out.println(tepmeratureAttributes.item(j));
                    if(temperatureAttributes.item(j).getNodeName().equals("value")){
                        System.out.println("Temperature in Kyiv = " + temperatureAttributes.item(j).getNodeValue());
                        String lastUpdate = ((Element) root).getElementsByTagName("lastupdate").item(i).getAttributes().item(i).getNodeValue();
                        System.out.println("Last update = "+ lastUpdate);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
