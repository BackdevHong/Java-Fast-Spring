package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String name;
    @JsonProperty("car_number")
    private String car_number;
    @JsonProperty("TYPE")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", car_number='" + car_number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
