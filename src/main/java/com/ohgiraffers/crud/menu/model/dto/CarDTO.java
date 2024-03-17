package com.ohgiraffers.crud.menu.model.dto;

public class CarDTO {

    private int carCode;
    private String carCompany;
    private String carName;
    private String carNumber;

    public CarDTO() {
    }

    public int getCarCode() {
        return carCode;
    }

    public void setCarCode(int carCode) {
        this.carCode = carCode;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "carCode=" + carCode +
                ", carCompany='" + carCompany + '\'' +
                ", carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}

