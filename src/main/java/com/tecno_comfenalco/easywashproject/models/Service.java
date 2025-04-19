/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.models;

import java.time.Duration;

/**
 *
 * @author danil
 */
public class Service {

    private String name;
    private double price;
    private String description;
    private Duration duration;

    public Service(String name, double price, String description, Duration duration) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Service{" + "name=" + name + ", price=" + price + ", description=" + description + ", duration=" + duration + '}';
    }

}
