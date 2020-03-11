package com.weather.WeatherModel;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherModel implements Subject {
    private String city;
    private User user;
    List<Observer> observers = new ArrayList<>();


    public WeatherModel(String city, User user) {
        this.city = city;
        this.user = user;
        this.registerObserver(user);
    }

    public String getCity() {
        return city;
    }

    public User getUser() {
        return user;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
        System.out.println("Observer is registered");
    }

    @Override
    public void notifyObservers(float temperature) {
        System.out.println("########################");
        for (Observer observer : observers) {

            String s = get_response(observer.getCity());
            float temper = Float.parseFloat(s);
            observer.update(temper);
        }
        System.out.println("########################");
        System.out.println("All Observers are notified");

    }

    public void showAllObservers() {
        System.out.println("==================================");
        System.out.println("Here is a list of all observers : ");
        for (Observer observer : observers) {
            System.out.println(observer.getName() + " - " + observer.getCity());
        }
    }

    public static void main(String[] args) {
        System.out.println(get_response("Kyiv"));
    }

    public static String get_response(String inputCity) {
        try {

            String api_key = "53dd5d3eff5f9bcf16c761d39b22b296";
            String format = "xml";
            String city = inputCity;

            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key + "&mode=" + format + "&units=metric";
            //System.out.println(url);
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            int responseCode = connection.getResponseCode();
            //System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            //System.out.println(response.toString());

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(response.toString())));

            Node root = document.getDocumentElement();
            NodeList temperatureElements = ((Element) root).getElementsByTagName("temperature");

            NamedNodeMap temperatureAttributes;

            for (int i = 0; i < temperatureElements.getLength(); i++) {
                temperatureAttributes = temperatureElements.item(i).getAttributes();
                for (int j = 0; j < temperatureAttributes.getLength(); j++) {
                    //System.out.println(tepmeratureAttributes.item(j));
                    if (temperatureAttributes.item(j).getNodeName().equals("value")) {
                        //System.out.println("Temperature in " +city+ " " + temperatureAttributes.item(j).getNodeValue());
                        String lastUpdate = ((Element) root).getElementsByTagName("lastupdate").item(i).getAttributes().item(i).getNodeValue();
                        //System.out.println("Last update = "+ lastUpdate);
                        return temperatureAttributes.item(j).getNodeValue();
                    }
                    ;

                }
            }

        } catch (Exception e) {
            System.out.println(e);
            return "Nothing has found2";
        }
        return "Nothing has found3";
    }


}
