package com.example.labello.testslibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class TestsLibraryModel implements Parcelable {

    private String name;
    private int picture;
    private String definition;
    private String prerequisite;
    private String requiredSample;
    private String orderedWhen;
    private String reportDelivery;
    private String whyToBeTested;

    public TestsLibraryModel(String name, int picture, String definition
            , String prerequisite, String requiredSample, String orderedWhen
            , String reportDelivery, String whyToBeTested) {
        this.name = name;
        this.picture = picture;
        this.definition = definition;
        this.prerequisite = prerequisite;
        this.requiredSample = requiredSample;
        this.orderedWhen = orderedWhen;
        this.reportDelivery = reportDelivery;
        this.whyToBeTested = whyToBeTested;
    }

    protected TestsLibraryModel(Parcel in) {
        name = in.readString();
        picture = in.readInt();
        definition = in.readString();
        prerequisite = in.readString();
        requiredSample = in.readString();
        orderedWhen = in.readString();
        reportDelivery = in.readString();
        whyToBeTested = in.readString();
    }

    public static final Creator<TestsLibraryModel> CREATOR = new Creator<TestsLibraryModel>() {
        @Override
        public TestsLibraryModel createFromParcel(Parcel in) {
            return new TestsLibraryModel(in);
        }

        @Override
        public TestsLibraryModel[] newArray(int size) {
            return new TestsLibraryModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public String getDefinition() {
        return definition;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public String getRequiredSample() {
        return requiredSample;
    }

    public String getOrderedWhen() {
        return orderedWhen;
    }

    public String getReportDelivery() {
        return reportDelivery;
    }

    public String getWhyToBeTested() {
        return whyToBeTested;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(picture);
        dest.writeString(definition);
        dest.writeString(prerequisite);
        dest.writeString(requiredSample);
        dest.writeString(orderedWhen);
        dest.writeString(reportDelivery);
        dest.writeString(whyToBeTested);
    }
}
