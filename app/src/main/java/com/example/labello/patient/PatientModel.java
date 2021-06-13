package com.example.labello.patient;

public class PatientModel {
    //todo ADD ID for a patient along wth the customer id

    private String customerID;
    private String userID;
    private String fName;
    private String mName;
    private String sName;
    private String phoneNo;
    private String medicalDesc;
    private int age;
    private String birthdate;
    private String branch;
    private String registerDate;

    public PatientModel(String customerID, String userID, String fName, String mName
            , String sName, String phoneNo, String medicalDesc, int age
            , String birthdate, String branch, String registerDate) {
        this.customerID = customerID;
        this.userID = userID;
        this.fName = fName;
        this.mName = mName;
        this.sName = sName;
        this.phoneNo = phoneNo;
        this.medicalDesc = medicalDesc;
        this.age = age;
        this.birthdate = birthdate;
        this.branch = branch;
        this.registerDate = registerDate;
    }

    public PatientModel(){
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getUserID() {
        return userID;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getsName() {
        return sName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getMedicalDesc() {
        return medicalDesc;
    }

    public int getAge() {
        return age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getBranch() {
        return branch;
    }

    public String getRegisterDate() {
        return registerDate;
    }
}
