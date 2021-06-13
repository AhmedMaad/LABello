package com.example.labello.branch;

public class BranchModel implements Comparable<BranchModel> {

    private double latitude;
    private double longitude;
    private String name;
    private Float distance;

    //Used for the static branches list
    public BranchModel(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    //Used for sorted branches
    public BranchModel(String name, Float distance) {
        this.name = name;
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public Float getDistance() {
        return distance;
    }

    @Override
    public int compareTo(BranchModel o) {
        return this.getDistance().compareTo(o.getDistance());
    }
}
