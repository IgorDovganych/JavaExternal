package com.weather.WeatherModel;

public class WeatherData {
    float temperature;
    String lastUpdate;
    String humidity;

    public WeatherData(float temperature, String lastUpdate, String humidity) {
        this.temperature = temperature;
        this.lastUpdate = lastUpdate;
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getHumidity() {
        return humidity;
    }
}
