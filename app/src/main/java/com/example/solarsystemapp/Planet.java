package com.example.solarsystemapp;

public class Planet {
    private String mName;
    private String mType;
    private int mImage;
    private String mGravity;
    private String mMass;
    private String mVolume;
    private String mMeanDensity;
    private String mSurfaceArea;

    public Planet(String name, String type, int image, String gravity,
                  String mass, String volume, String meanDensity, String surfaceArea) {
        this.mName = name;
        this.mType = type;
        this.mImage = image;
        this.mGravity = gravity;
        this.mMass = mass;
        this.mVolume = volume;
        this.mMeanDensity = meanDensity;
        this.mSurfaceArea = surfaceArea;
    }

    public String getName() {
        return mName;
    }

    public String getType() {
        return mType;
    }

    public int getImage() {
        return mImage;
    }

    public String getGravity() {
        return mGravity;
    }

    public String getMass() {
        return mMass;
    }

    public String getVolume() {
        return mVolume;
    }

    public String getMeanDensity() {
        return mMeanDensity;
    }

    public String getSurfaceArea() {
        return mSurfaceArea;
    }
}
