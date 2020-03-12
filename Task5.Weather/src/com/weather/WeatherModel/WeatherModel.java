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
    //private String city;
    private User user;
    List<Observer> observers = new ArrayList<>();


    public WeatherModel(User user) {
        this.user = user;
        this.registerObserver(user);
    }



    public User getUser() {
        return user;
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
    public void notifyObservers() {
        System.out.println("########################");
        for (Observer observer : observers) {

            WeatherData weatherData = getWeatherDataFromResponse(observer.getCity());
            observer.update(weatherData);
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
        WeatherData weatherData = getWeatherDataFromResponse("Kyiv");
        System.out.println("Temperature - " + weatherData.getTemperature() + "| Last update - " + weatherData.getLastUpdate());

        //System.out.println(getTemperatureFromResponse("Kyiv"));
    }

//    public static String getTemperatureFromResponse(String inputCity) {
//        try {
//
//            String api_key = "53dd5d3eff5f9bcf16c761d39b22b296";
//            String format = "xml";
//            String city = inputCity;
//
//            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key + "&mode=" + format + "&units=metric";
//            URL obj = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(connection.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            Document document = documentBuilder.parse(new InputSource(new StringReader(response.toString())));
//
//            Node root = document.getDocumentElement();
//            NodeList temperatureElements = ((Element) root).getElementsByTagName("temperature");
//
//            NamedNodeMap temperatureAttributes;
//
//            for (int i = 0; i < temperatureElements.getLength(); i++) {
//                temperatureAttributes = temperatureElements.item(i).getAttributes();
//                for (int j = 0; j < temperatureAttributes.getLength(); j++) {
//
//                    if (temperatureAttributes.item(j).getNodeName().equals("value")) {
//                        String lastUpdate = ((Element) root).getElementsByTagName("lastupdate").item(i).getAttributes().item(i).getNodeValue();
//                        return temperatureAttributes.item(j).getNodeValue();
//                    }
//                    ;
//
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//            return "Nothing has found2";
//        }
//        return "Nothing has found3";
//    }


    public static WeatherData getWeatherDataFromResponse(String city){
        try {

            String api_key = "53dd5d3eff5f9bcf16c761d39b22b296";
            String format = "xml";
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key + "&mode=" + format + "&units=metric";

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(response.toString())));

            Node root = document.getDocumentElement();
            NodeList temperatureElements = ((Element) root).getElementsByTagName("temperature");

            NamedNodeMap temperatureAttributes;

//            NodeList humidityElements = ((Element) root).getElementsByTagName("humidity");
//            NamedNodeMap humidityAttributes = humidityElements.item(0).getAttributes();;
//            System.out.println(humidityAttributes.item(0).getNodeName().);
//
//            for(int k=0; k< humidityAttributes.getLength();k++){
//
//            }

            for (int i = 0; i < temperatureElements.getLength(); i++) {
                temperatureAttributes = temperatureElements.item(i).getAttributes();
                for (int j = 0; j < temperatureAttributes.getLength(); j++) {

                    if (temperatureAttributes.item(j).getNodeName().equals("value")) {
                        float temperature =  Float.parseFloat(temperatureAttributes.item(j).getNodeValue());

                        String lastUpdate = ((Element) root).getElementsByTagName("lastupdate").item(i).getAttributes().item(i).getNodeValue();
                        String humidity = ((Element) root).getElementsByTagName("humidity").item(0).getAttributes().item(1).getNodeValue();
                       // System.out.println(humidity);

                        return new WeatherData(temperature, lastUpdate, humidity);
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return null;
    }




}
