package org.e2e.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Minutely{
    @JsonProperty("dt")
    public int getDt() {
        return this.dt; }
    public void setDt(int dt) {
        this.dt = dt; }
    int dt;
    @JsonProperty("precipitation")
    public double getPrecipitation() {
        return this.precipitation; }
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation; }
    double precipitation;
}