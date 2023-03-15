package com.example.put.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequestDto {

    private String name;
    private String age;
    private List<CarDto> carList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", carList=" + carList +
                '}';
    }

    /*
    {
        "name" : "",
        "age" : ,
        "car_list" : [
            {
                "name" : "BMW",
                "car_number" : "11가 1234",
            },{
                 "name" : "A4",
                "car_number" : "22가 3456",
            },
        ]
    }
     */
}
