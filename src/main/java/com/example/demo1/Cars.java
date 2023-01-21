package com.example.demo1;


public class Cars {
    int date;
    String make;
    String model;
    int engineVolume;

    public Cars(int date, String make, String model, int engineVolume) {
        this.date = date;
        this.make = make;
        this.model = model;
        this.engineVolume = engineVolume;
    }

    public Cars() {
    }


    @Override
    public String toString() {
        return "Cars{" +
                "date=" + date +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
}
