package org.e2e.modal;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Current{
    @JsonProperty("dt")
    public int getDt() {
        return this.dt; }
    public void setDt(int dt) {
        this.dt = dt; }
    int dt;
    @JsonProperty("sunrise")
    public int getSunrise() {
        return this.sunrise; }
    public void setSunrise(int sunrise) {
        this.sunrise = sunrise; }
    int sunrise;
    @JsonProperty("sunset")
    public int getSunset() {
        return this.sunset; }
    public void setSunset(int sunset) {
        this.sunset = sunset; }
    int sunset;
    @JsonProperty("temp")
    public double getTemp() {
        return this.temp; }
    public void setTemp(double temp) {
        this.temp = temp; }
    double temp;
    @JsonProperty("feels_like")
    public double getFeels_like() {
        return this.feels_like; }
    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like; }
    double feels_like;
    @JsonProperty("pressure")
    public int getPressure() {
        return this.pressure; }
    public void setPressure(int pressure) {
        this.pressure = pressure; }
    int pressure;
    @JsonProperty("humidity")
    public int getHumidity() {
        return this.humidity; }
    public void setHumidity(int humidity) {
        this.humidity = humidity; }
    int humidity;
    @JsonProperty("dew_point")
    public double getDew_point() {
        return this.dew_point; }
    public void setDew_point(double dew_point) {
        this.dew_point = dew_point; }
    double dew_point;
    @JsonProperty("uvi")
    public int getUvi() {
        return this.uvi; }
    public void setUvi(int uvi) {
        this.uvi = uvi; }
    int uvi;
    @JsonProperty("clouds")
    public int getClouds() {
        return this.clouds; }
    public void setClouds(int clouds) {
        this.clouds = clouds; }
    int clouds;
    @JsonProperty("visibility")
    public int getVisibility() {
        return this.visibility; }
    public void setVisibility(int visibility) {
        this.visibility = visibility; }
    int visibility;
    @JsonProperty("wind_speed")
    public double getWind_speed() {
        return this.wind_speed; }
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed; }
    double wind_speed;
    @JsonProperty("wind_deg")
    public int getWind_deg() {
        return this.wind_deg; }
    public void setWind_deg(int wind_deg) {
        this.wind_deg = wind_deg; }
    int wind_deg;

    @JsonProperty("wind_gust")
    public int getWind_gust() {
        return this.wind_gust; }
    public void setWind_gust(int wind_gust) {
        this.wind_gust = wind_gust; }
    int wind_gust;
    @JsonProperty("weather")
    public ArrayList<Weather> getWeather() {
        return this.weather; }
    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather; }
    ArrayList<Weather> weather;
    @JsonProperty("rain")
    public Rain getRain() {
        return this.rain; }
    public void setRain(Rain rain) {
        this.rain = rain; }
    Rain rain;
}


   
